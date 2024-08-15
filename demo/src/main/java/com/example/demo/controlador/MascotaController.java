package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.servicio.MascotaService;

@RequestMapping("/mascota")
@Controller
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    public String mostrarMascotas(Model model){
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "html/tabla_Mascotas";
    }
    @GetMapping("/find/{id}")
    public String mostrarInfoMascota(Model model, @PathVariable("id") int identification){
        model.addAttribute("mascotas", mascotaService.SearchById(identification));
        return "html/mostrarMascotaPage";
    }
    @GetMapping("/find")
    public String mostrarInfoMascota2(Model model, @RequestParam("id") int identification){
        model.addAttribute("mascotas", mascotaService.SearchById(identification));
        return "html/mostrarMascotaPage";
    }


}
