package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Cliente;


public interface AdministradorService {

    Administrador findById(Long id);
    List<Administrador> SearchAll();
    public Administrador findByUsuario(String usuario);
} 