package com.grupo.demo.entities;

import javax.persistence.*;


@Entity
public class PopularidadReceta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "id_receta", nullable = false)
    private int id_receta;

    @Column(name = "puntaje", nullable = false)
    private int puntaje;

    public PopularidadReceta(){}
    public PopularidadReceta(int id_receta, int puntaje) {
        this.id_receta = id_receta;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
