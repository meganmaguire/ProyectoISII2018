/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Maru
 */
public class ManagerUsuarios {
    List <Usuario> listaUsuarios;
    
    //Constructor
    public ManagerUsuarios(){
        listaUsuarios=new ArrayList();
    }
    
    //Getters
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    //Setters
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    //Metodos para el manejo del manager usuarios
    //si el usuario existe en la bd devuelve verdadero, sino falso
    public boolean validarUsuario(Usuario us1){
        Iterator i= listaUsuarios.iterator();
        while(i.hasNext()){
            Usuario usuario = (Usuario) i.next();
            if(usuario.equals(us1)){
                return true;
            }
        }
        return false;
    }
    
    /*public void registrarUsuario(Usuario us1){
    }
    
    public void modificarUsuario(Usuario us1, Usuario us2){
    }
    
    public void eliminarUsuario(Usuario us1){
    }*/
}
