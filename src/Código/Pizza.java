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
public class Pizza extends Producto{
    private String sabor;

    public Pizza(String sabor, float precioVenta, String nombreProducto) {
        super(precioVenta,nombreProducto);
        this.sabor = sabor;
    }
    
    public Pizza(){
        super();
        this.sabor="";
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: "+super.getNombreProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Sabor: "+sabor);
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
    public Pizza clone(){
        Pizza pizza = new Pizza();
        pizza.setId(this.getId());
        pizza.setPrecioVenta(this.getPrecioVenta());
        pizza.setNombreProducto(this.getNombreProducto());
        pizza.setSabor(this.getSabor());
        return pizza;
    }
    public String instance(){
        return "Pizza";
    }
}
