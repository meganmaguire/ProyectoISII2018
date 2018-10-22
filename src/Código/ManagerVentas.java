/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
    
    public List balanceVentas(Date fecha1, Date fecha2){
        List <Double> listaBalance=new ArrayList();
        List <Venta> listaVentas= dao.readVentas();
        List <Compra> listaCompras= dao.readCompras();
        double totalVentas=0;
        double totalCompras=0;
        double totalDeTotales=0;
        Iterator i= listaVentas.iterator();
        while(i.hasNext()){
            Venta venta= (Venta) i.next();
            if(venta.getFecha().compareTo(fecha1) >=0 && venta.getFecha().compareTo(fecha2) <=0){
                totalVentas= totalVentas+venta.getPrecioTotal();
            }
        }
        listaBalance.add(totalVentas);
        Iterator j= listaCompras.iterator();
        while(j.hasNext()){
            Compra compra= (Compra) j.next();
            if(compra.getFecha().compareTo(fecha1) >=0 && compra.getFecha().compareTo(fecha2) <=0){
                totalCompras= totalCompras+compra.getPrecioTotal();
            }
        }
        listaBalance.add(totalCompras);
        totalDeTotales=totalVentas-totalCompras;
        listaBalance.add(totalDeTotales);
        return listaBalance;
    }
    
    //Genera una venta, la carga en la base de datos y actualiza el stock
    public boolean realizarVenta(JTable tablaVentas,String nombreUsuario){
        List <Renglon> listaRenglones;
        Venta venta= new Venta();
        boolean respuesta;
        boolean exitoVenta;
        float total=0;
        float subtotal;
        venta.setPrecioTotal(total);
        venta.setUsuario(nombreUsuario);
        exitoVenta=dao.createVenta(venta);
        Renglon renglon= new Renglon();
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            venta.cargarRenglon(renglon, (int) tablaVentas.getValueAt(i, 0), (int) tablaVentas.getValueAt(i,2), venta.getId());
            venta.agregarRenglon(renglon);
            respuesta=dao.createRenglon(renglon);
            subtotal=Float.parseFloat((String) tablaVentas.getValueAt(i,4));
            total=total+subtotal;
            if(!respuesta){
                return false;
            }
            else{
                actualizarStock((String)tablaVentas.getValueAt(i, 1),(int)tablaVentas.getValueAt(i, 0),(int)tablaVentas.getValueAt(i,2));
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
        if(categoria.equals("Industrial")){
            stock=dao.consultarStockIndustrial(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(categoria.equals("Gaseosa")){
            stock=dao.consultarStockGaseosas(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(categoria.equals("Vino")){
            stock=dao.consultarStockVinos(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(categoria.equals("Artesanal")){
            stockArt=dao.consultarStockArtesanal(idProducto);
            contenido=dao.consultarContenidoArtesanal(idProducto);
            dao.updateStockArtesanalas(idProducto, (stockArt-contenido*cantidad));
        }
    }
    
}
