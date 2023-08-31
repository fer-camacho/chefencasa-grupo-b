package com.grupo.demo.entities;

import javax.persistence.Column;
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
@Table(name="paso")
public class Paso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="descripcion", nullable = false)
	protected String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_receta", nullable=false)
	private Receta receta;
	
	public Paso() {
		super();
	}
	
	public Paso(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Paso(int id, String descripcion, Receta receta) {
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

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

}
