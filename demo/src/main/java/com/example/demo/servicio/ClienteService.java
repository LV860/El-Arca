package com.example.demo.servicio;

import java.util.Collection;
import com.example.demo.entidad.Cliente;

public interface ClienteService {
    
    public Cliente findById(Long id);
    public Collection<Cliente> SearchAll();
    public void save(Cliente cliente);
    public void delete(Long id);
    public void update(Cliente cliente);
}
