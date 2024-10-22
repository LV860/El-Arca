package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Droga;
import com.example.demo.repositorio.DrogaRepository;
@Service

public class DrogaServiceImpl implements DrogaService {
   
    @Autowired
    private DrogaRepository repoJPADroga;

    @Override
    public Droga crearDroga(Droga droga){
        return repoJPADroga.save(droga);
    }

    @Override
    public Droga findById(Long id) {
        return repoJPADroga.findById(id).orElse(null);
    }

    @Override
    public List<Droga> SearchAll() {
        return repoJPADroga.findAll();
    }

    @Override
    public int obtenerUnidadesDisponibles(Long id) {
        return repoJPADroga.findUnidadesDisponiblesById(id);
    }

    @Override
    public int obtenerUnidadesVendidas(Long id) {
        return repoJPADroga.findUnidadesVendidasById(id);
    }
    
    
    
}
