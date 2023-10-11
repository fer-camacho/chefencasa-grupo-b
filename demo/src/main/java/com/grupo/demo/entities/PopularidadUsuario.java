package com.grupo.demo.entities;


import javax.persistence.*;


@Entity
public class PopularidadUsuario {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected int id;

        @Column(name = "nombreUsuario", nullable = false)
        private String nombreUsuario;

        @Column(name = "puntaje", nullable = false)
        private int puntaje;

        public PopularidadUsuario(){}
        public PopularidadUsuario(String nombreUsuario, int puntaje) {
            this.nombreUsuario = nombreUsuario;
            this.puntaje = puntaje;
            //ver puntaje +-1
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

        public int getPuntaje() {
                return puntaje;
        }

        public void setPuntaje(int puntaje) {
                this.puntaje = puntaje;
        }
}
