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

    public Narguile(String tabaco, float precioVenta,String tipoProducto) {
        super(precioVenta,tipoProducto);
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
        System.out.println("Tipo de producto "+super.getTipoProducto());
        System.out.println("Id: "+super.getId());
        System.out.println("Tabaco: "+tabaco);
        System.out.println("Precio de venta: "+super.getPrecioVenta());
    }
}
