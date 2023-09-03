package com.grupo.demo.repositories;

import com.grupo.demo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

import com.grupo.demo.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

    @SuppressWarnings("unchecked")
    public Usuario save(Usuario usuario);

    @Query(nativeQuery=true,value="Select count(*) from usuario where usuario.usuario=(:usuario)")
    public int existe(String usuario);

    @Query(nativeQuery=true,value="Select * from usuario where usuario.id=(:id)")
    public abstract Usuario traerUsuarioPorId(int id);

    @Query(nativeQuery=true,value="Select * from usuario where usuario.nombre=(:nombre)")
    public abstract Usuario traerUsuarioNombre(String nombre);
}
