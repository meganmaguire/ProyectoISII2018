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
public class Artesanal extends Cerveza{
    private String color;
    private String lupulo;
    private String malta;
    private Barril barril;

    public Artesanal(String color, String lupulo, String malta, Barril barril, String nombre, String marca, String tipo, float precioCosto, float graduacionAlc, float contenido, float precioVenta) {
        super(nombre, marca, tipo, precioCosto, graduacionAlc, contenido, precioVenta);
        this.color = color;
        this.lupulo = lupulo;
        this.malta = malta;
        this.barril = barril;
    }
    
    public Artesanal(){
        super();
        this.color="";
        this.lupulo="";
        this.malta="";
        this.barril= new Barril();
    }

    public String getColor() {
        return color;
    }

    public String getLupulo() {
        return lupulo;
    }

    public String getMalta() {
        return malta;
    }
    
    public Barril getBarril(){
        return barril;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLupulo(String lupulo) {
        this.lupulo = lupulo;
    }

    public void setMalta(String malta) {
        this.malta = malta;
    }
    
    public void setBarril(Barril barril){
        this.barril=barril;
    }
}
