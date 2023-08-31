package com.grupo.demo.dtos;

import java.util.Set;

public class CategoriaDTO {
	private int id;
	private String descripcion;
	private Set<RecetaDTO> recetas;
	
	public CategoriaDTO() {
		super();
	}
	
	public CategoriaDTO(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public CategoriaDTO(int id, String descripcion, Set<RecetaDTO> recetas) {
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

	public Set<RecetaDTO> getRecetas() {
		return recetas;
	}

	public void setRecetas(Set<RecetaDTO> recetas) {
		this.recetas = recetas;
	}
	
}
