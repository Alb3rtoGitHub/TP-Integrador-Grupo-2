package com.example.tpintegradorgrupo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEspecialidad;
    @Column(nullable = false, length = 255)
    private String nombre;

    @ManyToMany(mappedBy = "especialidades")
    Set<Tecnico> tecnicos;

    @ManyToMany(mappedBy = "especialidades")
    Set<TipoProblema> tipoProblemas;
}
