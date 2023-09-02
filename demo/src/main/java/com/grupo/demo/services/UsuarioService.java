package com.grupo.demo.services;

import com.grupo.demo.entities.Usuario;
import com.grupo.demo.repositories.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.grupo.demo.dtos.UsuarioDTO;
@Service("usuarioService")
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    ModelMapper modelMapper = new ModelMapper();
    public ResponseEntity<String> crearUsuario(UsuarioDTO usuario){
        Usuario aux = modelMapper.map(usuario, Usuario.class);
        String nombreUsuario = usuario.getUsuario();
        if (usuarioRepository.existe(nombreUsuario)>0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario no se agrego porque ya existe");
        }
        usuarioRepository.save(aux);
        return ResponseEntity.status(HttpStatus.CREATED).body("El usuario fue agregado correctamente");

    }
}
