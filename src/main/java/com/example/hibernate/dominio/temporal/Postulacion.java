package com.example.hibernate.dominio.temporal;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity @Table(name = "Postulacion")
public class Postulacion {

    @Id @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime fechaCarga;

    @Enumerated(EnumType.STRING)
    private EstadoPostulacion estado;

    @OneToOne
    @JoinColumn(name = "detalle_postulante_id", referencedColumnName = "id")
    private DetallePostulante detallePostulante;

    public Postulacion(LocalDateTime fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Postulacion() {

    }

    public void setDetallePostulante(DetallePostulante detallePostulante) {
        this.detallePostulante = detallePostulante;
    }
}
