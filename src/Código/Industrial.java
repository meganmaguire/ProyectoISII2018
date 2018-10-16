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
public class Industrial extends Cerveza{
    private String origen;
    private Stock stock;

    public Industrial(String origen, Stock stock, String nombre, String marca, String tipo, float precioCosto, float graduacionAlc, float contenido, float precioVenta) {
        super(nombre, marca, tipo, precioCosto, graduacionAlc, contenido, precioVenta);
        this.origen = origen;
        this.stock = stock;
    }
    
    public Industrial(){
        super();
        this.origen="";
        this.stock=stock;
    }

    public String getOrigen() {
        return origen;
    }
    
    public Stock getStock(){
        return stock;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }  
    
    public void setStock(Stock stock){
        this.stock=stock;
    }
}
