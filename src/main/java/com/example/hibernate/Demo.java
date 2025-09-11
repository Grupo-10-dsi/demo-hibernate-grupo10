package com.example.hibernate;

import com.example.hibernate.dominio.temporal.*;
import com.example.hibernate.utils.BDUtils;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        DetallePostulante detalleDeJuan = new DetallePostulante();
        em.persist(detalleDeJuan);

        detalleDeJuan.setReel("unReel");
        detalleDeJuan.setCurriculum("Nunca laburo");
        detalleDeJuan.setFotos(List.of("Foto1", "Foto2"));

        Postulacion unaPostulacion = new Postulacion(LocalDateTime.now());
        unaPostulacion.setDetallePostulante(detalleDeJuan);
        em.persist(unaPostulacion);

        Postulante juan = new Postulante();
        juan.setDetalle(detalleDeJuan);
        em.persist(juan);
        juan.setPostulacionesHechas(unaPostulacion);

        Requisito requisito = new Requisito();
        requisito.setDetalle("Ser divertido");
        em.persist(requisito);

        Busqueda unaBusqueda = new Busqueda(
                "Obra Universitaria",
                Genero.MASCULINO,
                "Terror",
                new RangoEdad(18, 25),
                new ArrayList<>(),
                Remuneracion.NO_REMUNERADO,
                new Ubicacion(9.0, 12.0),
                LocalDateTime.now(),
                new ArrayList<>()
        );

        em.persist(unaBusqueda);
        unaBusqueda.setPostulaciones(unaPostulacion);
        unaBusqueda.addRequisito(requisito);

        BDUtils.commit(em);
    }
    
}
