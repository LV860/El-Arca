package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Mascota {
    
    //Nuevo para id's
    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String enfermedad;
    private String urlImagen;
    private Long cedulaDuenho;
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
    public Mascota(Long id, String nombre, String raza, int edad, double peso, String enfermedad, String urlImagen, Long cedulaDuenho) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.urlImagen = urlImagen;
        this.cedulaDuenho = cedulaDuenho;
    }
    
    public Mascota(String nombre, String raza, int edad, double peso, String enfermedad, String urlImagen, Long cedulaDuenho) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.urlImagen = urlImagen;
        this.cedulaDuenho = cedulaDuenho;
    }


    
    public Mascota() {
        // Constructor vacío necesario para Thymeleaf y otras instancias
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public String getUrlImagen() {
        return urlImagen;
    }
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    public Long getCedulaDuenho() {
        return cedulaDuenho;
    }
    public void setCedulaDuenho(Long cedulaDuenho) {
        this.cedulaDuenho = cedulaDuenho;
    }   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
