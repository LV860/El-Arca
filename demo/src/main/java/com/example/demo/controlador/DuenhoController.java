package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

@Controller
@RequestMapping("/dueño")
public class DuenhoController {
    

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MascotaService mascotaService;
    

    @PostMapping("/perfilCliente")
    public String añadirCliente(@ModelAttribute Cliente cliente, Model model) {
        Cliente duenho = clienteService.findByCedula(cliente.getCedula());

        if(duenho != null) {
            model.addAttribute("cliente", duenho);
            model.addAttribute("mascotas", mascotaService.findMascotaByCedulaDuenho(cliente.getCedula()));
            return "html/perfilCliente";
        } else {
            return "redirect:/home/loginCliente";
        }

    }

}
