package com.grupo.demo.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UsuarioDTO {
	
	private int id;
	private String nombre;
	private String email;
	private String usuario;
	private String password;
	private Set<Integer> usuariosSeguidos;
	private Set<Integer> recetasFavoritas;

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
		Set<Integer> usuariosSeguidos = new HashSet<Integer>();
		Set<Integer> recetasFavoritas = new HashSet<Integer>();
	}
	
	public UsuarioDTO(int id, String nombre, String email, String usuario, String password, Set<Integer> usuariosSeguidos, Set<Integer> recetasFavoritas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.usuariosSeguidos = usuariosSeguidos;
		this.recetasFavoritas = recetasFavoritas;
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

	public Set<Integer> getUsuariosSeguidos() {
		return usuariosSeguidos;
	}

	public void setUsuariosSeguidos(Set<Integer> usuariosSeguidos) {
		this.usuariosSeguidos = usuariosSeguidos;
	}

	public Set<Integer> getRecetasFavoritas() {
		return recetasFavoritas;
	}

	public void setRecetasFavoritas(Set<Integer> recetasFavoritas) {
		this.recetasFavoritas = recetasFavoritas;
	}
}
