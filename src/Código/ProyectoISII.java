/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import Interfaz.PantallaPrincipal;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Megan Maguire
 */
public class ProyectoISII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        try{
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        
        JFrame ventana = new PantallaPrincipal();
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
}
