package com.example.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entidad.Cliente;

@Mapper
public interface ClienteMapper {


    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO convert(Cliente cliente);
    
}
