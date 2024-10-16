package com.example.demo.controlador;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.servicio.MascotaService;
import com.example.demo.servicio.TratamientoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {

    @Autowired
    TratamientoService tratamientoService;

    @GetMapping("/add")
    public String mostrarFormularioCrearFormulario(Model model) {
        Tratamiento tratamiento = new Tratamiento();
        model.addAttribute("tratamiento", tratamiento);
        return "/addTratamiento";
    }

    @PostMapping("/add")
    public void agregarTratamiento(@RequestBody Tratamiento tratamiento) {
        tratamientoService.save(tratamiento);
        // Antes la mascota venía directamente del form, ahora viene del cuerpo de la
        // petición
    }

    @GetMapping("/findByMascotaId/{id}")
    @Operation(summary = "Mostrar todos los tratamientos de una mascota")
    public Collection<Tratamiento> mostrarTratamientosMascota(@PathVariable("id") Long id) {
        return tratamientoService.SearchByMascotaId(id);
    }
}
