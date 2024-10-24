package com.example.demo.servicio;

import java.util.Collection;

import com.example.demo.entidad.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente crearCliente(Cliente cliente);

    Cliente findById(Long id);

    List<Cliente> SearchAll();

    public void eliminarCliente(Long id);

    public void delete(Long id);

    public Cliente update(Cliente cliente);

    public Cliente save(Cliente cliente);

    public Collection<Cliente> findClienteByNombre(String nombre);

    public Collection<Cliente> findClienteByCorreo(String correo);

    public Collection<Cliente> findClienteByCelular(String celular);

    public Collection<Cliente> findClienteByCedula(Long cedula);

    public Cliente findByCedula(Long cedula);

    public Collection<Cliente> findClienteByEstado(String estado);
}
