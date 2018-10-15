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
public class Gaseosa extends Producto{
    private String nombre;
    private String sabor;
    private float contenido;
    private float precioCosto;
    private Stock stock;

    public Gaseosa(String nombre, String sabor, float contenido, float precioCosto, Stock stock, float precioVenta) {
        super(precioVenta);
        this.nombre = nombre;
        this.sabor = sabor;
        this.contenido = contenido;
        this.precioCosto = precioCosto;
        this.stock = stock;
    }

    public Gaseosa(){
        super();
        this.nombre="";
        this.sabor="";
        this.contenido=0;
        this.precioCosto=0;
        this.stock= new Stock();
    }

    public String getNombre() {
        return nombre;
    }

    public String getSabor() {
        return sabor;
    }

    public float getContenido() {
        return contenido;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public Stock getStock(){
        return stock;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setContenido(float contenido) {
        this.contenido = contenido;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }
    
    public void setStock(Stock stock){
        this.stock=stock;
    }
}
