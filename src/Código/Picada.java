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
public class Picada extends Producto{
    private int cPersonas;

    public Picada(int cPersonas, float precioVenta,String nombreProducto) {
        super(precioVenta,nombreProducto);
        this.cPersonas = cPersonas;
    }
    
    public Picada(){
        super();
        this.cPersonas=0;
    }

    public int getcPersonas() {
        return cPersonas;
    }

    public void setcPersonas(int cPersonas) {
        this.cPersonas = cPersonas;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: "+super.getNombreProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Cantidad de personas: "+cPersonas);
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
    public Picada clone(){
        Picada picada = new Picada();
        picada.setId(this.getId());
        picada.setPrecioVenta(this.getPrecioVenta());
        picada.setNombreProducto(this.getNombreProducto());
        picada.setcPersonas(this.getcPersonas());
        return picada;
    }
    
    public String instance(){
        return "Picada";
    }
}
