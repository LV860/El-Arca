package com.example.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInitCliente implements ApplicationRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clienteRepository.save(new Cliente("12345", "juanchito@gmail.com", "3216547414", "Juan Andres Orjueña Bello"));
        clienteRepository.save(new Cliente("67890", "pipe@gmail.com", "3163597104", "Daniel Felipe Bello Navas"));
    }
    
}