package com.example.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    
}
