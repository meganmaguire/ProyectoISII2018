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

    public Narguile(String tabaco, float precioVenta) {
        super(precioVenta);
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
}
