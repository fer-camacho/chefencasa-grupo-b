package com.grupo.demo.converters;

import com.grupo.demo.dtos.RecetaDTO;
import com.grupo.demo.dtos.UsuarioDTO;
import com.grupo.demo.entities.Usuario;

public class UsuarioConverter {


    public UsuarioConverter(){

    }

    public static UsuarioDTO fromUsuarioToUsuarioDTO(Usuario Usuario){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(Usuario.getId());
        dto.setNombre(Usuario.getNombre());
        dto.setEmail(Usuario.getEmail());
        dto.setUsuario(Usuario.getUsuario());
        dto.setPassword(Usuario.getPassword());
        return dto;
    }
}
