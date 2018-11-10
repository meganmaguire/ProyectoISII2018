/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;

/**
 *
 * @author Maru
 */
public class ManagerVentas {
    DAOSQLite dao;
    
    public ManagerVentas(){
        dao= new DAOSQLite();
    }
    
    public Object[] balanceVentas(Date fecha1, Date fecha2){
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        Date fecha=null;
        Object[] balance= new Object[3];
        List <Venta> listaVentas= dao.readVentas();
        List <Compra> listaCompras= dao.readCompras();
        double totalVentas=0;
        double totalCompras=0;
        double totalDeTotales=0;
        Iterator i= listaVentas.iterator();
        while(i.hasNext()){
            Venta venta= (Venta) i.next();
            try{
                fecha=formato.parse(venta.getFecha());
            }
            catch(ParseException e){
                System.out.println("No se pudo parsear la fecha");
            }
            if(fecha.compareTo(fecha1) >=0 && fecha.compareTo(fecha2) <=0){
                totalVentas= totalVentas+venta.getPrecioTotal();
            }
        }
        balance[0]=totalVentas;
        Iterator j= listaCompras.iterator();
        while(j.hasNext()){
            Compra compra= (Compra) j.next();
            try{
                fecha= formato.parse(compra.getFecha());
            }
            catch(ParseException e){
                System.out.println("No se pudo parsear la fecha");
            }
            if(fecha.compareTo(fecha1) >=0 && fecha.compareTo(fecha2) <=0){
                totalCompras= totalCompras+compra.getPrecioTotal();
            }
        }
        balance[1]=totalCompras;
        totalDeTotales=totalVentas-totalCompras;
        balance[2]=totalDeTotales;
        return balance;
    }
    
    //Genera una venta, la carga en la base de datos y actualiza el stock
    public boolean realizarVenta(JTable tablaVentas,String nombreUsuario, float total){
        Venta venta= new Venta();
        boolean respuesta;
        boolean exitoVenta;
        venta.setPrecioTotal(total);
        venta.setUsuario(nombreUsuario);
        exitoVenta=dao.createVenta(venta);
        Renglon renglon= new Renglon();
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            renglon.cargarRenglon(renglon, Integer.parseInt(String.valueOf(tablaVentas.getValueAt(i, 0))), Integer.parseInt(String.valueOf(tablaVentas.getValueAt(i,3))), venta.getId());
            venta.agregarRenglon(renglon);
            respuesta=dao.createRenglonVenta(renglon);
            if(!respuesta){
                return false;
            }
            else{
                actualizarStock(String.valueOf(tablaVentas.getValueAt(i, 1)),Integer.parseInt(String.valueOf(tablaVentas.getValueAt(i, 0))),Integer.parseInt(String.valueOf(tablaVentas.getValueAt(i,3))));
            }
        }
        if(exitoVenta){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void actualizarStock(String categoria,int idProducto, int cantidad){
        int stock;
        float stockArt;
        float contenido;
        int idBarril;
        if(categoria.equals("Industrial")){
            stock=dao.consultarStockIndustrial(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(categoria.equals("Gaseosa")){
            stock=dao.consultarStockGaseosas(idProducto);
            dao.updateStockGaseosa(idProducto, (stock-cantidad));
        }
        if(categoria.equals("Vino")){
            stock=dao.consultarStockVinos(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(categoria.equals("Artesanal")){
            stockArt=dao.consultarStockArtesanal(idProducto);
            contenido=dao.consultarContenidoArtesanal(idProducto);
            idBarril=dao.consultarIdBarril(idProducto);
            dao.updateStockArtesanalas(idBarril, (stockArt-contenido*cantidad));
        }
    }
    
    public Map<String,String> mostrarRankingProductosVendidos(Date fecha1, Date fecha2){
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        Date fecha=null;
        int contador=0;
        List<Venta> listaVentas=dao.readVentas();
        List<Renglon> listaRenglones= new ArrayList();
        Map <String,Integer> ranking= new HashMap <>();
        Map <String,String> listaProductosRanking= new HashMap<>();
        Iterator iter = listaVentas.iterator();
        while(iter.hasNext()){
            Venta venta= (Venta) iter;
            try{
                fecha=formato.parse(venta.getFecha());
            }
            catch(ParseException e){
                System.out.println("No se pudo parsear la fecha");
            }
            if(fecha.compareTo(fecha1) >=0 && fecha.compareTo(fecha2) <=0){
                listaRenglones=dao.readRenglonesVenta(venta.getId());
                Iterator i= listaRenglones.iterator();
                while(i.hasNext()){
                    Renglon renglon= (Renglon) i;
                    String nombreProducto=dao.readNombreProducto(renglon.getIdProducto());
                    if(ranking.containsKey(nombreProducto)){
                        contador= renglon.getCantidad()+ranking.get(nombreProducto);
                        ranking.put(nombreProducto,contador);
                    }
                    else{
                        ranking.put(nombreProducto, renglon.getCantidad());
                    }
                }
            }
        }
        List <Map.Entry<String,Integer>> listaOrdenada= new LinkedList<Map.Entry<String,Integer>>(ranking.entrySet());
        Collections.sort(listaOrdenada, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });
        Collections.reverse(listaOrdenada);
        for (Map.Entry<String,Integer> x : listaOrdenada){
            String categoria= dao.readCategoriaProducto(x.getKey());
            listaProductosRanking.put(x.getKey(), categoria);
        }
        return listaProductosRanking;
    }
}
