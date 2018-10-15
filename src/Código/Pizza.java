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

    public Pizza(String sabor, float precioVenta) {
        super(precioVenta);
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
}
