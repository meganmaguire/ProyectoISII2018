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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maru
 */
public class DAOSQLite implements DAO{
    Connection conn;
    Statement stmt;
    
    public List readVentas(){
        List<Venta> listaVentas=new ArrayList();
        Venta venta= new Venta();
        Renglon renglon=new Renglon();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM VENTAS,RENGLONES");
            while(resultado.next()){
                listaVentas.add(venta.clone());
            }
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return listaVentas;
    }

    public List readCompras() {
        List <Compra> listaCompras= new ArrayList();
        Compra compra= new Compra();
        Renglon renglon= new Renglon();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM COMPRAS,RENGLONES WHERE COMPRAS.C_ID = ");
            while(resultado.next()){
                listaCompras.add(compra.clone());
            } 
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return listaCompras;
    }

    public List readIndustriales() {
        List<Industrial> industriales = new ArrayList();
        Industrial ind = new Industrial();
        Stock stock;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,INDUSTRIALES WHERE PRODUCTOS.Prod_ID = INDUSTRIALES.Prod_ID");
            while(resultado.next()){
                ind.setId(resultado.getInt(1));
                ind.setPrecioVenta(resultado.getFloat(2));
                ind.setNombreProducto(resultado.getString(3));
                ind.setMarca(resultado.getString(6));
                ind.setTipo(resultado.getString(7));
                ind.setPrecioCosto(resultado.getFloat(8));
                ind.setGraduacionAlc(resultado.getFloat(9));
                ind.setContenido(resultado.getFloat(10));
                ind.setOrigen(resultado.getString(11));
                stock = new Stock(resultado.getInt(12),resultado.getInt(13));
                ind.setStock(stock);
                industriales.add(ind.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return industriales;
    }

    public List readArtesanal() {
        List<Artesanal> artesanales=new ArrayList();
        Artesanal art = new Artesanal();
        //Barril barril = new Barril();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,ARTESANALES WHERE PRODUCTOS.Prod_ID = ARTESANALES.Prod_ID");
            while(resultado.next()){
                art.setId(resultado.getInt(1));
                art.setPrecioVenta(resultado.getFloat(2));
                art.setNombreProducto(resultado.getString(3));
                art.setMarca(resultado.getString(6));
                art.setTipo(resultado.getString(7));
                art.setGraduacionAlc(resultado.getFloat(8));
                art.setContenido(resultado.getFloat(9));
                art.setColor(resultado.getString(10));
                art.setLupulo(resultado.getString(11));
                art.setMalta(resultado.getString(12));
                artesanales.add(art.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return artesanales;  
    }

    public List readTragos() {
        List<Trago> tragos=new ArrayList();
        Trago trago = new Trago();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,TRAGOS WHERE PRODUCTOS.Prod_ID = TRAGOS.Prod_ID");
            while(resultado.next()){
                trago.setId(resultado.getInt(1));
                trago.setPrecioVenta(resultado.getFloat(2));
                trago.setNombreProducto(resultado.getString(3));
                trago.setIngredientes(resultado.getString(6));
                tragos.add(trago.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return tragos;
    }

    public List readNarguiles() {
        List <Narguile> narguiles=new ArrayList();
        Narguile nar = new Narguile();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,NARGUILES WHERE PRODUCTOS.Prod_ID = NARGUILES.Prod_ID");
            while(resultado.next()){
                nar.setId(resultado.getInt(1));
                nar.setPrecioVenta(resultado.getFloat(2));
                nar.setNombreProducto(resultado.getString(3));
                nar.setTabaco(resultado.getString(6));
                narguiles.add(nar.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return narguiles;
    }

    public List readGaseosas() {
        List <Gaseosa> gaseosas= new ArrayList();
        Gaseosa gas = new Gaseosa();
        Stock stock;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,GASEOSAS WHERE PRODUCTOS.Prod_ID = GASEOSAS.Prod_ID");
            while(resultado.next()){
                gas.setId(resultado.getInt(1));
                gas.setPrecioVenta(resultado.getFloat(2));
                gas.setNombreProducto(resultado.getString(3));
                gas.setSabor(resultado.getString(6));
                gas.setContenido(resultado.getFloat(7));
                gas.setPrecioCosto(resultado.getFloat(8));
                stock = new Stock(resultado.getInt(9), resultado.getInt(10));
                gas.setStock(stock);
                gaseosas.add(gas.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return gaseosas;
    }

    public List readVinos() {
        List <Vino> vinos= new ArrayList();
        Vino vino = new Vino();
        Stock stock;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,VINOS WHERE PRODUCTOS.Prod_ID = VINOS.Prod_ID");
            while(resultado.next()){
                vino.setId(resultado.getInt(1));
                vino.setPrecioVenta(resultado.getFloat(2));
                vino.setNombreProducto(resultado.getString(3));
                vino.setBodega(resultado.getString(6));
                vino.setColor(resultado.getString(7));
                vino.setTipoDeUva(resultado.getString(8));
                vino.setGraduacionAlc(resultado.getFloat(9));
                vino.setPrecioCosto(resultado.getFloat(10));
                stock = new Stock(resultado.getInt(11),resultado.getInt(12));
                vino.setStock(stock);
                vinos.add(vino.clone());
            }
            
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return vinos;
    }

    public List readPizzas() {
        List <Pizza> pizzas= new ArrayList();
        Pizza pizza = new Pizza();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,PIZZAS WHERE PRODUCTOS.Prod_ID = PIZZAS.Prod_ID");
            while(resultado.next()){
                pizza.setId(resultado.getInt(1));
                pizza.setPrecioVenta(resultado.getFloat(2));
                pizza.setNombreProducto(resultado.getString(3));
                pizza.setSabor(resultado.getString(6));
                pizzas.add(pizza.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return pizzas;
    }

    public List readPicadas() {
        List <Picada> picadas= new ArrayList();
        Picada picada = new Picada();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,PICADAS WHERE PRODUCTOS.Prod_ID = PICADAS.Prod_ID");
            while(resultado.next()){
                picada.setId(resultado.getInt(1));
                picada.setPrecioVenta(resultado.getFloat(2));
                picada.setNombreProducto(resultado.getString(3));
                picada.setcPersonas(resultado.getInt(6));
                picadas.add(picada.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return picadas;
    }

    public boolean createVenta(Venta venta) {
        return true;
    }
}
