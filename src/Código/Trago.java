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
public class Trago extends Producto{
    private String ingredientes;

    public Trago(String nombre, String ingredientes, float precioVenta,String nombreProducto) {
        super(precioVenta,nombreProducto);
        this.ingredientes = ingredientes;
    }
    
    public Trago(){
        super();
        this.ingredientes="";
    }
    
    public String getIngredientes() {
        return ingredientes;
    }
    
    public void setIngredientes(String listaIngredientes) {
        this.ingredientes = listaIngredientes;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: "+super.getNombreProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Lista de ingredientes: ");
        System.out.println(ingredientes);
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
    
    public Trago clone(){
        Trago trago = new Trago();
        
        trago.setId(this.getId());
        trago.setPrecioVenta(this.getPrecioVenta());
        trago.setNombreProducto(this.getNombreProducto());
        trago.setIngredientes(this.getIngredientes());
        
        return trago;
    }
}
