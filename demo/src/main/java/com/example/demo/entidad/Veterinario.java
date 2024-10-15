package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Veterinario {
    private String cedula;
    private String contrasena;
    private String especialidad;
    private String urlImagen;
    
    private String nombre;
    private String estado;

    @Id
    @GeneratedValue
    private Long id;




    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    

    public Veterinario(Long id, String cedula, String contrasena, String especialidad, String urlImagen, 
            String nombre) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.urlImagen = urlImagen;
        
        this.nombre = nombre;
        this.id = id;
    }



    public Veterinario() {
    }



    public Veterinario(String cedula, String contrasena, String especialidad, String urlImagen,
            String nombre) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.urlImagen = urlImagen;

        this.estado = "Inactivo";
        
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getEstado() {
        return estado;
    }



    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
