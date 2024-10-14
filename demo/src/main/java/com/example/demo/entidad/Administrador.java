package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Administrador {
    private String usuario;
    private String contrasena;


    @Id
    @GeneratedValue
    private Long id;


    

    public Administrador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }


    public Administrador(String usuario, String contrasena, Long id) {
        this.usuario = usuario;
        this.contrasena = contrasena;
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
        return contrasena;
    }


    public void setContrasenia(String contrasena) {
        this.contrasena = contrasena;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    

    

}
