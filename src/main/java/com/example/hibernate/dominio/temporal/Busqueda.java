package com.example.hibernate.dominio.temporal;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Entity @Table(name = "Busqueda")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Busqueda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private Genero generoPersona;

    private String generoObra;

    @Embedded
    private RangoEdad rangoEdad;

    @ManyToMany
    @JoinTable(name = "Requisito_Busqueda",
                joinColumns = @JoinColumn(name = "busqueda_id",
                referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "requisitos_id", referencedColumnName = "id"))
    private List<Requisito> requisitos;

    @Enumerated(EnumType.STRING)
    private Remuneracion tipoRemuneracion;

    @Embedded
    private Ubicacion ubicacion;

    @OneToMany
    @JoinColumn(name= "busqueda_id", referencedColumnName = "id")
    private List<Postulacion> postulaciones;

    private LocalDateTime fechaMaxima;

    @Enumerated(EnumType.STRING)
    private EstadoBusqueda estado;


    public Busqueda(String titulo, Genero generoPersona, String generoObra, RangoEdad rangoEdad, List<Requisito> requisitos, Remuneracion tipoRemuneracion, Ubicacion ubicacion, LocalDateTime fechaMaxima, List<Postulacion> postulaciones) {
        this.titulo = titulo;
        this.generoPersona = generoPersona;
        this.generoObra = generoObra;
        this.rangoEdad = rangoEdad;
        this.requisitos = requisitos;
        this.tipoRemuneracion = tipoRemuneracion;
        this.ubicacion = ubicacion;
        this.fechaMaxima = fechaMaxima;
        this.postulaciones = postulaciones;
    }

    public Busqueda() {

    }


    public void setPostulaciones(Postulacion unaPostulacion) {
        this.postulaciones.add(unaPostulacion);
    }

    public void addRequisito(Requisito unRequisito) {
        this.requisitos.add(unRequisito);
    }
}
