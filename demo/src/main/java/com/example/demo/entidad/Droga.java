package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

        
}
