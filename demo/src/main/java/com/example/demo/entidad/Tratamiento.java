package com.example.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class Tratamiento {

    private float Precio;
    private String Fecha;
    private Long mascotaIdLong;
    private Long veterinarioIdLong;
    private Long drogaIdLong;


    
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore 
    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Mascota mascota;

    @JsonIgnore 
    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Veterinario veterinario;

    @JsonIgnore 
    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Droga droga;



    public Tratamiento() {
    }

    public Tratamiento(Long id, float Precio, String Fecha, Long veterinarioIdLong, Long mascotaIdLong, Long drogaIdLong) {        
        this.id = id;
        this.Precio = Precio;
        this.mascotaIdLong = mascotaIdLong;
        this.veterinarioIdLong = veterinarioIdLong;
        this.drogaIdLong = drogaIdLong;
        this.Fecha = Fecha;
    }

    public Tratamiento(float precio, String fecha, Veterinario veterinario, Mascota mascota, Droga droga) {
        Precio = precio;
        Fecha = fecha;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.droga = droga;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    public Long getMascotaIdLong() {
        return mascotaIdLong;
    }

    public void setMascotaIdLong(Long mascotaIdLong) {
        this.mascotaIdLong = mascotaIdLong;
    }

    public Long getVeterinarioIdLong() {
        return veterinarioIdLong;
    }

    public void setVeterinarioIdLong(Long veterinarioIdLong) {
        this.veterinarioIdLong = veterinarioIdLong;
    }

    public Long getDrogaIdLong() {
        return drogaIdLong;
    }

    public void setDrogaIdLong(Long drogaIdLong) {
        this.drogaIdLong = drogaIdLong;
    }

    

    
    
}
