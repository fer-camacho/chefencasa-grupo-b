package com.grupo.demo.entities;

import java.util.Set;

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
@Table(name="Ingrediente")
public class Ingrediente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="descripcion", nullable = false)
	protected String descripcion;
	
	@ManyToMany
	@JoinTable(
	  name = "receta_x_ingrediente", 
	  joinColumns = @JoinColumn(name = "id_ingrediente"), 
	  inverseJoinColumns = @JoinColumn(name = "id_receta"))
	private Set<Receta> recetas;

	public Ingrediente() {
		super();
	}
	
	public Ingrediente(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Ingrediente(int id, String descripcion, Set<Receta> recetas) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.recetas = recetas;
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

	public Set<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(Set<Receta> recetas) {
		this.recetas = recetas;
	}

}
