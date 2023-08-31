package com.grupo.demo.dtos;

public class SeguidoDTO {
	private int id;
	private UsuarioDTO usuarioDTO;
	
	public SeguidoDTO() {
		super();
	}
	
	public SeguidoDTO(int id, UsuarioDTO usuarioDTO) {
		super();
		this.id = id;
		this.usuarioDTO = usuarioDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
}
