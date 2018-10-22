/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Maru
 */
public class ManagerProductos {
    DAOSQLite dao;
    
    public ManagerProductos(){
        dao= new DAOSQLite();
    }
    
    public List verCatálogo(){
        List<Producto> listado = new ArrayList();
        DAOSQLite dao = new DAOSQLite();
        
        listado.addAll(dao.readIndustriales());
        listado.addAll(dao.readArtesanales());
        listado.addAll(dao.readTragos());
        listado.addAll(dao.readNarguiles());
        listado.addAll(dao.readGaseosas());
        listado.addAll(dao.readVinos());
        listado.addAll(dao.readPizzas());
        listado.addAll(dao.readPicadas());
        
        return listado;
    }
    
    public Producto instanciarProducto(int id,String nombre,String instancia, float precio){
        Producto producto = null;
        switch(instancia){
            case "Industrial":  producto = new Industrial(); break;
            case "Artesanal" :  producto = new Artesanal(); break;
            case "Vino" :       producto = new Vino(); break;
            case "Gaseosa" :    producto = new Gaseosa(); break;
            case "Narguile" :   producto = new Narguile(); break;
            case "Pizza" :      producto = new Pizza(); break;
            case "Picada" :     producto = new Picada(); break;
            case "Trago" :      producto = new Trago();
        }
        producto.setId(id);
        producto.setNombreProducto(nombre);
        producto.setPrecioVenta(precio);
        
        return producto;
    }
    
   
}
