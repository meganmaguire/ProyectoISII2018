/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.text.ParseException;
import javax.swing.JTextField;

/**
 *
 * @author Maru
 */
public class Validar {
    DAOSQLite dao;
    
    public Validar(){
        dao= new DAOSQLite();
    }
    
    public boolean validarStock(Integer id,String categoria, int cantidad){
        int stockActual;
        float stockActArt;
        if(categoria.equals("Gaseosa")){
            stockActual= dao.consultarStockGaseosas(id);
            if(cantidad > stockActual){
                return false;
            }
        }
        if(categoria.equals("Industrial")){
            stockActual=dao.consultarStockIndustrial(id);
            if(cantidad > stockActual){
                return false;
            }
        }
        if(categoria.equals("Vino")){
            stockActual= dao.consultarStockVinos(id);
            if(cantidad > stockActual){
                return false;
            }
        }
        if(categoria.equals("Artesanal")){
            stockActArt= dao.consultarStockArtesanal(id);
            if(cantidad > stockActArt){
                return false;
            }
        } 
        return true;
    }
    
    public boolean validarCampoVacio(JTextField campo){
        String texto = campo.getText();
        return !texto.isEmpty();
    }
    public boolean validarCampoFloat(JTextField campo){
        try{
            float numero = Float.parseFloat(campo.getText());
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
