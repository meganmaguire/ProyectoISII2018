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
public class Compra {
    private Date fecha;  //Puede no ser la fecha actual
    private float precioTotal;
    private List<Renglon> renglonesDeCompra;
    private String usuario;

    public Compra(Date fecha, float precioTotal,List renglonesDeCompra, String usuario) {
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.renglonesDeCompra = renglonesDeCompra;
        this.usuario=usuario;
    }
    
    public Compra(){
        this.fecha=null;
        this.precioTotal=0;
        this.renglonesDeCompra= new ArrayList();
        this.usuario="";
    }

    public Date getFecha() {
        return fecha;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }
    
    public List<Renglon> getRenglonesDeCompra() {
        return renglonesDeCompra;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public void setRenglonesDeCompra(List<Renglon> renglonesDeCompra) {
        this.renglonesDeCompra = renglonesDeCompra;
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
}
