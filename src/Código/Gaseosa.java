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

    public Gaseosa(String nombre,String sabor, float contenido, float precioCosto, Stock stock, float precioVenta,String tipoProducto) {
        super(precioVenta,tipoProducto);
        this.nombre=nombre;
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

    public String getNombre(){
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

    public void setNombre(String nombre){
        this.nombre=nombre;
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

    public void mostrarProducto() {
        System.out.println("Tipo de producto: "+super.getTipoProducto());
        System.out.println("Nombre: "+nombre);
        System.out.println("Id: "+super.getId());
        System.out.println("Sabor: "+sabor);
        System.out.println("Contenido: "+contenido);
        System.out.println("Precio de costo: "+precioCosto);
        System.out.println("Stock: ");
        System.out.println(stock.toString());
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
}
