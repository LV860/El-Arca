package com.example.demo.DTOs;

import org.mapstruct.factory.Mappers;

import com.example.demo.entidad.Administrador;

public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDTO convert(Administrador administrador);

}
