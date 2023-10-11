package com.grupo.demo.dtos;

public class ComentariosDTO {

    private String usuario;
    private String receta;
    private String comentario;

    public ComentariosDTO(){}
    public ComentariosDTO(String usuario, String receta, String comentario) {
        this.usuario = usuario;
        this.receta = receta;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
