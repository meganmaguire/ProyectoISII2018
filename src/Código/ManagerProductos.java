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
    private DAO dao;
    
    public ManagerProductos(){
        this.dao = FactoryDAO.getDAO("bd");;
    }
    
    public List verCatálogo(){
        List<Producto> listado = new ArrayList();
        
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
        Producto producto = FactoryProducto.getProducto(instancia);
        producto.setId(id);
        producto.setNombreProducto(nombre);
        producto.setPrecioVenta(precio);
        
        return producto;
    }
    public float consultarPrecioVenta(int id){
        float precioVenta=dao.consultarPrecioProducto(id);
        return precioVenta;
        
    }
    
    public boolean modificarProducto(Producto producto){
        boolean exito = false;
        switch(producto.instance()){
            case "Industrial": exito = dao.updateIndustrial((Industrial)producto); break;
            case "Artesanal": exito = dao.updateArtesanal((Artesanal)producto); break;
            case "Vino": exito = dao.updateVino((Vino)producto); break;
            case "Gaseosa": exito = dao.updateGaseosa((Gaseosa)producto); break;
            case "Trago": exito = dao.updateTrago((Trago)producto); break;
            case "Narguile": exito = dao.updateNarguile((Narguile)producto); break;
            case "Pizza": exito = dao.updatePizza((Pizza)producto); break;
            case "Picada": exito = dao.updatePicada((Picada)producto);
        }
        
        return exito;
    }
    
    public boolean agregarProducto(Producto producto){
        boolean exito = false;
        //Agregar los métodos
        switch(producto.instance()){
            case "Industrial": exito = dao.createIndustrial((Industrial)producto); break;
            case "Artesanal": exito = dao.createArtesanal((Artesanal)producto); break;
            case "Vino": exito = dao.createVino((Vino)producto); break;
            case "Gaseosa": exito = dao.createGaseosa((Gaseosa)producto); break;
            case "Trago": exito = dao.createTrago((Trago)producto); break;
            case "Narguile": exito = dao.createNarguile((Narguile)producto); break;
            case "Pizza": exito = dao.createPizza((Pizza)producto); break;
            case "Picada": exito = dao.createPicada((Picada)producto);
        }
        
        return exito;
    }
    
    public List<Object[]> mostrarBarriles(){
        List<Object[]> barriles = dao.readBarriles();
        return barriles;
    }
}
