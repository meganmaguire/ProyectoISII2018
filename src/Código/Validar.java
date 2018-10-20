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
public class Validar {
    DAOSQLite dao;
    
    public Validar(){
        dao= new DAOSQLite();
    }
    
    public boolean validarStock(Producto producto, int cantidad){
        int stockActual;
        float stockActArt;
        if(producto instanceof Gaseosa){
            Gaseosa gaseosa= (Gaseosa) producto;
            stockActual= dao.consultarStockGaseosas(gaseosa);
            if(cantidad > stockActual){
                return false;
            }
        }
        if(producto instanceof Industrial){
            Industrial ind= (Industrial) producto;
            stockActual=dao.consultarStockIndustrial(ind);
            if(cantidad > stockActual){
                return false;
            }
        }
        if(producto instanceof Vino){
            Vino vino= (Vino) producto;
            stockActual= dao.consultarStockVinos(vino);
            if(cantidad > stockActual){
                return false;
            }
        }
        if(producto instanceof Artesanal){
            Artesanal art= (Artesanal) producto;
            stockActArt= dao.consultarStockArtesanal(art);
            if(cantidad > stockActArt){
                return false;
            }
        } 
        return true;
    }
}
