package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.NotFoundException;
@Repository
public class ClienteRepository {

    private Map<String, Cliente> data = new HashMap<>();
    
    public ClienteRepository() {        
        data.put("1", new Cliente("123456789", "pipe_140@gmail.com", "555-1234", "Daniel Felipe Bello Navas"));
        data.put("2", new Cliente("987654321", "juan_101@gmail.com", "555-5678", "Juan Andres Orjuela Bello"));
    }

    public Cliente findByCedula(String cedula){
        for (Cliente cliente : data.values()){
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                return cliente;
            }
        }
        return null;
    }
    
    public Collection<Cliente> findAll(){
        return data.values();
    }
    
    public void save(Cliente cliente) {
        data.put(cliente.getCedula(), cliente);
    }
    
    public void delete(String cedula) {
        // Encontrar la clave correspondiente al cliente con la misma cédula
        String keyToDelete = null;
    
        for (Map.Entry<String, Cliente> entry : data.entrySet()) {
            if (entry.getValue().getCedula().equals(cedula)) {
                keyToDelete = entry.getKey();
                break;
            }
        }
    
        if (keyToDelete != null) {
            // Eliminar el cliente del HashMap
            data.remove(keyToDelete);
            System.out.println("Cliente con cédula " + cedula + " eliminado.");
        } else {
            throw new NotFoundException(cedula);
        }
    }
    

    public void update(Cliente clienteActualizado) {
        // Encontrar la clave correspondiente al cliente con la misma cédula
        String keyToUpdate = null;
        
        for (Map.Entry<String, Cliente> entry : data.entrySet()) {
            if (entry.getValue().getCedula().equals(clienteActualizado.getCedula())) {
                keyToUpdate = entry.getKey();
                break;
            }
        }
        
        if (keyToUpdate != null) {
            // Actualizar el cliente en el HashMap
            data.put(keyToUpdate, clienteActualizado);
            System.out.println("Cliente con cédula " + clienteActualizado.getCedula() + " actualizado.");
        } else {
            // Cliente no encontrado
            throw new NotFoundException(clienteActualizado.getCedula());
        }
    }
    

    


}
