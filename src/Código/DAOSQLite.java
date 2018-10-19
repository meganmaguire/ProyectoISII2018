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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maru
 */
public class DAOSQLite implements DAO{

    public List readeVentas(){
        List<Venta> listaVentas=new ArrayList();
        try {
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Ventas");
            datos=consulta.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;
    }

    public List readeCompras() {
        List <Compra> listaCompras= new ArrayList();
        try {
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Compras");
            datos=consulta.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompras;
    }

    public List readeIndustriales() {
        List<Industrial> listaIndustriales=new ArrayList();
        try {
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Industriales");
            datos=consulta.executeQuery();
            while(datos.next()){
                Industrial industrial= (Industrial) datos;
                listaIndustriales.add(industrial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIndustriales;
    }

    public List readeArtesanal() {
        List <Artesanal> listaArtesanales=new ArrayList();
        try { 
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Artesanales");
            datos=consulta.executeQuery();
            while(datos.next()){
                Artesanal artesanal= (Artesanal) datos;
                listaArtesanales.add(artesanal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaArtesanales;  
    }

    public List readeTragos() {
        List <Trago> listaTragos=new ArrayList();
        try { 
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Tragos");
            datos=consulta.executeQuery();
            while(datos.next()){
                Trago trago= (Trago) datos;
                listaTragos.add(trago);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTragos;
    }

    public List readeNarguiles() {
        List <Narguile> listaNarguiles=new ArrayList();
        try { 
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Narguiles");
            datos=consulta.executeQuery();
            while(datos.next()){
                Narguile narguile= (Narguile) datos;
                listaNarguiles.add(narguile);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaNarguiles;
    }

    public List readeGaseosas() {
        List <Gaseosa> listaGaseosas= new ArrayList();
        try { 
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Gaseosas");
            datos=consulta.executeQuery();
            while(datos.next()){
                Gaseosa gaseosa= (Gaseosa) datos;
                listaGaseosas.add(gaseosa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaGaseosas;
    }

    public List readeVinos() {
        List <Vino> listaVinos= new ArrayList();
        try { 
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Vinos");
            datos=consulta.executeQuery();
            while(datos.next()){
                Vino vino= (Vino) datos;
                listaVinos.add(vino);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVinos;
    }

    public List readePizzas() {
        List <Pizza> listaPizzas= new ArrayList();
        try { 
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Pizzas");
            datos=consulta.executeQuery();
            while(datos.next()){
                Pizza pizza= (Pizza) datos;
                listaPizzas.add(pizza);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPizzas;
    }

    public List readePicadas() {
        List <Picada> listaPicadas= new ArrayList();
        try { 
            Connection con=null;
            PreparedStatement consulta=null;
            ResultSet datos=null;
            ConexionBD.createConexionBD();
            con = (Connection) ConexionBD.getConexionBD();
            consulta =con.prepareStatement("SELECT * FROM Picadas");
            datos=consulta.executeQuery();
            while(datos.next()){
                Picada picada= (Picada) datos;
                listaPicadas.add(picada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPicadas;
    }

    public boolean createVenta(Venta venta) {
        return true;
    }
    */
}
