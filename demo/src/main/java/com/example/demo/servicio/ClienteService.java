package com.example.demo.servicio;

import java.util.Collection;

import com.example.demo.entidad.Cliente;

public interface ClienteService {


    Cliente findById(Long id);
    Collection<Cliente> SearchAll();
    void delete(Long id);
    void update(Cliente cliente);
    void save(Cliente cliente);

    public Collection<Cliente> findClienteByNombre(String nombre);
    public Collection<Cliente> findClienteByCorreo(String correo);
    public Collection<Cliente> findClienteByCelular(String celular);
    public Collection<Cliente> findClienteByEstado(String estado);
}
