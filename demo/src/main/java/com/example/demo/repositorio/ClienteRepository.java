package com.example.demo.repositorio;

import com.example.demo.entidad.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> findAll() {
        return clientes;
    }

    public Optional<Cliente> findByCedula(String cedula) {
        return clientes.stream().filter(cliente -> cliente.getCedula().equals(cedula)).findFirst();
    }

    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    public void deleteByCedula(String cedula) {
        clientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
    }

    public void update(Cliente cliente) {
        deleteByCedula(cliente.getCedula());
        save(cliente);
    }
}
