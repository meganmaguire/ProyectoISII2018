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
    private int id;
    private String nombreProducto;

    public Producto(float precioVenta,String nombreProducto) {
        this.precioVenta = precioVenta;
        this.id= (int) (Math.random() *100000) + 1; //mientras se crea un producto le sumo 1
        this.nombreProducto=nombreProducto;
    }
    
    public Producto(){
        this.precioVenta=0;
        this.id=(int) (Math.random() *100000) + 1;
        this.nombreProducto="";
    }

    public float getPrecioVenta() {
        return precioVenta;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto=nombreProducto;
    }
    
    public abstract void mostrarProducto();
    public abstract Producto clone();
    public abstract String instance();
}
