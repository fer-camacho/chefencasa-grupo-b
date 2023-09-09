package com.grupo.demo.entities;

import com.grupo.demo.dtos.SeguidoDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="nombre", nullable = false)
	protected String nombre;
	
	@Column(name="email", nullable = false)
	protected String email;
	
	@Column(name="usuario", nullable = false)
	protected String usuario;
	
	@Column(name="password", nullable = false)
	protected String password;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Integer> usuariosSeguidos;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Integer> recetasFavoritas;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String email, String usuario, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.usuariosSeguidos = new HashSet<Integer>();
		this.recetasFavoritas = new HashSet<Integer>();
	}
	
	public Usuario(int id, String nombre, String email, String usuario, String password, Set<Integer> usuariosSeguidos, Set<Integer> recetasFavoritas) {
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
