package com.example.hibernate.dominio.temporal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity @Table(name="Postulante")
public class Postulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    @JoinColumn(name= "postulante_id", referencedColumnName = "id")
    private List<Postulacion> postulacionesHechas =  new ArrayList<>();

    @OneToOne()
    @JoinColumn(name = "detalle_id", referencedColumnName = "id")
    private DetallePostulante detalle;

    public Postulante() {}


    public void setPostulacionesHechas(Postulacion unaPostulacion) {
        this.postulacionesHechas.add(unaPostulacion);
    }

    public void setDetalle(DetallePostulante unDetalle) {
        this.detalle = unDetalle;
    }
}
