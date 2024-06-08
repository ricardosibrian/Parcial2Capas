package com.example.prepractica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "citaMedica_table")
public class CitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID citaMedicaId;

    private Date fechaHoraInicio;
    private Date fechaHoraFin;

    private String descripcion;

    @OneToMany(mappedBy = "citaMedica")
    private List<Prescripcion> prescripciones;

}
