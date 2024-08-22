package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.MascotaRepository;


@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota SearchById(int id) {
        return repo.findById(id);

    }

    @Override
    public Collection<Mascota> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Mascota mascota) {
        repo.update(mascota);
    }

    @Override
    public void save(Mascota mascota) {
        repo.save(mascota);
    }

    @Override
    public Collection<Mascota> findMascotaByCedulaDuenho(String cedula) {
        return repo.findMascotaByCedulaDuenho(cedula);
    }
    
}
