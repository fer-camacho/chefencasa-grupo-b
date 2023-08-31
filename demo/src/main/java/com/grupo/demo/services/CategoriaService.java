package com.grupo.demo.services;


import com.grupo.demo.entities.Categoria;
import com.grupo.demo.repositories.ICategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.grupo.demo.dtos.CategoriaDTO;
@Service("categoriaService")
public class CategoriaService {

	@Autowired
	ICategoriaRepository categoriaRepository;
	ModelMapper modelMapper = new ModelMapper();

	public ResponseEntity<String> crearCategoria(CategoriaDTO categoria){
		Categoria aux = modelMapper.map(categoria, Categoria.class);
		if (aux.getDescripcion().equals("four")){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La categoria no fue agregada porque ya existe");

		}
		categoriaRepository.save(aux);
		return ResponseEntity.status(HttpStatus.CREATED).body("La categoria fue agregada correcatamente");
	}
}

