package com.example.demo.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Administrador;

import com.example.demo.repositorio.AdministradorRepository;


@Service
public class AdministradorServiceImpl implements AdministradorService{

    @Autowired
    private AdministradorRepository repoJPAAdmi;

  

    @Override
    public Administrador findById(Long id) {
        return repoJPAAdmi.findById(id).orElse(null);
    }

    @Override
    public List<Administrador> SearchAll() {
        return repoJPAAdmi.findAll();
    }

    @Override
    public Administrador findByUsuario(String usuario){
        return repoJPAAdmi.findByUsuario(usuario);
    }
    
}
