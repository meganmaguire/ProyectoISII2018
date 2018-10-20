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
public class Narguile extends Producto{
    private String tabaco;

    public Narguile(String tabaco, float precioVenta,String nombreProducto) {
        super(precioVenta,nombreProducto);
        this.tabaco = tabaco;
    }
    
    public Narguile(){
        super();
        this.tabaco="";
    }

    public String getTabaco() {
        return tabaco;
    }

    public void setTabaco(String tabaco) {
        this.tabaco = tabaco;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: "+super.getNombreProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Tabaco: "+tabaco);
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
    public Narguile clone(){
        Narguile nar = new Narguile();
        nar.setId(this.getId());
        nar.setPrecioVenta(this.getPrecioVenta());
        nar.setNombreProducto(this.getNombreProducto());
        nar.setTabaco(this.getTabaco());
        return nar;
        
    }
    public String instance(){
        return "Narguile";
    }
}
