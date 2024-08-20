package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.NotFoundException;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.servicio.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("all")
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
        return "html/veterinarioClientes";
    }

    
    @GetMapping("/editar")
    public String mostrarFormularioEditarCliente(@RequestParam("cedula") String cedula, Model model) {
        Cliente cliente = clienteService.findByCedula(cedula);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "html/updateClientes";
        }
        else {
            throw new NotFoundException(cedula);
        }
        //return "redirect:/clientes/all"; 
    }
    
    @PostMapping("/editar")
    public String actualizarCliente(@ModelAttribute Cliente cliente, Model model) {
        clienteService.update(cliente);
        model.addAttribute("clientes", clienteService.SearchAll());
        return "html/veterinarioClientes"; 
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam("cedula") String cedula, Model model) {
        clienteService.delete(cedula);
        model.addAttribute("clientes", clienteService.SearchAll());
        return "html/veterinarioClientes"; 
    }
}