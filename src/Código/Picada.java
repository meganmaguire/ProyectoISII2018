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

    public Picada(int cPersonas, float precioVenta) {
        super(precioVenta);
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
}
