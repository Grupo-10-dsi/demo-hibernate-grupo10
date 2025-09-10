package com.example.hibernate;

import com.example.hibernate.dominio.temporal.Busqueda;
import com.example.hibernate.dominio.temporal.DetallePostulante;
import com.example.hibernate.dominio.temporal.Postulacion;
import com.example.hibernate.dominio.temporal.Postulante;
import com.example.hibernate.utils.BDUtils;
import javax.persistence.EntityManager;

public class Demo {

    public static void main(String[] args) {
        
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);


        em.persist(new Busqueda());
        em.persist(new Postulante());
        
        BDUtils.commit(em);
    }
    
}
