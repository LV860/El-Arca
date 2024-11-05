package com.example.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entidad.Veterinario;
//import com.example.demo.DTOs.VeterinarioDTO;

@Mapper
public interface VeterinarioMapper {

    VeterinarioMapper INSTANCE = Mappers.getMapper(VeterinarioMapper.class);

    VeterinarioDTO convert(Veterinario veterinario);
}
