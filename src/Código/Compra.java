/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.text.SimpleDateFormat;
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
    private int id;

    public Compra(Date fecha, float precioTotal,List renglonesDeCompra, String usuario) {
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.renglonesDeCompra = renglonesDeCompra;
        this.usuario=usuario;
        this.id= (int) (Math.random() *100000) + 1; //mientras se crea un producto le sumo 1
    }
    
    public Compra(){
        this.fecha=null;
        this.precioTotal=0;
        this.renglonesDeCompra= new ArrayList();
        this.usuario="";
        this.id= (int) (Math.random() *100000) + 1; //mientras se crea un producto le sumo 1
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

    public int getId(){
        return id;
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
    
    public void setId(int id){
        this.id=id;
    }
    
    public void mostrarCompra(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha de compra: "+formato.format(fecha));
        System.out.println("Usuario: "+usuario);
        System.out.println("Id: "+id);
        System.out.println("Renglones: ");
        System.out.println(renglonesDeCompra.toString());
        System.out.println("Precio total: "+precioTotal);
    }
    
    public Compra clone(){
        Compra compra= new Compra();
        compra.setFecha(this.getFecha());
        compra.setUsuario(this.getUsuario());
        compra.setId(this.getId());
        compra.setRenglonesDeCompra(this.getRenglonesDeCompra());
        compra.setPrecioTotal(this.getPrecioTotal());
        return compra;
    }
}
