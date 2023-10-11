package com.grupo.demo.dtos;

public class PopularidadRecetaDTO {

    private int id_receta;
    private int puntaje;

    public PopularidadRecetaDTO(){}

    public PopularidadRecetaDTO(int id_receta, int puntaje) {
        this.id_receta = id_receta;
        this.puntaje = puntaje;
    }
    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}
