package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    //@JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();

   
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


    
}