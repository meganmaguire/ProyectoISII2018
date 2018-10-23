/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maru
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String usuario;
    private String contraseña;
    private String permiso;

    public Usuario(String nombre, String apellido, String fechaNacimiento, String usuario, String contraseña, String permiso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.permiso = permiso;
    }

    public Usuario() {
        this.nombre= "";
        this.apellido="";
        this.fechaNacimiento="";
        this.usuario="";
        this.contraseña="";
        this.permiso="";
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
    
    public void mostrarUsuario(){
        
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Fecha de nacimiento: "+fechaNacimiento);
        System.out.println("Usuario: "+usuario);
        System.out.println("Contraseña: "+contraseña);
        System.out.println("Permiso: "+permiso);
    }
    
    public boolean equals(Usuario us1){
        if((this.getNombre().equals(us1.getNombre())) && (this.getApellido().equals(us1.getApellido()))){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Usuario clone(){
        Usuario usuario= new Usuario();
        usuario.setNombre(this.getNombre());
        usuario.setApellido(this.getApellido());
        usuario.setFechaNacimiento(this.getFechaNacimiento());
        usuario.setUsuario(this.getUsuario());
        usuario.setContraseña(this.getContraseña());
        usuario.setPermiso(this.getPermiso());
        return usuario;
    }
}
