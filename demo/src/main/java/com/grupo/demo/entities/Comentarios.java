package com.grupo.demo.entities;

import javax.persistence.*;

@Entity

public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "nombreUsuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "id_receta", nullable = false)
    private String idReceta;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    public Comentarios(){}
    public Comentarios(String usuario, String receta, String comentario) {
        this.nombreUsuario = usuario;
        this.idReceta = receta;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
