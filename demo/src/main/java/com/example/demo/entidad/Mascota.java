package com.example.demo.entidad;

public class Mascota {
    
    //Nuevo para id's
    private Integer id;
    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String enfermedad;
    private String urlImagen;
    private String cedulaDuenho;
    
    
    public Mascota(Integer id, String nombre, String raza, int edad, double peso, String enfermedad, String urlImagen, String cedulaDuenho) {
        this.id = id;
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
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public String getCedulaDuenho() {
        return cedulaDuenho;
    }
    public void setCedulaDuenho(String cedulaDuenho) {
        this.cedulaDuenho = cedulaDuenho;
    }

    
    


}
