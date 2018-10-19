/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maru
 */
public class Trago extends Producto{
    private String nombre;
    private List <String> listaIngredientes;

    public Trago(String nombre,List<String> listaIngredientes, float precioVenta,String tipoProducto) {
        super(precioVenta,tipoProducto);
        this.nombre=nombre;
        this.listaIngredientes = listaIngredientes;
    }
    
    public Trago(){
        super();
        this.nombre="";
        this.listaIngredientes=new ArrayList ();
    }

    public String getNombre(){
        return nombre;
    }
    
    public List<String> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setListaIngredientes(List<String> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public void mostrarProducto() {
        System.out.println("Tipo de producto: "+super.getTipoProducto());
        System.out.println("Nombre: "+nombre);
        System.out.println("Id: "+super.getId());
        System.out.println("Lista de ingredientes: ");
        System.out.println(listaIngredientes.toString());
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
}
