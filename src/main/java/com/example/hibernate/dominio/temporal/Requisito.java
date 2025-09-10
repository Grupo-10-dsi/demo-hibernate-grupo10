package com.example.hibernate.dominio.temporal;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Requisito {

    @Id
    private UUID id;


    private String detalle;


}
