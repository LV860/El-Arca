package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.MascotaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
// @CrossOrigin(origins = "*")
// @CrossOrigin(origins =
// "https://8090-lv860-elarca-ga5bpzkaevl.ws-us116.gitpod.io")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    @Operation(summary = "Mostrar todas las mascotas")
    public List<Mascota> mostrarMascotas() {
        // model.addAttribute("mascotas", mascotaService.SearchAll());
        // return "/tabla_Mascotas";
        return mascotaService.SearchAll();
    }

    @GetMapping("/find/{id}")
    public Mascota mostrarInfoMascota(@PathVariable("id") Long id) {
        // model.addAttribute("mascota", mascotaService.SearchById(id));
        // return "/mostrarMascotaPage";
        return mascotaService.SearchById(id);
    }

    @GetMapping("/find")
    public Mascota mostrarInfoMascota2(@RequestParam("id") Long id) {
        // model.addAttribute("mascota", mascotaService.SearchById(id));
        // return "/mostrarMascotaPage";
        return mascotaService.SearchById(id);
    }

    @GetMapping("/add")
    public String mostrarFormularioCrearMascota(Model model) {
        Mascota mascota = new Mascota();
        model.addAttribute("mascota", mascota);
        return "/addMascota";
    }

    @PostMapping("/add")
    public void agregarMascota(@RequestBody Mascota mascota) {
        mascota.setEstado("En tratamiento");
        mascotaService.save(mascota);
        // Antes la mascota venía directamente del form, ahora viene del cuerpo de la
        // petición
    }

    @DeleteMapping("/delete/{id}")
    public void borrarMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "/updateMascota";
    }

    @PutMapping("/update/{id}")
    public void updateMascota(@RequestBody Mascota mascota) {
        mascotaService.update(mascota);
    }

    @GetMapping("/search")
    public String searchMascotas(@RequestParam("query") String query,
            @RequestParam("filterBy") String filterBy,
            Model model) {

        // Determine which filter to use
        switch (filterBy) {
            case "todos":
                model.addAttribute("mascotas", mascotaService.SearchAll());
                return "tabla_Mascotas";

            case "id":
                try {
                    // Convert query to Long for ID search
                    model.addAttribute("mascotas", mascotaService.SearchById(Long.parseLong(query)));
                } catch (NumberFormatException e) {
                    // Handle invalid number format
                    model.addAttribute("mascotas", mascotaService.SearchAll());
                }
                return "tabla_Mascotas";

            case "nombre":
                model.addAttribute("mascotas", mascotaService.findMascotaByNombre(query));
                return "tabla_Mascotas";

            case "raza":
                model.addAttribute("mascotas", mascotaService.findMascotaByRaza(query));
                return "tabla_Mascotas";

            case "enfermedad":
                model.addAttribute("mascotas", mascotaService.findMascotaByEnfermedad(query));
                return "tabla_Mascotas";

            case "inactiva":
                model.addAttribute("mascotas", mascotaService.findMascotaByEstado("Inactiva"));
                return "tabla_Mascotas";

            case "en tratamiento":
                model.addAttribute("mascotas", mascotaService.findMascotaByEstado("En tratamiento"));
                return "tabla_Mascotas";

            default:
                model.addAttribute("mascotas", mascotaService.SearchAll());
                return "tabla_Mascotas";
        }
    }
}
