package com.grupo.demo.entities;

import lombok.Data;

@Data
public class Comentarios {

    private String usuario;
    private String receta;
    private String comentario;

    public Comentarios(String usuario, String receta, String comentario) {
        this.usuario = usuario;
        this.receta = receta;
        this.comentario = comentario;
    }
}
