/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void cargarUsuarios() throws SQLException{
        Connection con=null;
        PreparedStatement consulta=null;
        ResultSet datos=null;
        ConexionBD.createConexionBD();
        con = (Connection) ConexionBD.getConexionBD();
        consulta =con.prepareStatement("SELECT * FROM Usuarios");
        datos=consulta.executeQuery();
    }
    
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
    
    public void registrarUsuario(Usuario us1){
        listaUsuarios.add(us1);
    }
    
    public void modificarUsuario(Usuario us1, Usuario us2){
        listaUsuarios.remove(us1);  //elimina el usuario a modificar
        listaUsuarios.add(us2);     //agrega el usuario modificado
    }
    
    public void eliminarUsuario(Usuario us1){
        Iterator i= listaUsuarios.iterator();
        while(i.hasNext()){
            Usuario usuario = (Usuario) i.next();
            if(usuario.equals(us1)){
                listaUsuarios.remove(usuario);
            }
        }
    }
}
