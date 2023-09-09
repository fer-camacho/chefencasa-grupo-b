package com.grupo.demo.converters;

import com.grupo.demo.dtos.RecetaDTO;
import com.grupo.demo.dtos.UsuarioDTO;
import com.grupo.demo.entities.Usuario;

public class UsuarioConverter {


    public UsuarioConverter(){

    }
    public static Usuario fromUsuarioDTOtoUsuario(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setUsuario(dto.getUsuario());
        usuario.setPassword(dto.getPassword());
        usuario.setEmail(dto.getEmail());

        return usuario;
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
