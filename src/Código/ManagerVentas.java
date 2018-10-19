/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import BD.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Maru
 */
public class ManagerVentas {
    List <Venta> listaVentas;
    List <Compra> listaCompras;
    
    //Constructor
    public ManagerVentas(){
        listaVentas=new ArrayList();
        listaCompras=new ArrayList();
    }
    
    //Getters
    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    //Setters
    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    //Metodos para le manejo del manager ventas
    public List cargarVentas() throws SQLException{
        Connection con=null;
        PreparedStatement consulta=null;
        ResultSet datos=null;
        ConexionBD.createConexionBD();
        con = (Connection) ConexionBD.getConexionBD();
        consulta =con.prepareStatement("SELECT * FROM Ventas");
        datos=consulta.executeQuery();
        while(datos.next()){
            Venta v= (Venta) datos;
            listaVentas.add(v);
        }
        return listaVentas;
    }
    
    public List cargarCompras() throws SQLException{
        Connection con=null;
        PreparedStatement consulta=null;
        ResultSet datos=null;
        ConexionBD.createConexionBD();
        con = (Connection) ConexionBD.getConexionBD();
        consulta =con.prepareStatement("SELECT * FROM Compras");
        datos=consulta.executeQuery();
        while(datos.next()){
            Compra c= (Compra) datos;
            listaCompras.add(c);
        }
        return listaCompras;
    }
    
    public void balanceVentas(Date fecha1, Date fecha2){
        float totalVentas=0;
        float totalCompras=0;
        float totalDeTotales=0;
        Iterator i= listaVentas.iterator();
        while(i.hasNext()){
            Venta venta= (Venta) i.next();
            if(venta.getFecha().compareTo(fecha1) >=0 && venta.getFecha().compareTo(fecha2) <=0){
                totalVentas= totalVentas+venta.getPrecioTotal();
            }
        }
        Iterator j= listaCompras.iterator();
        while(j.hasNext()){
            Compra compra= (Compra) j.next();
            if(compra.getFecha().compareTo(fecha1) >=0 && compra.getFecha().compareTo(fecha2) <=0){
                totalCompras= totalCompras+compra.getPrecioTotal();
            }
        }
        totalDeTotales=totalVentas-totalCompras;
    }
    
    //Genera una venta, la carga en la base de datos y actualiza el stock
    public void agregarVenta(Venta v){
        Stock stock=null;
        listaVentas.add(v);
        Iterator i=v.getRenglonesDeVenta().iterator();
        while(i.hasNext()){
            Renglon renglon=(Renglon) i.next();
            Producto p=renglon.getProducto();
            if(p instanceof Gaseosa){
                Gaseosa g=(Gaseosa) p;
                stock.setStockActual((g.getStock().getStockActual())-renglon.getCantidad());
                stock.setStockMinimo(g.getStock().getStockMinimo());
                g.setStock(stock);
            }
            if(p instanceof Vino){
                Vino vino= (Vino) p;
                stock.setStockActual((vino.getStock().getStockActual())-renglon.getCantidad());
                stock.setStockMinimo(vino.getStock().getStockMinimo());
                vino.setStock(stock);
            }
            if(p instanceof Industrial){
                Industrial ind=(Industrial) p;
                stock.setStockActual((ind.getStock().getStockActual())-renglon.getCantidad());
                stock.setStockMinimo(ind.getStock().getStockMinimo());
                ind.setStock(stock);
            }   
        }
    }

}
