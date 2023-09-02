package com.grupo.demo.repositories;

import com.grupo.demo.entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("ingredienteRepository")
public interface IIngredienteRepository extends JpaRepository<Ingrediente, Serializable>{

    @SuppressWarnings("unchecked")
        Ingrediente save(Ingrediente ingrediente);
        @Query(nativeQuery=true,value="Select * from ingrediente")
        public List<Ingrediente> traerTodos();
        public abstract Ingrediente findByDescripcion(String descripcion);
        public abstract Ingrediente findById(int id);

}
