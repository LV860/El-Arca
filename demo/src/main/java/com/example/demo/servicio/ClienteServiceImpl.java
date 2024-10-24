package com.example.demo.servicio;

import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

import jakarta.validation.OverridesAttribute;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepositoryJPA;
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
        List<Mascota> listaMascotas = clienteRepositoryJPA.findById(id).get().getMascotas();
        if(listaMascotas != null){
            for (int i =0; i<listaMascotas.size(); i++){
                mascotaService.deleteById(listaMascotas.get(i).getId());
            }
        }
        clienteRepositoryJPA.deleteById(id);
    }

    @Override
    public Cliente update(Cliente cliente) {
        clienteRepositoryJPA.save(cliente);
        return cliente;
    }

    @Override
    public Cliente save(Cliente cliente) {
        cliente.setMascotas(clienteRepositoryJPA.findById(cliente.getId()).get().getMascotas());
        clienteRepositoryJPA.save(cliente);
        return cliente;
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
