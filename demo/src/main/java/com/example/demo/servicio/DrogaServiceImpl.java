package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Droga;
import com.example.demo.repositorio.DrogaRepository;

public class DrogaServiceImpl implements DrogaService {

    @Autowired
    private DrogaRepository repoJPADroga;

    @Override
    public Droga findById(Long id) {
        return repoJPADroga.findById(id).orElse(null);
    }

    @Override
    public List<Droga> SearchAll() {
        return repoJPADroga.findAll();
    }
    
}
