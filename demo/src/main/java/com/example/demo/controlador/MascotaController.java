package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidad.Mascota;
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
    @GetMapping("/add")
    public String mostrarFormularioCrearMascota(Model model){

        Mascota mascota = new Mascota(0,"", "", 0, 0, "", "");
        model.addAttribute("mascota", mascota);

        //NO SE HA CREADO EL HTML PARA CREAR MASCOTA
        return "html/crearMascotaPage";
    }

    @PostMapping("/add")
    public String agregarMascota(@ModelAttribute("mascota") Mascota mascota){

        mascotaService.add(mascota);
        return "redirect:/mascota/all";
    }

    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable("id") int id){
        mascotaService.deleteById(id);
        return "redirect:/mascota/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "html/updateMascota";
    }

    @PostMapping("/update/{id}")
    public String updateMascota(@PathVariable("id") int id, @ModelAttribute("mascota") Mascota mascota){
        mascotaService.update(mascota);
        return "redirect:/mascota/all";
    }


}
