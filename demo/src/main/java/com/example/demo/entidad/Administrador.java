package com.example.demo.entidad;

import org.h2.engine.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {
    private String usuario;
    private String contrasena;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;
    @Id
    @GeneratedValue
    private Long id;


    

    public Administrador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

}
