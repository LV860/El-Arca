package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;
//import com.example.demo.servicio.MascotaService;

@Controller
@RequestMapping("/dueño")
public class DuenhoController {

    @Autowired
    private ClienteService clienteService;
    //@Autowired
    //private MascotaService mascotaService;

    @PostMapping("/perfilCliente")
    public String mostrarPerfilCliente(@ModelAttribute Cliente cliente, Model model) {
        try {
            Cliente duenho = clienteService.findById(cliente.getCedula());

            if (duenho != null) {
                model.addAttribute("cliente", duenho);
                model.addAttribute("mascotas", duenho.getMascotas());
                System.out.println("mascotas: " + duenho.getMascotas().size());
                System.out.println("cedula: " + duenho.getCedula());
                return "/perfilCliente";
            } else {
                model.addAttribute("error", "No se encontró el cliente con la cédula proporcionada.");
                return "/loginClienteError";
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, registrándola o mostrando un mensaje de error
            System.err.println("Ocurrió un error: " + e.getMessage());
            model.addAttribute("error", "Ocurrió un error al intentar mostrar el perfil del cliente.");
            return "/loginClienteError";
        }
    }

}
