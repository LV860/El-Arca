package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/find")
    public String mostrarInfoMascota(){
        return "mostrar_mascotas";
    }


}
