package com.grupo.demo.entities;

import lombok.Data;

@Data
public class Novedades {
    private String nombre;
    private String titulo;
    private String foto;

    public Novedades(String nombre, String titulo, String foto) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.foto = foto;
    }
}
