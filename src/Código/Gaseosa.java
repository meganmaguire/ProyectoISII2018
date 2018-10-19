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
    private String sabor;
    private float contenido;
    private float precioCosto;
    private Stock stock;

    public Gaseosa(String nombre,String sabor, float contenido, float precioCosto, Stock stock, float precioVenta,String nombreProducto) {
        super(precioVenta,nombreProducto);
        this.sabor = sabor;
        this.contenido = contenido;
        this.precioCosto = precioCosto;
        this.stock = stock;
    }

    public Gaseosa(){
        super();
        this.sabor="";
        this.contenido=0;
        this.precioCosto=0;
        this.stock= new Stock();
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
        System.out.println("Nombre: "+super.getNombreProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Sabor: "+sabor);
        System.out.println("Contenido: "+contenido);
        System.out.println("Precio de costo: "+precioCosto);
        System.out.println("Stock: ");
        System.out.println(stock.toString());
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
    
    public Gaseosa clone(){
        Gaseosa gas = new Gaseosa();
        
        gas.setId(this.getId());
        gas.setPrecioVenta(this.getPrecioVenta());
        gas.setNombreProducto(this.getNombreProducto());
        gas.setSabor(this.getSabor());
        gas.setContenido(this.getContenido());
        gas.setPrecioCosto(this.getPrecioCosto());
        gas.setStock(this.getStock());
        
        return gas;
    }
}
