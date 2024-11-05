package com.example.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    
    //Nuevo para id's
    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String enfermedad;
    private String urlImagen;
    private Long cedulaDuenho;
    //Estado, en tratamiento o inactivo
    private String estado;
    @Id
    @GeneratedValue
    private Long id;

    //cuando traigo ejemplo otra lista de mascotas y evitar un loop infinito.
    @JsonIgnore 
    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
    public Mascota(Long id, String nombre, String raza, int edad, double peso, String enfermedad, String urlImagen, Long cedulaDuenho, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.urlImagen = urlImagen;
        this.cedulaDuenho = cedulaDuenho;
        this.estado = estado;
    }
    
    public Mascota(String nombre, String raza, int edad, double peso, String enfermedad, String urlImagen, Long cedulaDuenho, String estado) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.urlImagen = urlImagen;
        this.cedulaDuenho = cedulaDuenho;
        this.estado = estado;
    }
    

    
}
