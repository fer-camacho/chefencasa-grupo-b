package com.grupo.demo.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="receta")
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = "titulo", nullable = false)
	protected String titulo;

	@Column(name = "descripcion", nullable = false)
	protected String descripcion;

	@Column(name = "tiempo_preparacion", nullable = false)
	protected int tiempo_preparacion;
	@Column(name = "autorId", nullable = false)
	private int autorId;
	@JoinColumn(name = "categoria", nullable = false)
	private String categoria;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> pasos;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> fotos;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> ingredientes;

	public Receta() {
	}

	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, int autorId) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.autorId = autorId;
	}

	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, int autorId, String categoria) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.autorId = autorId;
		this.categoria = categoria;
	}

	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, int autorId, String categoria, Set<String> pasos, Set<String> fotos, Set<String> ingredientes) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.autorId = autorId;
		this.categoria = categoria;
		this.pasos = pasos;
		this.fotos = fotos;
		this.ingredientes = ingredientes;
	}

	public Receta(int id, String titulo, String descripcion, int tiempo_preparacion, String categoria, int autorId, Set<String> pasos, Set<String> fotos, Set<String> ingredientes, Set<Integer> favoritos) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tiempo_preparacion = tiempo_preparacion;
		this.categoria = categoria;
		this.autorId = autorId;
		this.pasos = pasos;
		this.fotos = fotos;
		this.ingredientes = ingredientes;

	}

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

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set<String> getPasos() {
		return pasos;
	}

	public void setPasos(Set<String> pasos) {
		this.pasos = pasos;
	}

	public Set<String> getFotos() {
		return fotos;
	}

	public void setFotos(Set<String> fotos) {
		this.fotos = fotos;
	}

	public Set<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
}

