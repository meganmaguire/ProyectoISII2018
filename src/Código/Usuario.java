/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.Date;

/**
 *
 * @author Maru
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String usuario;
    private String contraseña;
    private String permiso;

    public Usuario(String nombre, String apellido, Date fechaNacimiento, String usuario, String contraseña, String permiso) {
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
        this.fechaNacimiento=null;
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

    public Date getFechaNacimiento() {
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

    public void setFechaNacimiento(Date fechaNacimiento) {
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
}
