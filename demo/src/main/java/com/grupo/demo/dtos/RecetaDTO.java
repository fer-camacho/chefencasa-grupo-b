package com.grupo.demo.dtos;

import java.util.Set;

public class RecetaDTO {
	
	private int id;
	private String titulo;
	private String descripcion;
	private int tiempo_preparacion;
	private String categoria;
	private Set<String> pasos;
	private Set<String> fotos;
	private Set<String> ingredientes;
	private int autorId;

	public RecetaDTO() {
		super();
	}
	
	public RecetaDTO(int id, String titulo, String descripcion, int tiempo_preparacion, int autorId) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.autorId = autorId;
	}

	public RecetaDTO(int id, String titulo, String descripcion, int tiempo_preparacion, int autorId, String categoria) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.autorId = autorId;
		this.categoria = categoria;
	}

	public RecetaDTO(int id, String titulo, String descripcion, int tiempo_preparacion, int autorId, String categoria, Set<String> pasos, Set<String> fotos, Set<String> ingredientes, Set<Integer> favoritos) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.autorId = autorId;
		this.categoria = categoria;
		this.pasos = pasos;
		this.fotos = fotos;
		this.ingredientes = ingredientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTiempo_preparacion() {
		return tiempo_preparacion;
	}

	public void setTiempo_preparacion(int tiempo_preparacion) {
		this.tiempo_preparacion = tiempo_preparacion;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set<String> getPasos() {
		return pasos;
	}

	public void setPasos(Set<String> pasos) {
		this.pasos = pasos;
	}

	public Set<String> getFotos() {
		return fotos;
	}

	public void setFotos(Set<String> fotos) {
		this.fotos = fotos;
	}

	public Set<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
