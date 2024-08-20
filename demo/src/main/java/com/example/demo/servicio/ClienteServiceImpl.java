package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    ClienteRepository repo;

    @Override
    public Cliente findByCedula(String cedula) {
        return repo.findByCedula(cedula);
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repo.findAll();
    }
    @Override
    public void save(Cliente cliente) {
        repo.save(cliente);
    }
    @Override
    public void delete(String cedula) {
        repo.delete(cedula);
    }

    @Override
    public void update(Cliente cliente){
        repo.update(cliente);
    }
    
}
