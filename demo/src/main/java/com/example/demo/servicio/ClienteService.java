package com.example.demo.servicio;

import java.util.Collection;

import com.example.demo.entidad.Cliente;

public interface ClienteService {


    Cliente findByCedula(String cedula);
    Cliente findById(Long id);
    Collection<Cliente> SearchAll();
    void delete(Long id);
    void update(Cliente cliente);
    void save(Cliente cliente);
}
