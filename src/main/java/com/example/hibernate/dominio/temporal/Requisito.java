package com.example.hibernate.dominio.temporal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Requisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String detalle;

    public void setDetalle(String unDetalle) {
        this.detalle = unDetalle;
    }

    public Requisito() {

    }


}
