package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.DTOs.ClienteDTO;
import com.example.demo.DTOs.ClienteMapper;
import com.example.demo.DTOs.VeterinarioDTO;
import com.example.demo.DTOs.VeterinarioMapper;
import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.UserEntity;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;
//import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @GetMapping("/all")
    @Operation(summary = "Mostrar todas los clientes")
    public ResponseEntity<List<Cliente>> listarClientes(Model model) {

        List<Cliente> lista = clienteService.SearchAll();
        ResponseEntity<List<Cliente>> response = new ResponseEntity<>(lista, HttpStatus.OK);

        return response;
    }

    @GetMapping("/findCedula/{cedula}")
    public Cliente findByCedula(@PathVariable("cedula") Long cedula) {
        return clienteService.findByCedula(cedula);
    }

    @GetMapping("/details")
    public ResponseEntity<ClienteDTO> buscarCliente() {
        // Un usuario que llega ala url ya está autenticado
        Cliente cliente = clienteService.findByCedula(
                // guarda un objeto de autenticacion y este objeto tiene los datos
                // Puedo acceder a el desde cualquier lado de la aplicacion
                Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName()));

        ClienteDTO clienteDTO = ClienteMapper.INSTANCE.convert(cliente);

        if (cliente == null) {
            return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> mostrarInfoCliente(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Cliente> mostrarInfoCliente2(@RequestParam("id") Long id) {

        Cliente cliente = clienteService.findById(id);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @GetMapping("/findVeterinario")
    public Veterinario buscarVeterinario(@RequestParam("id") Long id) {
        return veterinarioService.findById(id);
    }

    @GetMapping("/createClientes")
    public String mostrarFormularioCrearCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "/createClientes";
    }

    @PostMapping("/add")
    public ResponseEntity agregarCliente(@RequestBody Cliente cliente) {
        /*
         * if (cliente == null) {
         * return new ResponseEntity<String>("No se pudo agregar el cliente",
         * HttpStatus.NOT_FOUND);
         * }
         * Cliente newCliente = clienteService.save(cliente);
         * ClienteDTO clienteDTO = ClienteMapper.INSTANCE.convert(newCliente);
         * if (newCliente == null) {
         * return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.BAD_REQUEST);
         * }
         * 
         * return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.CREATED);
         */

        if (userRepository.existsByUsername(cliente.getCedula().toString())) {
            return new ResponseEntity<String>("Este cliente ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.ClienteToUser(cliente);
        cliente.setUserEntity(userEntity);
        Cliente clienteDB = clienteService.save(cliente);
        ClienteDTO newCliente = ClienteMapper.INSTANCE.convert(clienteDB);
        if (newCliente == null) {
            return new ResponseEntity<ClienteDTO>(newCliente, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ClienteDTO>(newCliente, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity loginCliente(@RequestBody Cliente cliente) {
        /*
         * Cliente clienteEncontrado = clienteService.findByCedula(cliente.getCedula());
         * 
         * if (clienteEncontrado == null) {
         * return new ResponseEntity<String>("No se encontro el cliente",
         * HttpStatus.NOT_FOUND);
         * }
         * 
         * ClienteDTO clienteDto = ClienteMapper.INSTANCE.convert(clienteEncontrado);
         * if (clienteEncontrado.getCedula().equals(cliente.getCedula())) {
         * return new ResponseEntity<ClienteDTO>(clienteDto, HttpStatus.OK);
         * } else {
         * return new ResponseEntity<ClienteDTO>(clienteDto, HttpStatus.BAD_REQUEST);
         * }
         */
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(cliente.getCedula(), "123"));
        // tiene un atributo que es la autenticacion y es donde guardare la
        // autenticacion
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> borrarCliente(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>("DELETED", HttpStatus.NO_CONTENT);
    }

    /*
     * @GetMapping("/update/{id}")
     * public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model
     * model) {
     * model.addAttribute("cliente", clienteService.findById(id));
     * return "/updateClientes";
     * }
     */

    @GetMapping("/update/{id}")
    public ResponseEntity<Cliente> mostrarFormularioUpdate(@RequestBody Cliente cliente, @PathVariable("id") Long id) {
        Cliente clienteFind = clienteService.findById(id);
        cliente.setId(clienteFind.getId());
        Cliente clienteActualiado = clienteService.update(cliente);
        return new ResponseEntity<>(clienteActualiado, HttpStatus.OK);
        // model.addAttribute("cliente", clienteService.findById(id));
        // return "/updateClientes";
    }

    @PutMapping("/update/{id}")
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        // cliente.setCedula(id); // Asegura que el ID se mantenga al actualizar
        // cliente.setEstado(clienteService.findById(id).getEstado()); // Asegura que el
        // ID se mantenga al actualizar

        Logger logger = LoggerFactory.getLogger(ClienteController.class);

        logger.info("cliente: " + cliente.getNombre());
        System.out.println("cliente: " + cliente.getNombre());
        clienteService.update(cliente);
        return cliente;

    }

    /*
     * @GetMapping("/perfil")
     * public List<Veterinario> perfilVeterinario(Model model) {
     * return (List<Veterinario>) veterinarioService.SearchAll();
     * }
     * 
     * @PostMapping("/perfil")
     * public String mostrarPerfil(@ModelAttribute Veterinario veterinario,
     * HttpSession session, Model model) {
     * try {
     * Veterinario user = veterinarioService.findById(veterinario.getId());
     * 
     * if (user != null) {
     * session.setAttribute("veterinario", user); // Store in session
     * 
     * model.addAttribute("veterinario", user);
     * return "/perfilVeterinario";
     * } else {
     * model.addAttribute("error",
     * "No se encontró el veterinario con los datos proporcionados.");
     * return "/loginVeterinarioError";
     * }
     * } catch (Exception e) {
     * // Manejar la excepción, por ejemplo, registrándola o mostrando un mensaje de
     * // error
     * System.err.println("Ocurrió un error: " + e.getMessage());
     * model.addAttribute("error",
     * "Ocurrió un error al intentar mostrar el perfil del veterinario.");
     * return "/loginVeterinarioError";
     * }
     * }
     * 
     * @GetMapping("/logout")
     * public String logout(HttpSession session, SessionStatus sessionStatus) {
     * session.invalidate(); // Invalidate the session
     * // Mostrar un mensaje de error si no se encuentra el veterinario
     * return "redirect:/home/landingPage"; // Redirect to login page
     * }
     * 
     * @GetMapping("/search")
     * // Manejar la excepción, por ejemplo, registrándola o mostrando un mensaje de
     * // error
     * public String searchClientes(@RequestParam("query") String query,
     * 
     * @RequestParam("filterBy") String filterBy,
     * Model model) {
     * 
     * // Determine which filter to use
     * switch (filterBy) {
     * case "todos":
     * model.addAttribute("clientes", clienteService.SearchAll());
     * return "/veterinarioClientes";
     * 
     * case "id":
     * try {
     * // Convert query to Long for ID search
     * model.addAttribute("clientes",
     * clienteService.findById(Long.parseLong(query)));
     * } catch (NumberFormatException e) {
     * // Handle invalid number format
     * model.addAttribute("clientes", clienteService.SearchAll());
     * }
     * return "/veterinarioClientes";
     * 
     * case "nombre":
     * model.addAttribute("clientes", clienteService.findClienteByNombre(query));
     * return "/veterinarioClientes";
     * 
     * case "correo":
     * model.addAttribute("clientes", clienteService.findClienteByCorreo(query));
     * return "/veterinarioClientes";
     * 
     * case "telefono":
     * model.addAttribute("clientes", clienteService.findClienteByCelular(query));
     * return "/veterinarioClientes";
     * 
     * case "inactivo":
     * model.addAttribute("clientes",
     * clienteService.findClienteByEstado("Inactivo"));
     * return "veterinarioClientes";
     * 
     * case "activo":
     * model.addAttribute("clientes", clienteService.findClienteByEstado("Activo"));
     * return "veterinarioClientes";
     * 
     * default:
     * model.addAttribute("clientes", clienteService.SearchAll());
     * return "/veterinarioClientes";
     * }
     * }
     * 
     */

}
