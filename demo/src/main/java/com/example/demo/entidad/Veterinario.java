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
    private int numAtenciones;
    private String nombre;

    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    

    public Veterinario(Long id, String cedula, String contrasena, String especialidad, String urlImagen, int numAtenciones,
            String nombre) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.urlImagen = urlImagen;
        this.numAtenciones = numAtenciones;
        this.nombre = nombre;
        this.id = id;
    }



    public Veterinario() {
    }



    public Veterinario(String cedula, String contrasena, String especialidad, String urlImagen, int numAtenciones,
            String nombre) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.urlImagen = urlImagen;
        this.numAtenciones = numAtenciones;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public int getNumAtenciones() {
        return numAtenciones;
    }

    public void setNumAtenciones(int numAtenciones) {
        this.numAtenciones = numAtenciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
}
