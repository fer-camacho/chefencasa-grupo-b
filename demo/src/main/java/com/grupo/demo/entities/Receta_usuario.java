package com.grupo.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="receta_x_usuario")
public class Receta_usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_receta", nullable=false)
	private Receta receta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(name="favorito", nullable=true)
	protected boolean favorito;

	public Receta_usuario() {
		super();
	}

	public Receta_usuario(int id, Receta receta, Usuario usuario) {
		super();
		this.id = id;
		this.receta = receta;
		this.usuario = usuario;
	}

	public Receta_usuario(int id, Receta receta, Usuario usuario, boolean favorito) {
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

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
}
