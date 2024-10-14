package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Administrador {
    private String usuario;
    private String contrasenia;


    @Id
    @GeneratedValue
    private Long id;


    

    public Administrador(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }


    public Administrador(String usuario, String contrasenia, Long id) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.id = id;
    }


    public Administrador() {        

    }

    


    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getContrasenia() {
        return contrasenia;
    }


    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    

    

}
