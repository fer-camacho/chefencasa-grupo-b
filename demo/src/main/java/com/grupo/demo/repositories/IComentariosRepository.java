package com.grupo.demo.repositories;

import com.grupo.demo.entities.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IComentariosRepository extends JpaRepository<Comentarios, Serializable> {
}
