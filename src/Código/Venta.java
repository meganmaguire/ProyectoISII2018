/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maru
 */
public class Venta {
    private Date fecha;
    private float precioTotal;
    private List<Renglon> renglonesDeVenta;

    public Venta(Date fecha, float precioTotal, List renglonesDeVenta) {
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.renglonesDeVenta = renglonesDeVenta;
    }
    
    public Venta(){
        this.fecha=null;
        this.precioTotal=0;
        this.renglonesDeVenta= new ArrayList(); 
    }

    public Date getFecha() {
        return fecha;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public List<Renglon> getRenglonesDeVenta() {
        return renglonesDeVenta;
    }

    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setRenglonesDeVenta(List<Renglon> renglonesDeVenta) {
        this.renglonesDeVenta = renglonesDeVenta;
    }
    
}
