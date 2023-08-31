package com.grupo.demo.dtos;

import java.util.Set;


public class UsuarioDTO {
	
	private int id;
	private String nombre;
	private String email;
	private String usuario;
	private String password;
	private Set<SeguidoDTO> seguidos;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(int id, String nombre, String email, String usuario, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
	}
	
	public UsuarioDTO(int id, String nombre, String email, String usuario, String password, Set<SeguidoDTO> seguidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.seguidos = seguidos;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<SeguidoDTO> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(Set<SeguidoDTO> seguidos) {
		this.seguidos = seguidos;
	}
	
}
