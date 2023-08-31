package com.grupo.demo.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="foto")
public class Foto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="foto", nullable = true)
	protected String foto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_receta", nullable=false)
	private Receta receta;
	
	public Foto() {
		super();
	}

	public Foto(int id, String foto) {
		super();
		this.id = id;
		this.foto = foto;
	}

	public Foto(int id, String foto, Receta receta) {
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

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
}
