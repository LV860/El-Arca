package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.AdminDTO;
import com.example.demo.DTOs.AdminMapper;
import com.example.demo.DTOs.ClienteDTO;
import com.example.demo.DTOs.ClienteMapper;
import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
//import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.AdministradorService;
//import com.example.demo.servicio.ClienteService;
//import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

    @Autowired
    private AdministradorService admiService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    /*
     * @Autowired
     * private ClienteService clienteService;
     * 
     * @Autowired
     * private VeterinarioService veterinarioService;
     */

    @GetMapping("/all")
    @Operation(summary = "Mostrar todas los clientes")
    public List<Administrador> listarClientes() {
        return admiService.SearchAll();
    }

    @GetMapping("/details")
    public ResponseEntity<Administrador> buscarCliente() {
        // Un usuario que llega ala url ya está autenticado
        Administrador administrador = admiService.findByUsuario(
                // guarda un objeto de autenticacion y este objeto tiene los datos
                // Puedo acceder a el desde cualquier lado de la aplicacion
                String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()));

        //AdminDTO adminDTO = AdminMapper.INSTANCE.convert(administrador);

        if (administrador == null) {
            return new ResponseEntity<Administrador>(administrador, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public Administrador mostrarInfoAdmi(@PathVariable("id") Long id) {
        return admiService.findById(id);
    }

    @GetMapping("/findUsuario/{usuario}")
    public Administrador mostrarInfoAdmi2(@PathVariable("usuario") String usuario) {
        return admiService.findByUsuario(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity loginCliente(@RequestBody Administrador administrador) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(administrador.getUsuario(), administrador.getContrasena()));
        // tiene un atributo que es la autenticacion y es donde guardare la
        // autenticacion
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

}