package com.grupo.demo.services;

import com.grupo.demo.dtos.CategoriaDTO;
import com.grupo.demo.dtos.IngredienteDTO;
import com.grupo.demo.entities.Categoria;
import com.grupo.demo.entities.Ingrediente;
import com.grupo.demo.entities.Usuario;
import com.grupo.demo.repositories.IIngredienteRepository;
import com.grupo.demo.repositories.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.grupo.demo.dtos.UsuarioDTO;

@Service("ingredienteService")
public class IngredienteService {
    @Autowired
    IIngredienteRepository ingredienteRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<String> crearIngrediente(IngredienteDTO ingrediente){
        Ingrediente aux = modelMapper.map(ingrediente, Ingrediente.class);
        if (aux.getDescripcion().equals("four")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ingrediente no fue agregada porque ya existe");
        }
        ingredienteRepository.save(aux);
        return ResponseEntity.status(HttpStatus.CREATED).body("El ingrediente fue agregada correcatamente");
    }
}
