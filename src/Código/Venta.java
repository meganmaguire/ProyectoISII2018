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
    private Date fecha;
    private float precioTotal;
    private List<Renglon> renglonesDeVenta;
    private String usuario;
    private int id;

    public Venta(float precioTotal, List renglonesDeVenta, String usuario) {
        this.fecha = new java.util.Date(); //fecha actual del sistema;
        this.precioTotal = precioTotal;
        this.renglonesDeVenta = renglonesDeVenta;
        this.usuario=usuario;
        this.id= (int) (Math.random() *100000) + 1; //mientras se crea un producto le sumo 1
    }
    
    public Venta(){
        this.fecha=new java.util.Date(); //fecha actual del sistema;
        this.precioTotal=0;
        this.renglonesDeVenta= new ArrayList(); 
        this.usuario="";
        this.id= (int) (Math.random() *100000) + 1; //mientras se crea un producto le sumo 1
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha de nacimiento: "+formato.format(fecha));
        System.out.println("Usuario: "+usuario);
        System.out.println("Id: "+id);
        System.out.println("Renglones: ");
        System.out.println(renglonesDeVenta.toString());
        System.out.println("Precio total: "+precioTotal);
    }
    
    public Venta clone(){
        Venta venta= new Venta();
        venta.setId(this.getId());
        venta.setFecha(this.getFecha());
        venta.setPrecioTotal(this.getPrecioTotal());
        venta.setUsuario(this.getUsuario());
        venta.setRenglonesDeVenta(this.getRenglonesDeVenta());
        return venta;
    }
    
    public void agregarRenglon(Renglon renglon){
        renglonesDeVenta.add(renglon);
    }
    
    public void cargarRenglon(Renglon renglon,int idProducto, int cantidad,int idVenta){
        renglon.setIdProducto(idProducto);
        renglon.setCantidad(cantidad);
        renglon.setId(idVenta);
    }
}
