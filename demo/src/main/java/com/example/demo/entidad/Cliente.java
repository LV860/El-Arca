package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    private String cedula;
    private String correo;
    private String celular;
    private String nombre;
    @Id
    @GeneratedValue
    private Long id;

    public Cliente() {
    }

    public Cliente(Long id, String cedula, String correo, String celular, String nombre) {
        this.id = id;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.nombre = nombre;
    }

    public Cliente(String cedula, String correo, String celular, String nombre) {
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.nombre = nombre;
    }


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id= id;
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



