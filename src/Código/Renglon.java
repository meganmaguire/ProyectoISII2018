/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

/**
 *
 * @author Maru
 */
public class Renglon {
    private int cantidad;
    private Producto producto;

    public Renglon(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto=producto;
    }

    public Renglon(){
        this.cantidad=0;
        this.producto= null;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto=producto;
    }
}
