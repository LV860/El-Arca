package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Droga {

    private String nombre;
    private float PrecioCompra;
    private float PrecioVenta;
    private int unidadesDisponibles;
    private int unidadesVendidas;


    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "droga", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();


    public Droga(Long id, String nombre, float PrecioCompra, float PrecioVenta, int unidadesDisponibles, int unidadesVendidas) {
        this.id = id;
        this.nombre = nombre;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }


    public Droga(String nombre, float PrecioCompra, float PrecioVenta, int unidadesDisponibles, int unidadesVendidas) {
        this.nombre = nombre;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }   

    public Droga() {
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public float getPrecioCompra() {
        return PrecioCompra;
    }


    public void setPrecioCompra(float precioCompra) {
        PrecioCompra = precioCompra;
    }


    public float getPrecioVenta() {
        return PrecioVenta;
    }


    public void setPrecioVenta(float precioVenta) {
        PrecioVenta = precioVenta;
    }


    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }


    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }


    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }


    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }


    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    
    
}
