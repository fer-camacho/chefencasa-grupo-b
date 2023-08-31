package com.grupo.demo.dtos;

public class Receta_usuarioDTO {
	private int id;
	private RecetaDTO receta;
	private UsuarioDTO usuario;
	private boolean favorito;
	
	public Receta_usuarioDTO() {
		super();
	}
	
	public Receta_usuarioDTO(int id, RecetaDTO receta, UsuarioDTO usuario, boolean favorito) {
		super();
		this.id = id;
		this.receta = receta;
		this.usuario = usuario;
		this.favorito = favorito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RecetaDTO getReceta() {
		return receta;
	}

	public void setReceta(RecetaDTO receta) {
		this.receta = receta;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

}
