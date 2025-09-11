package com.example.hibernate.dominio.temporal;

import javax.persistence.*;

import com.example.hibernate.dominio.temporal.Reel;

import java.util.List;
import java.util.UUID;

@Entity @Table(name = "Detalle_Postulante")
public class DetallePostulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String curriculum;

    @ElementCollection
    @CollectionTable(name="Detalle_fotos", joinColumns = @JoinColumn(name="detalle_postulante_id"))
    @Column(name = "fotos")
    private List<String> fotos;

    private String reel;


    public DetallePostulante(String curriculum, List<String> fotos, String reel) {
        this.curriculum = curriculum;
        this.fotos = fotos;
        this.reel = reel;
    }

    public DetallePostulante() {

    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public void setReel(String reel) {
        this.reel = reel;
    }
}
