package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.servicio.ClienteService;

@RequestMapping("/clientes")
@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "html/tabla_Clientes"; // Nombre del archivo HTML para la lista de clientes
    }

    @GetMapping("/find/{id}")
    public String mostrarInfoCliente(Model model, @PathVariable("id") Long id) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        model.addAttribute("cliente", cliente);
        return "html/mostrarClientePage"; // Nombre del archivo HTML para mostrar información del cliente
    }

    @GetMapping("/find")
    public String mostrarInfoCliente2(Model model, @RequestParam("id") Long id) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        model.addAttribute("cliente", cliente);
        return "html/mostrarClientePage"; // Nombre del archivo HTML para mostrar información del cliente
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        model.addAttribute("cliente", cliente);
        return "html/editarCliente"; // Nombre del archivo HTML para editar cliente
    }

    @PostMapping("/editar")
    public String guardarCambios(@RequestParam("id") Long id, @RequestParam("nombre") String nombre,
                                 @RequestParam("correo") String correo, @RequestParam("celular") String celular) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setCelular(celular);
        clienteService.save(cliente);
        return "redirect:/clientes/all"; // Redirige a la lista de clientes después de guardar
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes/all"; // Redirige a la lista de clientes después de eliminar
    }
}
