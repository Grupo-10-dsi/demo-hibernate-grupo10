package com.example.hibernate.dominio.temporal;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity @Table(name="Postulante")
public class Postulante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany
    @JoinColumn(name= "postulante_id", referencedColumnName = "id")
    private List<Postulacion> postulacionesHechas;

    @OneToOne
    @JoinColumn(name = "detalle_id", referencedColumnName = "id")
    private DetallePostulante detalle;

    public Postulante() {}
}
