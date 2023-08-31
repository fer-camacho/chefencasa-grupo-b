package com.grupo.demo.entities;

import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="descripcion", nullable = false)
	protected String descripcion;

	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="categoria")
	private Set<Receta> recetas;
	
	public Categoria() {
		super();
	}
	
	public Categoria(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Categoria(int id, String descripcion, Set<Receta> recetas) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.recetas = recetas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Receta> getRecetas() {
		return recetas;
	}

	public void setReceta(Set<Receta> recetas) {
		this.recetas = recetas;
	}

}
