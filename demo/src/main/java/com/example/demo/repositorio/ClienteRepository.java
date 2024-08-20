package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Cliente;

@Repository
public class ClienteRepository {

    private Map<String, Cliente> data = new HashMap<>();
    
    public ClienteRepository() {        
        data.put("1", new Cliente("123456789", "pipe_140@gmail.com", "555-1234", "Daniel Felipe Bello Navas"));
        data.put("2", new Cliente("987654321", "juan_101@gmail.com", "555-5678", "Juan Andres Orjuela Bello"));
    }

    public Cliente findByCedula(String cedula){
        return data.get(cedula);
    }
    
    public Collection<Cliente> findAll(){
        return data.values();
    }
    
    public void save(Cliente cliente) {
        data.put(cliente.getCedula(), cliente);
    }
    
    public void delete(String cedula) {
        data.remove(cedula);
    }
}
