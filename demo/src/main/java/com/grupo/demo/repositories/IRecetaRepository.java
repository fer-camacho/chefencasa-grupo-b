package com.grupo.demo.repositories;

import com.grupo.demo.entities.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("recetaRepository")
public interface IRecetaRepository extends JpaRepository<Receta, Serializable> {

    @Query(nativeQuery=true,value="Select r.* from receta r, usuario_recetas_favoritas ur where r.id = ur.recetas_favoritas and ur.usuario_id = (:id)")
    public abstract List<Receta> traerRecetasFavoritas(int id);
}
