package com.example.demo.entidad;

public class Cliente {

    private String cedula;
    private String correo;
    private String celular;
    private String nombre;

    public Cliente() {
    }

    public Cliente(String cedula, String correo, String celular, String nombre) {
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.nombre = nombre;
    }


    public String getCedula() {
        return cedula;
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getCelular() {
        return celular;
    }


    public void setCelular(String celular) {
        this.celular = celular;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}



