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
public class Venta {
    private List<Renglon> renglonesDeVenta;
    private Date fecha;
    SimpleDateFormat formato;
    private String fechaVenta;
    private String usuario;
    private float precioTotal;
    private int id;

    public Venta(float precioTotal, List renglonesDeVenta, String usuario) {
        this.fecha = new java.util.Date(); //fecha actual del sistema;
        formato = new SimpleDateFormat("dd/MM/yyyy");
        fechaVenta=formato.format(fecha);
        this.precioTotal = precioTotal;
        this.renglonesDeVenta = renglonesDeVenta;
        this.usuario=usuario;
        this.id= (int) (Math.random() *100000) + 1; //mientras se crea un producto le sumo 1
    }
    
    public Venta(){
        this.fecha=new java.util.Date(); //fecha actual del sistema;
        formato = new SimpleDateFormat("dd/MM/yyyy");
        fechaVenta=formato.format(fecha);
        this.precioTotal=0;
        this.renglonesDeVenta= new ArrayList(); 
        this.usuario="";
        this.id= (int) (Math.random() *100000) + 1; //mientras se crea un producto le sumo 1
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public List<Renglon> getRenglonesDeVenta() {
        return renglonesDeVenta;
    }

    public String getUsuario(){
        return usuario;
    }
    
    public int getId(){
        return id;
    }
    
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setRenglonesDeVenta(List<Renglon> renglonesDeVenta) {
        this.renglonesDeVenta = renglonesDeVenta;
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void mostrarVenta(){
        System.out.println("Fecha de nacimiento: "+fechaVenta);
        System.out.println("Usuario: "+usuario);
        System.out.println("Id: "+id);
        System.out.println("Renglones: ");
        System.out.println(renglonesDeVenta.toString());
        System.out.println("Precio total: "+precioTotal);
    }
    
    public Venta clone(){
        Venta venta= new Venta();
        venta.setId(this.getId());
        venta.setFechaVenta(this.getFechaVenta());
        venta.setPrecioTotal(this.getPrecioTotal());
        venta.setUsuario(this.getUsuario());
        venta.setRenglonesDeVenta(this.getRenglonesDeVenta());
        return venta;
    }
    
    public void agregarRenglon(Renglon renglon){
        renglonesDeVenta.add(renglon);
    }
    
    
}
