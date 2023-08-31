package com.grupo.demo.dtos;

public class FotoDTO {
	private int id;
	private String foto;
	private RecetaDTO receta;
	
	public FotoDTO() {
		super();
	}
	
	public FotoDTO(int id, String foto) {
		super();
		this.id = id;
		this.foto = foto;
	}


	public FotoDTO(int id, String foto, RecetaDTO receta) {
		super();
		this.id = id;
		this.foto = foto;
		this.receta = receta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public RecetaDTO getReceta() {
		return receta;
	}

	public void setReceta(RecetaDTO receta) {
		this.receta = receta;
	}
	
}
