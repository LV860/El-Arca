package com.example.demo.servicio;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import org.springframework.data.repository.query.Param;
import java.util.List;

import com.example.demo.entidad.Tratamiento;

public interface TratamientoService {

    Tratamiento findById(Long id);

    Collection<Tratamiento> SearchAll();

    void delete(Long id);

    void update(Tratamiento tratamiento);

    void save(Tratamiento tratamiento);

    Collection<Tratamiento> SearchByMascotaId(Long id);

    Collection<Tratamiento> SearchByVeterinarioId(Long id);


    int getCantidadTratamientosUltimoMes();
    Map<String, Integer> getTratamientosPorDrogaUltimoMes();
    Float getTotalVentas();
    Float getTotalGanancias();
    List<Tratamiento> getTop3TratamientosMasCaros();
}
