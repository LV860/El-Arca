package com.example.demo.servicio;

import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepositoryJPA;

    @Override
    public Cliente findById(Long id) {
        return clienteRepositoryJPA.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> SearchAll() {
        return clienteRepositoryJPA.findAll();
    }

    @Override
    public void delete(Long id) {
        clienteRepositoryJPA.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        clienteRepositoryJPA.save(cliente);
    }

    @Override
    public void save(Cliente cliente) {
        cliente.setEstado("Inactivo");
        clienteRepositoryJPA.save(cliente);
    }

    @Override
    public Collection<Cliente> findClienteByNombre(String nombre) {
        return clienteRepositoryJPA.findClienteByNombre(nombre);
    }

    @Override
    public Collection<Cliente> findClienteByCorreo(String correo) {
        return clienteRepositoryJPA.findClienteByCorreo(correo);
    }

    @Override
    public Collection<Cliente> findClienteByCelular(String celular) {
        return clienteRepositoryJPA.findClienteByCelular(celular);
    }


    @Override
    public Collection<Cliente> findClienteByCedula(Long cedula) {
        return clienteRepositoryJPA.findClienteByCedula(cedula);
    }

    @Override
    public Collection<Cliente> findClienteByEstado(String estado) {
        return clienteRepositoryJPA.findClienteByEstado(estado);
    }
}
