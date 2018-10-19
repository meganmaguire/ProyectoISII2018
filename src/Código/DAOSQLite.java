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

/**
 *
 * @author Maru
 */
public class DAOSQLite implements DAO{

   /* public void readeVentas() {
        Connection con=null;
        PreparedStatement consulta=null;
        ResultSet datos=null;
        ConexionBD.createConexionBD();
        con = (Connection) ConexionBD.getConexionBD();
        consulta =con.prepareStatement("SELECT * FROM Ventas");
        datos=consulta.executeQuery();
    }

    public void readeCompras() {
    }

    public void readeIndustriales() {
    }

    public void readeArtesanal() {
    }

    public void readeTragos() {
    }

    public void readeNarguiles() {
    }

    public void readeGaseosas() {
    }

    public void readeVinos() {
    }

    public void readePizzas() {
    }

    public void readePicadas() {
    }

    public void createVenta(Venta venta) {
    }
    
}
