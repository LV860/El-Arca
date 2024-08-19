package com.example.demo.servicio;

import java.util.Collection;

import com.example.demo.entidad.Cliente;

public interface ClienteService {

   
    public Cliente SearchById(int id);
    public Collection<Cliente> SearchAll();
}
