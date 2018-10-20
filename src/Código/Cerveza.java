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
public abstract class Cerveza extends Producto{
    private String marca;
    private String tipo;
    private float precioCosto;
    private float graduacionAlc;
    private float contenido;

    public Cerveza(String marca, String tipo, float precioCosto, float graduacionAlc, float contenido, float precioVenta,String nombreProducto) {
        super(precioVenta,nombreProducto);
        this.marca = marca;
        this.tipo = tipo;
        this.precioCosto = precioCosto;
        this.graduacionAlc = graduacionAlc;
        this.contenido = contenido;
    }
    
    public Cerveza(){
        super();
        this.marca = "";
        this.tipo = "";
        this.precioCosto = 0;
        this.graduacionAlc = 0;
        this.contenido = 0;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public float getGraduacionAlc() {
        return graduacionAlc;
    }

    public float getContenido() {
        return contenido;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public void setGraduacionAlc(float graduacionAlc) {
        this.graduacionAlc = graduacionAlc;
    }

    public void setContenido(float contenido) {
        this.contenido = contenido;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: "+super.getNombreProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Marca: "+marca);
        System.out.println("Tipo: "+tipo);
        System.out.println("Graduacion alcoholica: "+graduacionAlc);
        System.out.println("Contenido: "+contenido);
        System.out.println("Precio de costo: "+precioCosto);
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
}
