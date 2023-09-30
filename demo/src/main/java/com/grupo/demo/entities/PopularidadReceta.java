package com.grupo.demo.entities;

import lombok.Data;

@Data
public class PopularidadReceta {

    private int id_receta;
    private int puntaje;

    public PopularidadReceta(int id_receta, int puntaje) {
        this.id_receta = id_receta;
        this.puntaje = puntaje;
    }
}
