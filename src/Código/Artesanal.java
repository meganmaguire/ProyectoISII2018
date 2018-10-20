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

    public Artesanal(String color, String lupulo, String malta, Barril barril,String marca, String tipo, float precioCosto, float graduacionAlc, float contenido, float precioVenta,String nombreProducto) {
        super(marca, tipo, precioCosto, graduacionAlc, contenido, precioVenta,nombreProducto);
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
    
    public void mostrarProducto(){
        this.mostrarProducto();
        System.out.println("Color: "+color);
        System.out.println("Lupulo: "+lupulo);
        System.out.println("Malta: "+malta);
        System.out.println("Barril: ");
        System.out.println(barril.toString());
    }
    
    public Artesanal clone(){
        Artesanal art = new Artesanal();
        art.setId(this.getId());
        art.setPrecioVenta(this.getPrecioVenta());
        art.setNombreProducto(this.getNombreProducto());
        art.setMarca(this.getMarca());
        art.setTipo(this.getTipo());
        art.setGraduacionAlc(this.getGraduacionAlc());
        art.setContenido(this.getContenido());
        art.setColor(this.getColor());
        art.setLupulo(this.getLupulo());
        art.setMalta(this.malta);
        return art;
    }
    public String instance(){
        return "Artesanal";
    }
}
