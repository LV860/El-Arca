package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.NotFoundException;
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
    public String añadirCliente(@ModelAttribute Cliente cliente, Model model) {
        clienteService.save(cliente);
        model.addAttribute("clientes", clienteService.SearchAll());
        return "redirect:/clientes/all"; // Redirige después de añadir
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "html/updateClientes";
        } else {
            throw new NotFoundException(id.toString());
        }
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarCliente(@PathVariable("id") Long id, @ModelAttribute Cliente cliente, Model model) {
        cliente.setId(id); // Asegúrate de que el id se setee correctamente
        clienteService.update(cliente);
        model.addAttribute("clientes", clienteService.SearchAll());
        return "redirect:/clientes/all"; // Redirige después de actualizar
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id, Model model) {
        clienteService.delete(id);
        model.addAttribute("clientes", clienteService.SearchAll());
        return "redirect:/clientes/all"; // Redirige después de eliminar
    }

    @GetMapping("/perfil")
    public String landingPage() {
        return "html/perfilVeterinario";
    }
}
