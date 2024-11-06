package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;
    private String cedula;
    @Transient
    private String contrasena;
    private String especialidad;
    private String urlImagen;
    
    private String nombre;
    private String estado;

    @Id
    @GeneratedValue
    private Long id;



    @JsonIgnore
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


    public Veterinario(String cedula, String contrasena, String especialidad, String urlImagen,
            String nombre, String estado) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.urlImagen = urlImagen;

        this.estado = estado;
        
        this.nombre = nombre;
    }

   
    
}
