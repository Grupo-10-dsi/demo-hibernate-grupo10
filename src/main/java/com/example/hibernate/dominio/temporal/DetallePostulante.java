package com.example.hibernate.dominio.temporal;

import javax.persistence.*;

import com.example.hibernate.dominio.temporal.Reel;

import java.util.List;

@Entity @Table(name = "Detalle_Postulante")
public class DetallePostulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String curriculum;

    @ElementCollection
    @CollectionTable(name="Detalle_fotos", joinColumns = @JoinColumn(name="detalle_postulante_id"))
    @Column(name = "foto")
    private List<String> fotos;

    private String reel;


    public DetallePostulante(String curriculum, List<String> fotos, String reel) {
        this.curriculum = curriculum;
        this.fotos = fotos;
        this.reel = reel;
    }

    public DetallePostulante() {

    }
}
