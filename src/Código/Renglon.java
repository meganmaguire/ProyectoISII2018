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
public class Renglon {
    private int cantidad;
    private List <Producto> listaProductos;

    public Renglon(int cantidad, List<Producto> listaProductos) {
        this.cantidad = cantidad;
        this.listaProductos = listaProductos;
    }

    public Renglon(){
        this.cantidad=0;
        this.listaProductos=new ArrayList ();
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
