package com.grupo.demo.repositories;

import com.grupo.demo.entities.PopularidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("popularidadUsuarioRepository")
public interface IPopularidadUsuarioRepository extends JpaRepository<PopularidadUsuario, Serializable> {

    @Query(nativeQuery=true,value="SELECT pu.* FROM popularidad_usuario pu WHERE pu.nombre_usuario = (:nombreUsuario)")
    public abstract PopularidadUsuario getPopularityByUserName(String nombreUsuario );
}
