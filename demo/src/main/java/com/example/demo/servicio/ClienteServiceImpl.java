package com.example.demo.servicio;

import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Rol;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.UserEntity;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.RolRepository;
import com.example.demo.repositorio.UserRepository;

import jakarta.validation.OverridesAttribute;

import java.util.Optional;

import java.util.NoSuchElementException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepositoryJPA;
    @Autowired
    private UserRepository userRepositoryJPA;
    @Autowired
    private MascotaService mascotaService;
    

    @Override
    public Cliente crearCliente(Cliente cliente){
        return clienteRepositoryJPA.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepositoryJPA.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> SearchAll() {
        return clienteRepositoryJPA.findAll();
    }

    @Override
    public void eliminarCliente(Long id){
        clienteRepositoryJPA.deleteById(id);
    }

    @Override
    public void delete(Long id) {

        
        Optional<Cliente> existingCliente = clienteRepositoryJPA.findById(id);
        if (existingCliente.isPresent()) {
            existingCliente.get().setUserEntity(null);
            List<Mascota> listaMascotas = existingCliente.get().getMascotas();
            if (listaMascotas != null) {
                for (Mascota mascota : listaMascotas) {
                    mascotaService.deleteById(mascota.getId());
                }
            }
            clienteRepositoryJPA.deleteById(id);
        } else {
            throw new NoSuchElementException("Cliente with ID " + id + " not found");
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        clienteRepositoryJPA.save(cliente);
        return cliente;
    }

    @Override
    public Cliente save(Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepositoryJPA.findById(cliente.getId());
        if (existingCliente.isPresent()) {
            cliente.setMascotas(existingCliente.get().getMascotas());
        }
        return clienteRepositoryJPA.save(cliente);
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
    public Cliente findByCedula(Long Cedula) {
        return clienteRepositoryJPA.findByCedula(Cedula);
    }

    @Override
    public Collection<Cliente> findClienteByEstado(String estado) {
        return clienteRepositoryJPA.findClienteByEstado(estado);
    }
}
