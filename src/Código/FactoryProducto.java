/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

/**
 *
 * @author megan
 */
public class FactoryProducto {
    
    public static Producto getProducto(String categoría){
        switch(categoría){
            case "Industrial":  return new Industrial();
            case "Artesanal" :  return new Artesanal();
            case "Vino" :       return new Vino();
            case "Gaseosa" :    return new Gaseosa();
            case "Narguile" :   return new Narguile(); 
            case "Pizza" :      return new Pizza(); 
            case "Picada" :     return new Picada(); 
            case "Trago" :      return new Trago(); 
        }
        return null;
    }
}
