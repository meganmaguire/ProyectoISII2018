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
public abstract class Producto {
    private float precioVenta;

    public Producto(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public Producto(){
        this.precioVenta=0;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
}
