package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Droga;
import com.example.demo.servicio.AdministradorService;
import com.example.demo.servicio.DrogaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {


    @Autowired
    private DrogaService drogaService;

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
        List<Droga> drogas = drogaService.SearchAll();

        for (Droga droga : drogas) {
            if (droga.getId() == id) {
                unidadesVendidas = droga.getUnidadesVendidas();
            }
        }
        
        return unidadesVendidas;
    }

    @GetMapping("/uDisponiblesDroga/{id}")
    public int mostrarInfoDrogaUnidadesDisponibles(@PathVariable("id") Long id) {
        int unidadesDisponibles = 0;
        List<Droga> drogas = drogaService.SearchAll();

        for (Droga droga : drogas) {
            if (droga.getId() == id) {
                unidadesDisponibles = droga.getUnidadesDisponibles();
            }
        }
        
        return unidadesDisponibles;
    }

    
}
