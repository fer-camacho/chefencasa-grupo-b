package com.grupo.demo.repositories;

import com.grupo.demo.entities.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository("recetaRepository")
public interface IRecetaRepository extends JpaRepository<Receta, Serializable> {
}
