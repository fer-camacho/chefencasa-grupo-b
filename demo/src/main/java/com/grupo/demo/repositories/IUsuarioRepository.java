package com.grupo.demo.repositories;

import com.grupo.demo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

    @SuppressWarnings("unchecked")
    public Usuario save(Usuario usuario);

    @Query(nativeQuery=true,value="Select count(*) from usuario where usuario.usuario=(:usuario)")
    public int existe(String usuario);

    @Query(nativeQuery=true,value="Select * from usuario where usuario.id=(:id)")
    public abstract Usuario traerUsuarioPorId(int id);

    @Query(nativeQuery=true,value="Select u.* from usuario u where u.id in (select usuarios_seguidos from usuario_usuarios_seguidos us2 where us2.usuario_id = (:id))")
    public abstract List<Usuario> traerUsuariosSeguidos(int id);

    @Query(nativeQuery=true,value="Select * from usuario where usuario.usuario=(:usuario) and usuario.password=(:password)")
    public abstract Optional<Usuario> traerUsuarioPorUsuarioYPassword(String usuario, String password);
}
