package com.grupo.demo.dtos;

import java.util.Set;

public class RecetaDTO {
	
	private int id;
	private String titulo;
	private String descripcion;
	private int tiempo_preparacion;
	private CategoriaDTO categoria;
	private Set<PasoDTO> pasos;
	private Set<FotoDTO> fotos;
	private Set<IngredienteDTO> ingredientes;
	
	public RecetaDTO() {
		super();
	}
	
	public RecetaDTO(int id, String titulo, String descripcion, int tiempo_preparacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
	}

	public RecetaDTO(int id, String titulo, String descripcion, int tiempo_preparacion, CategoriaDTO categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.categoria = categoria;
	}
	
	public RecetaDTO(int id, String titulo, String descripcion, int tiempo_preparacion, CategoriaDTO categoria,
			Set<PasoDTO> pasos, Set<FotoDTO> fotos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.categoria = categoria;
		this.pasos = pasos;
		this.fotos = fotos;
	}

	public RecetaDTO(int id, String titulo, String descripcion, int tiempo_preparacion, CategoriaDTO categoria,
			Set<PasoDTO> pasos, Set<FotoDTO> fotos, Set<IngredienteDTO> ingredientes) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public Set<PasoDTO> getPasos() {
		return pasos;
	}

	public void setPasos(Set<PasoDTO> pasos) {
		this.pasos = pasos;
	}

	public Set<FotoDTO> getFotos() {
		return fotos;
	}

	public void setFotos(Set<FotoDTO> fotos) {
		this.fotos = fotos;
	}

	public Set<IngredienteDTO> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<IngredienteDTO> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
