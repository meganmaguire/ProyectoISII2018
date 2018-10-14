/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.Date;

/**
 *
 * @author Maru
 */
public class Compra {
    private Date fecha;
    private float precioTotal;

    public Compra(Date fecha, float precioTotal) {
        this.fecha = fecha;
        this.precioTotal = precioTotal;
    }
    
    public Compra(){
        this.fecha=null;
        this.precioTotal=0;
    }
    
}
