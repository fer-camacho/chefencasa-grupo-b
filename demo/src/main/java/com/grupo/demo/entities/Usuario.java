package com.grupo.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usuario")
	private Set<Seguido> seguidos;
/*
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usuario")
	private Set<Receta> recetas;*/
	
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
	}
	
	public Usuario(int id, String nombre, String email, String usuario, String password, Set<Seguido> seguidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.seguidos = seguidos;
	}
	/*
	public Usuario(int id, String nombre, String email, String usuario, String password, Set<Seguido> seguidos,
			Set<Receta> recetas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.seguidos = seguidos;
		this.recetas = recetas;
	}*/

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

	public Set<Seguido> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(Set<Seguido> seguidos) {
		this.seguidos = seguidos;
	}
/*
	public Set<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(Set<Receta> recetas) {
		this.recetas = recetas;
	}*/
	
}
