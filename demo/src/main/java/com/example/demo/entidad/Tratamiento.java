package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {

    private float Precio;
    private String Fecha;


    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Veterinario veterinario;

    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Droga droga;



    public Tratamiento() {
    }

    public Tratamiento(Long id, float Precio, String Fecha, Cliente cliente, Veterinario veterinario, Droga droga) {        
        this.id = id;
        this.Precio = Precio;
        this.cliente = cliente;
        this.veterinario = veterinario;
        this.droga = droga;
    }

    public Tratamiento(float precio, String fecha, Cliente cliente, Veterinario veterinario, Droga droga) {
        Precio = precio;
        Fecha = fecha;
        this.cliente = cliente;
        this.veterinario = veterinario;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    
    
}
