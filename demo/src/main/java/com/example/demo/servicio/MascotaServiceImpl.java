package com.example.demo.servicio;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    MascotaRepository mascotaRepositoryJPA;

    @Autowired
    ClienteRepository clienteRepositoryJPA;

    @Override
    public Mascota SearchById(Long id) {
        return mascotaRepositoryJPA.findById(id).orElse(null);
    }

    @Override
    public Collection<Mascota> SearchAll() {
        return mascotaRepositoryJPA.findAll();
    }

    @Override
    public void deleteById(Long id) { 
        mascotaRepositoryJPA.deleteById(id);
    }

    @Override
    public void update(Mascota mascota) {
        //Vuelve a buscar la mascota original antes de ser editada para obtener la cedula del dueño
        mascota.setCedulaDuenho(mascotaRepositoryJPA.findById(mascota.getId()).orElse(null).getCedulaDuenho());
        mascota.setCliente(mascotaRepositoryJPA.findById(mascota.getId()).orElse(null).getCliente());
        mascotaRepositoryJPA.save(mascota);
    }

    @Override
    public void save(Mascota mascota) {
        mascota.setCliente(clienteRepositoryJPA.findById(mascota.getCedulaDuenho()).orElse(null));
        mascotaRepositoryJPA.save(mascota);
    }
/* 
    @Override
    public Collection<Mascota> findMascotaByClienteId(Long id) {
        return repo.findMascotaByClienteId(id);
    }
        */
}