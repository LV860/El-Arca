package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());
        return "html/veterinarioClientes"; 
    }

    @GetMapping("/añadir")
    public String mostrarFormularioAñadir(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "html/createClientes"; 
    }

    @PostMapping("/añadir")
    public String añadirCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes/all"; 
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "html/updateClientes";
        } else {
            // Manejo de error, podrías redirigir a una página de error o mostrar un mensaje
            return "redirect:/clientes/all";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarCliente(@PathVariable("id") Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id); 
        clienteService.update(cliente);
        return "redirect:/clientes/all"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return "redirect:/clientes/all"; 
    }

    @GetMapping("/perfil")
    public String landingPage() {
        return "html/perfilVeterinario";
    }
}
