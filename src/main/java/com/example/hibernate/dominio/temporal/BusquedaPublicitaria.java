package com.example.hibernate.dominio.temporal;

import java.time.LocalDateTime;
import java.util.List;

public class BusquedaPublicitaria extends Busqueda {
    private String tipoPublicidad;

    public BusquedaPublicitaria(String titulo, Genero generoPersona, String generoObra, RangoEdad rangoEdad, List<Requisito> requisitos, Remuneracion tipoRemuneracion, Ubicacion ubicacion, LocalDateTime fechaMaxima, String tipoPublicidad) {
        super(titulo, generoPersona, generoObra, rangoEdad, requisitos, tipoRemuneracion, ubicacion, fechaMaxima);
        this.tipoPublicidad = tipoPublicidad;
    }
}
