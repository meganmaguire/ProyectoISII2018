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
    private List <String> listIngredientes;

    public Trago(String nombre, List<String> listIngredientes, float precioVenta) {
        super(precioVenta);
        this.nombre = nombre;
        this.listIngredientes = listIngredientes;
    }
    
    public Trago(){
        super();
        this.nombre="";
        this.listIngredientes=new ArrayList ();
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getListIngredientes() {
        return listIngredientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListIngredientes(List<String> listIngredientes) {
        this.listIngredientes = listIngredientes;
    }
}
