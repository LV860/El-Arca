package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository repoJPA;



    @Override
    public Veterinario findById(Long id) {
        return repoJPA.findById(id).orElse(null);
    }


    @Override
    public List<Veterinario> SearchAll() {
        return repoJPA.findAll();
    }

    @Override
    public void delete(Long id) {
        repoJPA.deleteById(id);
    }

    @Override
    public void update(Veterinario veterinario) {
        repoJPA.save(veterinario);
    }

    @Override
    public void save(Veterinario veterinario) {
        repoJPA.save(veterinario);
    }
}

