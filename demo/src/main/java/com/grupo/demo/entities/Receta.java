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
@Table(name="receta")
public class Receta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="titulo", nullable = false)
	protected String titulo;
	
	@Column(name="descripcion", nullable = false)
	protected String descripcion;
	
	@Column(name="tiempo_preparacion", nullable = false)
	protected int tiempo_preparacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_categoria", nullable=false)
	private Categoria categoria;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="receta")
	private Set<Paso> pasos;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="receta")
	private Set<Foto> fotos;
	
	@ManyToMany
	@JoinTable(
	  name = "receta_x_ingrediente", 
	  joinColumns = @JoinColumn(name = "id_receta"), 
	  inverseJoinColumns = @JoinColumn(name = "id_ingrediente"))
	private Set<Ingrediente> ingredientes;
	
	/*@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="receta")
	private Set<Usuario> usuarios;
*/
	public Receta() {
		super();
	}

	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
	}

	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.categoria = categoria;
	}
	
	

	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, Categoria categoria,
			Set<Paso> pasos, Set<Foto> fotos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.categoria = categoria;
		this.pasos = pasos;
		this.fotos = fotos;
	}
	
	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, Categoria categoria,
			Set<Paso> pasos, Set<Foto> fotos, Set<Ingrediente> ingredientes) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.categoria = categoria;
		this.pasos = pasos;
		this.fotos = fotos;
		this.ingredientes = ingredientes;
	}

/*
	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, Categoria categoria,
			Set<Paso> pasos, Set<Foto> fotos, Set<Ingrediente> ingredientes, Set<Usuario> usuarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.categoria = categoria;
		this.pasos = pasos;
		this.fotos = fotos;
		this.ingredientes = ingredientes;
		this.usuarios = usuarios;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTiempo_preparacion() {
		return tiempo_preparacion;
	}

	public void setTiempo_preparacion(int tiempo_preparacion) {
		this.tiempo_preparacion = tiempo_preparacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Paso> getPasos() {
		return pasos;
	}

	public void setPasos(Set<Paso> pasos) {
		this.pasos = pasos;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
/*
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
*/
	public Set<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

	
}
