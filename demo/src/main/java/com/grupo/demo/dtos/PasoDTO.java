package com.grupo.demo.dtos;

public class PasoDTO {
	private int id;
	private String descripcion;
	private RecetaDTO receta;
	
	public PasoDTO() {
		super();
	}
	
	public PasoDTO(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public PasoDTO(int id, String descripcion, RecetaDTO receta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.receta = receta;
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

	public RecetaDTO getReceta() {
		return receta;
	}

	public void setReceta(RecetaDTO receta) {
		this.receta = receta;
	}
	
}
