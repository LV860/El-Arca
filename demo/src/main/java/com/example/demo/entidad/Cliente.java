package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {

    private String correo;
    private String celular;
    private String nombre;
    private String estado;
    private Long cedula;

    @Id
    @GeneratedValue
    private Long id;

    //CASCADE para evitar problemas de foreign key.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente() {
    }


    public Cliente(Long id, Long cedula, String correo, String celular, String nombre, String estado) {

        this.id = id;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Cliente(Long cedula,String correo, String celular, String nombre, String estado) {
        
        this.correo = correo;
        this.celular = celular;
        this.nombre = nombre;
        this.estado = estado;
        this.cedula = cedula;
    }


    public Long getCedula() {
        return cedula;
    }


    public void setCedula(Long cedula) {
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
    
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}