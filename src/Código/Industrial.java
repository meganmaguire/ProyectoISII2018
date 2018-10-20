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
public class Industrial extends Cerveza{
    private String origen;
    private Stock stock;

    public Industrial(String origen, Stock stock,String marca, String tipo, float precioCosto, float graduacionAlc, float contenido, float precioVenta, String tipoProducto) {
        super(marca, tipo, precioCosto, graduacionAlc, contenido, precioVenta,tipoProducto);
        this.origen = origen;
        this.stock = stock;
    }
    
    public Industrial(){
        super();
        this.origen="";
        this.stock=stock;
    }

    public String getOrigen() {
        return origen;
    }
    
    public Stock getStock(){
        return stock;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }  
    
    public void setStock(Stock stock){
        this.stock=stock;
    }
    
    public void mostrarProducto(){
        this.mostrarProducto();
        System.out.println("Origen: "+origen);
        System.out.println("Stock: ");
        System.out.println(stock.toString());
    }
    
    public Industrial clone(){
        Industrial ind = new Industrial();
        ind.setId(this.getId());
        ind.setPrecioVenta(this.getPrecioVenta());
        ind.setNombreProducto(this.getNombreProducto());
        ind.setMarca(this.getMarca());
        ind.setTipo(this.getTipo());
        ind.setPrecioCosto(this.getPrecioCosto());
        ind.setGraduacionAlc(this.getGraduacionAlc());
        ind.setContenido(this.getContenido());
        ind.setOrigen(this.getOrigen());
        ind.setStock(this.getStock());
        return ind;
    }
    public String instance(){
        return "Industrial";
    }
}
