package com.example.hibernate.dominio.temporal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RangoEdad {

    @Column
    private int edadMinima;

    @Column
    private int edadMaxima;

}
