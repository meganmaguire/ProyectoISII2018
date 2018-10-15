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
public class Cerveza extends Producto{
    private String nombre;
    private String marca;
    private String tipo;
    private float precioCosto;
    private float graduacionAlc;
    private float contenido;

    public Cerveza(String nombre, String marca, String tipo, float precioCosto, float graduacionAlc, float contenido, float precioVenta) {
        super(precioVenta);
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.precioCosto = precioCosto;
        this.graduacionAlc = graduacionAlc;
        this.contenido = contenido;
    }
    
    public Cerveza(){
        super();
        this.nombre = "";
        this.marca = "";
        this.tipo = "";
        this.precioCosto = 0;
        this.graduacionAlc = 0;
        this.contenido = 0;
    }

    public String getNombre() {
        return nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    
}
