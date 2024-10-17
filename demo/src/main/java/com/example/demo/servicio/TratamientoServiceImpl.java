package com.example.demo.servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TratamientoRepository repoJPATratamiento;
    @Autowired
    private DrogaRepository repoDrogaJPA;
    @Autowired
    private VeterinarioRepository repoVetJPA;
    @Autowired
    private MascotaRepository repoMascotaJPA;


    @Override
    public Tratamiento findById(Long id) {
        return repoJPATratamiento.findById(id).orElse(null);
    }

    @Override
    public Collection<Tratamiento> SearchAll() {
        return repoJPATratamiento.findAll();
    }

    @Override
    public void delete(Long id) {
        repoJPATratamiento.deleteById(id);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        repoJPATratamiento.save(tratamiento);
    }

    @Override
    public void save(Tratamiento tratamiento) {
        tratamiento.setDroga(repoDrogaJPA.findById(tratamiento.getDrogaIdLong()).get());
        tratamiento.setMascota(repoMascotaJPA.findById(tratamiento.getMascotaIdLong()).get());
        tratamiento.setVeterinario(repoVetJPA.findById(tratamiento.getVeterinarioIdLong()).get());
        repoJPATratamiento.save(tratamiento);
        repoDrogaJPA.findById(tratamiento.getDrogaIdLong()).ifPresent(droga -> {
            droga.setUnidadesVendidas(droga.getUnidadesVendidas() + 1);
            repoDrogaJPA.save(droga);
        });
    }

    @Override
    public Collection<Tratamiento> SearchByMascotaId(Long id) {
        return repoJPATratamiento.findByMascotaId(id);
    }

    @Override
    public Collection<Tratamiento> SearchByVeterinarioId(Long id) {
        return repoJPATratamiento.findByVeterinarioId(id);
    }

    @Override
    public int getCantidadTratamientosUltimoMes() {
        // Obtener la fecha actual
        LocalDate ahora = LocalDate.now();
        
        // Calcular el primer día del mes actual
        LocalDate inicioMesActual = ahora.withDayOfMonth(1);
        
        // Calcular el último día del mes actual (primer día del mes siguiente menos un día)
        LocalDate finMesActual = ahora.plusMonths(1).withDayOfMonth(1).minusDays(1);

        // Convertir LocalDate a String con formato "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaInicioStr = inicioMesActual.format(formatter);
        String fechaFinStr = finMesActual.format(formatter);

        // Usar las fechas calculadas para contar tratamientos
        
        return repoJPATratamiento.countTratamientosByFechaAdministracionBetween(fechaInicioStr, fechaFinStr);
    }

    @Override
    public Map<String, Integer> getTratamientosPorDrogaUltimoMes() {
        // Obtener la fecha actual
        LocalDate ahora = LocalDate.now();
        
        // Calcular el primer día del mes actual
        LocalDate inicioMesActual = ahora.withDayOfMonth(1);
        
        // Calcular el último día del mes actual
        LocalDate finMesActual = ahora.plusMonths(1).withDayOfMonth(1).minusDays(1);

        // Convertir LocalDate a String con formato "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaInicioStr = inicioMesActual.format(formatter);
        String fechaFinStr = finMesActual.format(formatter);

        List<Object[]> resultados = repoJPATratamiento.countTratamientosByDrogaLastMonth(fechaInicioStr, fechaFinStr);

        Map<String, Integer> mapaResultado = new HashMap<>();
        for (Object[] resultado : resultados) {
            String droga = (String) resultado[0];
            Long cantidad = (Long) resultado[1];
            mapaResultado.put(droga, cantidad.intValue());
        }

        return mapaResultado;
    }

    @Override
    public Float getTotalVentas() {
        return repoJPATratamiento.calcularVentasTotales(); // Llama al método del repositorio
    }

    @Override
    public Float getTotalGanancias() {
        return repoJPATratamiento.calcularGananciasTotales(); // Llama al método del repositorio
    }

    @Override
    public List<Tratamiento> getTop3TratamientosMasCaros() {
        return repoJPATratamiento.findTop3ByPrecio(); // Llama al método del repositorio
    }


    
}
