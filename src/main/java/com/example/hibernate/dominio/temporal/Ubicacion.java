package com.example.hibernate.dominio.temporal;


import javax.persistence.Embeddable;

@Embeddable
public class Ubicacion {
    private Double latitud;
    private Double longitud;

    public Ubicacion(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Ubicacion() {

    }
}
