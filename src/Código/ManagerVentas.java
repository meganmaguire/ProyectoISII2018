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
        Renglon renglon= new Renglon();
        boolean respuesta;
        boolean exitoVenta;
        float total=0;
        float subtotal;
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            renglon.setIdProducto((int) tablaVentas.getValueAt(i, 0)); //en vez de categoria el id del producto
            renglon.setCantidad((int) tablaVentas.getValueAt(i,2));
            renglon.setId(venta.getId());
            respuesta=dao.createRenglon(renglon);
            subtotal=Float.parseFloat((String) tablaVentas.getValueAt(i,4));
            total=total+subtotal;
            if(!respuesta){
                return false;
            }
            else{
                actualizarStock((int)tablaVentas.getValueAt(i, 0),(int)tablaVentas.getValueAt(i,2));
            }
        }
        venta.setPrecioTotal(total);
        venta.setUsuario(nombreUsuario);
        exitoVenta=dao.createVenta(venta);
        if(exitoVenta){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void actualizarStock(int idProducto, int cantidad){
        int stock;
        float stockArt;
        float contenido;
        String tipoProducto=dao.consultarTipoProducto(idProducto);
        if(tipoProducto.equals("Industrial")){
            stock=dao.consultarStockIndustrial(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(tipoProducto.equals("Gaseosa")){
            stock=dao.consultarStockGaseosas(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(tipoProducto.equals("Vino")){
            stock=dao.consultarStockVinos(idProducto);
            dao.updateStockIndustriales(idProducto, (stock-cantidad));
        }
        if(tipoProducto.equals("Artesanal")){
            stockArt=dao.consultarStockArtesanal(idProducto);
            contenido=dao.consultarContenidoArtesanal(idProducto);
            dao.updateStockArtesanalas(idProducto, (stockArt-contenido*cantidad));
        }
    }
    
}
