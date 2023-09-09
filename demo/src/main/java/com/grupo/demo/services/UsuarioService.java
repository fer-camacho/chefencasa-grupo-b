package com.grupo.demo.services;

import com.grupo.demo.constants.UsuarioConstants;
import com.grupo.demo.converters.UsuarioConverter;
import com.grupo.demo.dtos.ResponseData;
import com.grupo.demo.entities.Receta;
import com.grupo.demo.entities.Usuario;
import com.grupo.demo.repositories.IRecetaRepository;
import com.grupo.demo.repositories.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.grupo.demo.dtos.UsuarioDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("usuarioService")
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IRecetaRepository recetaRepository;

    @Autowired
    RecetaService recetaService;

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
    public ResponseEntity<String> marcarFavorita(int id_receta, int id_usuario){
        Usuario usuario = usuarioRepository.traerUsuarioPorId(id_usuario);
        Set<Integer> recetasFavoritas = usuario.getRecetasFavoritas();
        String body = "";
        if (recetasFavoritas.contains(id_receta)){
            recetasFavoritas.remove(id_receta);
            body = "La receta fue desmarcada de favoritas.";
        } else {
            usuario.getRecetasFavoritas().add(id_receta);
            body = "La receta fue marcada como favorita.";
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    public ResponseEntity<String> seguirUsuario(int id_usuario, int id_usuario_seguido){
        Usuario usuario = usuarioRepository.traerUsuarioPorId(id_usuario);
        Set<Integer> usuariosSeguidos = usuario.getUsuariosSeguidos();
        String body = "";
        if (usuariosSeguidos.contains(id_usuario_seguido)){
            usuariosSeguidos.remove(id_usuario_seguido);
            body = "Se dejó de seguir al usuario.";
        } else {
            usuario.getUsuariosSeguidos().add(id_usuario_seguido);
            body = "Se comenzó a seguir al usuario.";
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    public ResponseData<UsuarioDTO> traerUsuarioPorId(int id) {
        Optional<Usuario> userResult =  usuarioRepository.findById(id);
        return userResult.map(
                user -> new ResponseData<>(UsuarioConverter.fromUsuarioToUsuarioDTO(user),
                        UsuarioConstants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, UsuarioConstants.USER_NOT_FOUND_ERROR_MESSAGE));
    }

    public List<Receta> traerRecetasFavoritas(int id) {
        return recetaRepository.traerRecetasFavoritas(id);
    }

    public List<Usuario> traerUsuariosSeguidos(int id) {
        return usuarioRepository.traerUsuariosSeguidos(id);
    }
}
