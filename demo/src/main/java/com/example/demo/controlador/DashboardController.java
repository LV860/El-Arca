package com.example.demo.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.servicio.AdministradorService;
import com.example.demo.servicio.DrogaService;
import com.example.demo.servicio.MascotaService;
import com.example.demo.servicio.TratamientoService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {


    @Autowired
    private DrogaService drogaService;

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private MascotaService mascotaService;


    @GetMapping("/all")
    @Operation(summary = "Mostrar todas las drogas")
    public List<Droga> listarDrogas() {
        return drogaService.SearchAll();
    }

    @GetMapping("/find/{id}")
    public Droga mostrarInfoDroga(@PathVariable("id") Long id) {
        return drogaService.findById(id);
    }



    @GetMapping("/uVendidasDroga/{id}")
    public int mostrarInfoDrogaUnidadesVendidas(@PathVariable("id") Long id) {
        int unidadesVendidas = 0;
        unidadesVendidas = drogaService.obtenerUnidadesVendidas(id);
        return unidadesVendidas;
    }

    @GetMapping("/uDisponiblesDroga/{id}")
    public int mostrarInfoDrogaUnidadesDisponibles(@PathVariable("id") Long id) {
        int unidadesDisponibles = 0;
        unidadesDisponibles = drogaService.obtenerUnidadesDisponibles(id);
        return unidadesDisponibles;
    }

    @GetMapping("/total/tratamientosUltimoMes")
    public int getTotalTratamientosUltimoMes() {
        int total = tratamientoService.getCantidadTratamientosUltimoMes();
        return total;
    }

    @GetMapping("/total/tratamientosUltimoMes/porDroga")
    public Map<String, Integer> getTratamientosPorDrogaUltimoMes() {
        Map<String, Integer> respuesta = tratamientoService.getTratamientosPorDrogaUltimoMes();
        return respuesta;
    }


    @GetMapping("/veterinariosActivos/cantidad")
    public int mostrarCantidadVeterinariosActivos() {
        return veterinarioService.obtenerCantidadVeterinariosActivos();
    }

    @GetMapping("/veterinariosInactivos/cantidad")
    public int mostrarCantidadVeterinariosInactivos() {
        return veterinarioService.obtenerCantidadVeterinariosInactivos();
    }


    @GetMapping("/mascotas/total")
    public int getTotalMascotas() {
        int totalMascotas = mascotaService.getTotalMascotas();  // Obtiene el total como Long
        return totalMascotas;  // Devuelve el total como un long
    }

    @GetMapping("/mascotas/activas")
    public int getTotalMascotasEnTratamiento() {
        int totalMascotasEnTratamiento = mascotaService.getTotalMascotasEnTratamiento(); // Obtiene el total de mascotas en tratamiento
        return totalMascotasEnTratamiento; // Devuelve el total como un entero
    }


    @GetMapping("/ventas/totales")
    public Float getTotalVentas() {
        Float totalVentas = tratamientoService.getTotalVentas(); // Obtiene el total de ventas
        return totalVentas; // Devuelve el total como un Float
    }

    @GetMapping("/ganancias/totales")
    public Float getTotalGanancias() {
        Float totalGanancias = tratamientoService.getTotalGanancias(); // Obtiene el total de ganancias
        return totalGanancias; // Devuelve el total como un Float
    }

    @GetMapping("/top3/tratamientosMasCaros")
    public List<Tratamiento> getTop3TratamientosMasCaros() {
        List<Tratamiento> top3Tratamientos = tratamientoService.getTop3TratamientosMasCaros(); // Obtiene los top 3 tratamientos
        return top3Tratamientos; // Devuelve la lista de tratamientos
    }

    
}
