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
public class Renglon {
    private int cantidad;
    private int id;
    private int idProducto;

    public Renglon(int cantidad,int id, int idProducto) {
        this.cantidad = cantidad;
        this.id=id;
        this.idProducto=idProducto;
    }

    public Renglon(){
        this.cantidad=0;
        this.idProducto=0;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }
     
    public int getId() {
        return id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto=idProducto;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void cargarRenglon(Renglon renglon,int idProducto, int cantidad,int idVenta){
        renglon.setIdProducto(idProducto);
        renglon.setCantidad(cantidad);
        renglon.setId(idVenta);
    }
}
