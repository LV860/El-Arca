package com.example.demo.servicio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository repoJPA;
    @Autowired
    private TratamientoRepository tratamientoRepositoryJPA;

    @Override
    public Veterinario findById(Long id) {
        return repoJPA.findById(id).orElse(null);
    }

    @Override
    public Veterinario findByCedula(String cedula){
        return repoJPA.findByCedula(cedula);
    }

    @Override
    public List<Veterinario> SearchAll() {
        return repoJPA.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Veterinario> existingVeterinario = repoJPA.findById(id);
        if (existingVeterinario.isPresent()) {
            existingVeterinario.get().setUserEntity(null);
            repoJPA.save(existingVeterinario.get());
            Collection<Tratamiento> tratamientos = tratamientoRepositoryJPA.findByVeterinarioId(id);
            if (!tratamientos.isEmpty()) {
                for (Tratamiento tratamiento : tratamientos) {
                    tratamiento.setVeterinario(null);
                    tratamientoRepositoryJPA.save(tratamiento);
                }
            }
            repoJPA.deleteById(id);
        }
    }

    @Override
    public void update(Veterinario veterinario) {
        repoJPA.save(veterinario);
    }

    @Override
     public Veterinario save(Veterinario veterinario) {
        
        return repoJPA.save(veterinario);
    }

    @Override
    public int obtenerCantidadVeterinariosActivos() {
        return repoJPA.countVeterinariosByEstado("Activo");
    }

    @Override
    public int obtenerCantidadVeterinariosInactivos() {
        return repoJPA.countVeterinariosByEstado("Inactivo");
    }
}
