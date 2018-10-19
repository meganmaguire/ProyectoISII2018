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
public class Vino extends Producto{
    private String bodega;
    private String color;
    private String tipoDeUva;
    private float graduacionAlc;
    private float precioCosto;
    private Stock stock;

    public Vino(String nombre,String bodega, String color, String tipoDeUva, float graduacionAlc, float precioCosto, Stock stock, float precioVenta,String nombreProducto) {
        super(precioVenta,nombreProducto);
        this.bodega = bodega;
        this.color = color;
        this.tipoDeUva = tipoDeUva;
        this.graduacionAlc = graduacionAlc;
        this.precioCosto = precioCosto;
        this.stock = stock;
    }
    
    public Vino(){
        super();
        this.bodega = "";
        this.color = "";
        this.tipoDeUva = "";
        this.graduacionAlc = 0;
        this.precioCosto = 0;
        this.stock= new Stock();
    }
    
    public String getBodega() {
        return bodega;
    }

    public String getColor() {
        return color;
    }

    public String getTipoDeUva() {
        return tipoDeUva;
    }

    public float getGraduacionAlc() {
        return graduacionAlc;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public Stock getStock(){
        return stock;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTipoDeUva(String tipoDeUva) {
        this.tipoDeUva = tipoDeUva;
    }

    public void setGraduacionAlc(float graduacionAlc) {
        this.graduacionAlc = graduacionAlc;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }
    
    public void setStock(Stock stock){
        this.stock=stock;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: "+super.getNombreProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Bodega:"+bodega);
        System.out.println("Tipo de uva: "+tipoDeUva);
        System.out.println("Graduacion alcoholica: "+graduacionAlc);
        System.out.println("Precio de costo: "+precioCosto);
        System.out.println("Stock: ");
        System.out.println(stock.toString());
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
    
    public Vino clone(){
        Vino vino = new Vino();
        vino.setId(this.getId());
        vino.setPrecioVenta(this.getPrecioVenta());
        vino.setNombreProducto(this.getNombreProducto());
        vino.setBodega(this.getBodega());
        vino.setColor(this.getColor());
        vino.setTipoDeUva(this.getTipoDeUva());
        vino.setGraduacionAlc(this.getGraduacionAlc());
        vino.setPrecioCosto(this.getPrecioCosto());
        vino.setStock(this.getStock());
        return vino;
    }
}
