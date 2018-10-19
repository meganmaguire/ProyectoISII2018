/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Maru
 */
public class ManagerProductos {
    private List <Producto> listaProductos;
    private List <Compra> listaCompras;
    
    //Constructor
    public ManagerProductos(){
        this.listaProductos=new ArrayList();
        this.listaCompras=new ArrayList();
    }
    
    //Getters
    public List<Producto> getListaProductos(){
        return listaProductos;
        
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }
    
    //Setters
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    //Metodos para el manejo del maneger productos
    public void cargarProductos() throws SQLException{
        Connection con=null;
        PreparedStatement consulta=null;
        ResultSet datos=null;
        ConexionBD.createConexionBD();
        con = (Connection) ConexionBD.getConexionBD();
        consulta =con.prepareStatement("SELECT * FROM Industriales");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
        consulta =con.prepareStatement("SELECT * FROM Artesanales");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
        consulta =con.prepareStatement("SELECT * FROM Tragos");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
        consulta =con.prepareStatement("SELECT * FROM Narguiles");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
        consulta =con.prepareStatement("SELECT * FROM Gaseosas");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
        consulta =con.prepareStatement("SELECT * FROM Vinos");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
        consulta =con.prepareStatement("SELECT * FROM Pizzas");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
        consulta =con.prepareStatement("SELECT * FROM Picadas");
        datos=consulta.executeQuery();
        while(datos.next()){
            Producto p= (Producto) datos;
            listaProductos.add(p);
        }
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
    
    //Genera una compra, la carga en la base de datos y actualiza el stock
    public void realizarCompra(Compra c) throws SQLException {
        Stock stock=null;
        listaCompras.add(c);
        Iterator i=c.getRenglonesDeCompra().iterator();
        while(i.hasNext()){
            Renglon renglon=(Renglon) i.next();
            Producto p=renglon.getProducto();
            if(p instanceof Gaseosa){
                Gaseosa g=(Gaseosa) p;
                stock.setStockActual((g.getStock().getStockActual())+renglon.getCantidad());
                stock.setStockMinimo(g.getStock().getStockMinimo());
                g.setStock(stock);
            }
            if(p instanceof Vino){
                Vino vino= (Vino) p;
                stock.setStockActual((vino.getStock().getStockActual())+renglon.getCantidad());
                stock.setStockMinimo(vino.getStock().getStockMinimo());
                vino.setStock(stock);
            }
            if(p instanceof Industrial){
                Industrial ind=(Industrial) p;
                stock.setStockActual((ind.getStock().getStockActual())+renglon.getCantidad());
                stock.setStockMinimo(ind.getStock().getStockMinimo());
                ind.setStock(stock);
            }   
        }
    }
    
    public void agregarProducto(Producto p){
        listaProductos.add(p);
    }
    
    public void modificarProducto(Producto p1, Producto p2){
        listaProductos.remove(p1);  //elimina el producto a modificar
        listaProductos.add(p2);     //agrega el producto modificado
    }
    
    public void bajaProducto(Producto p){
        Iterator i= listaProductos.iterator();
        while(i.hasNext()){
            Producto prod = (Producto) i.next();
            if(prod.equals(p)){
                listaProductos.remove(p);
            }
        }
    }
}
