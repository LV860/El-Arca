package com.example.demo.controlador;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class VetClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes";
    }

    @GetMapping("/añadir")
    public String añadirClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "añadirCliente";
    }

    @PostMapping("/añadir")
    public String añadirCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{cedula}")
    public String editarClienteForm(@PathVariable String cedula, Model model) {
        Cliente cliente = clienteRepository.findByCedula(cedula)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        model.addAttribute("cliente", cliente);
        return "editarCliente";
    }

    @PostMapping("/editar")
    public String editarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.update(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam String cedula) {
        clienteRepository.deleteByCedula(cedula);
        return "redirect:/clientes";
    }
}
