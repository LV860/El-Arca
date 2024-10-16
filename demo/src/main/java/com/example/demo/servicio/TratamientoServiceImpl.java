package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Tratamiento;
import com.example.demo.repositorio.DrogaRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository repoJPA;
    @Autowired
    private DrogaRepository repoDrogaJPA;
    @Autowired
    private VeterinarioRepository repoVetJPA;
    @Autowired
    private MascotaRepository repoMascotaJPA;

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
        tratamiento.setDroga(repoDrogaJPA.findById(tratamiento.getDrogaIdLong()).get());
        tratamiento.setMascota(repoMascotaJPA.findById(tratamiento.getMascotaIdLong()).get());
        tratamiento.setVeterinario(repoVetJPA.findById(tratamiento.getVeterinarioIdLong()).get());
        repoJPA.save(tratamiento);
        repoDrogaJPA.findById(tratamiento.getDrogaIdLong()).ifPresent(droga -> {
            droga.setUnidadesVendidas(droga.getUnidadesVendidas() + 1);
            repoDrogaJPA.save(droga);
        });
    }

    @Override
    public Collection<Tratamiento> SearchByMascotaId(Long id) {
        return repoJPA.findByMascotaId(id);
    }

}
