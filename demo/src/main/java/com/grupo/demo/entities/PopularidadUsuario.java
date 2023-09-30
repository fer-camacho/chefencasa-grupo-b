package com.grupo.demo.entities;

import lombok.Data;
@Data
public class PopularidadUsuario {
    private String nombreUsuario;
    private int puntaje;

    public PopularidadUsuario(String nombreUsuario, int puntaje) {
        this.nombreUsuario = nombreUsuario;
        this.puntaje = puntaje;
        //ver puntaje +-1
    }
}
