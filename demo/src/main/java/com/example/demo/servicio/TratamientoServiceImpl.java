package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Tratamiento;
import com.example.demo.repositorio.TratamientoRepository;


@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository repoJPA;


    @Override
    public Tratamiento findById(Long id) {
        return repoJPA.findById(id).orElse(null);
    }

    @Override
    public Collection<Tratamiento> SearchAll() {
        return repoJPA.findAll();
    }

    @Override
    public void delete(Long id) {
        repoJPA.deleteById(id);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        repoJPA.save(tratamiento);
    }

    @Override
    public void save(Tratamiento tratamiento) {
        repoJPA.save(tratamiento);
    }


    
}
