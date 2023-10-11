package com.grupo.demo.dtos;

public class PopularidadUsuarioDTO {
    private String nombreUsuario;
    private int puntaje;


    public PopularidadUsuarioDTO(){}
    public PopularidadUsuarioDTO(String nombreUsuario, int puntaje) {
        this.nombreUsuario = nombreUsuario;
        this.puntaje = puntaje;
        //ver puntaje +-1
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}
