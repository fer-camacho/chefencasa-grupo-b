package com.grupo.demo.repositories;

import com.grupo.demo.entities.PopularidadReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("popularidadRecetaRepository")

public interface IPopularidadRecetaRepository extends JpaRepository<PopularidadReceta, Serializable> {

    @Query(nativeQuery=true,value="Select r.* from popularidad_receta r where r.id_receta = (:idReceta)")
    public abstract PopularidadReceta getPopularityByRecipeId(int idReceta );
}
