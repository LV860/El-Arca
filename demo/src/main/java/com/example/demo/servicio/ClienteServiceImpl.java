package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repoJPA;



    @Override
    public Cliente findById(Long id) {
        return repoJPA.findById(id).orElse(null);
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repoJPA.findAll();
    }

    @Override
    public void delete(Long id) {
        repoJPA.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        repoJPA.save(cliente);
    }

    @Override
    public void save(Cliente cliente) {
        cliente.setEstado("Inactivo");
        repoJPA.save(cliente);
    }

    @Override
    public Collection<Cliente> findClienteByNombre(String nombre) {
        return repoJPA.findClienteByNombre(nombre);
    }

    @Override
    public Collection<Cliente> findClienteByCorreo(String correo) {
        return repoJPA.findClienteByCorreo(correo);
    }

    @Override
    public Collection<Cliente> findClienteByCelular(String celular) {
        return repoJPA.findClienteByCelular(celular);
    }

    @Override
    public Collection<Cliente> findClienteByEstado(String estado) {
        return repoJPA.findClienteByEstado(estado);
    }
}
