package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

@Controller
@RequestMapping("/dueño")
public class DuenhoController {
    

    @Autowired
    private ClienteService clienteService;
    

    @PostMapping("/perfilCliente")
    public String añadirCliente(@ModelAttribute Cliente cliente, Model model) {
        Cliente duenho = clienteService.findByCedula(cliente.getCedula());

        if(duenho != null) {
            model.addAttribute("cliente", duenho);
            return "html/perfilCliente";
        } else {
            return "redirect:/home/loginCliente";
        }
    }

}
