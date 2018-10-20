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
    private int id;
    private Producto producto;

    public Renglon(int cantidad, Producto producto,int id) {
        this.cantidad = cantidad;
        this.producto=producto;
        this.id=id;
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
