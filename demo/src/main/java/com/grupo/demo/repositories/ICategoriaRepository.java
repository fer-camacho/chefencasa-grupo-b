package com.grupo.demo.repositories;

import java.io.Serializable;

import com.grupo.demo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("categoriaRepository")
public interface ICategoriaRepository extends JpaRepository<Categoria, Serializable> {
	
	@SuppressWarnings("unchecked")
	public Categoria save(Categoria categoria);
	
	@Query(nativeQuery=true,value="Select * from categoria")
	public List<Categoria> traerTodos();
	
	public abstract Categoria findByDescripcion(String descripcion);
	public abstract Categoria findById(int id);
}
