package com.example.hibernate;

import com.example.hibernate.dominio.temporal.*;
import com.example.hibernate.utils.BDUtils;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        Busqueda unaBusqueda = new Busqueda(
                "Obra Universitaria",
                Genero.MASCULINO,
                "Terror",
                new RangoEdad(18, 25),
                new ArrayList<>(),
                Remuneracion.NO_REMUNERADO,
                new Ubicacion(9.0, 12.0),
                LocalDateTime.now()
        );

        DetallePostulante detalleDeJuan = new DetallePostulante(
                "Nunca laburo", new ArrayList<>(), "unReel"
        );

        Postulante juan = new Postulante(detalleDeJuan, new ArrayList<>());

        Postulacion unaPostulacion = new Postulacion(detalleDeJuan, LocalDateTime.now());

        em.persist(unaBusqueda);
        em.persist(detalleDeJuan);
        em.persist(juan);
        em.persist(unaPostulacion);
        
        BDUtils.commit(em);
    }
    
}
