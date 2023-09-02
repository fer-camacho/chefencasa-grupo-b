package com.grupo.demo.repositories;

import com.grupo.demo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import com.grupo.demo.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Categoria, Serializable> {

    @SuppressWarnings("unchecked")
    public Usuario save(Usuario usuario);

    @Query(nativeQuery=true,value="Select count(*) from usuario where usuario.usuario=(:usuario)")
    public  int existe(String usuario);
}