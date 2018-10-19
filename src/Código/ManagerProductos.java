/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author Maru
 */
public class ManagerProductos {
    DAOSQLite dao;
    
    public List verListado(){
        List <Producto> listaProductos= new ArrayList();
        Iterator i;
        List <Industrial> listaIndustriales= dao.readIndustriales();
        i= listaIndustriales.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        List <Artesanal> listaArtesanales= dao.readArtesanal();
        i= listaArtesanales.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        List <Trago> listaTragos= dao.readTragos();
        i= listaTragos.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        List <Narguile> listaNarguiles= dao.readNarguiles();
        i= listaNarguiles.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        List <Gaseosa> listaGaseosas= dao.readGaseosas();
        i= listaGaseosas.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        List <Vino> listaVinos= dao.readVinos();
        i= listaVinos.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        List <Pizza> listaPizzas= dao.readPizzas();
        i= listaPizzas.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        List <Picada> listaPicadas= dao.readPicadas();
        i= listaPicadas.iterator();
        while(i.hasNext()){
            listaProductos.add((Producto) i);
        }
        return listaProductos;
    }
}
