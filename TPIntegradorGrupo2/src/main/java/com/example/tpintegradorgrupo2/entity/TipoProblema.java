package com.example.tpintegradorgrupo2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "tipoProblema")
public class TipoProblema {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTipoProblema;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(nullable = false)
    private int tiempoEstimadoDias; //en Dias

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY) //como quiero que se levanten los datos LAZY o EAGER(me lo deja en memoria)
    @JoinTable(
            name = "tipoProblemaEspecialidad",
            joinColumns = @JoinColumn(name = "idTipoProblema"),
            inverseJoinColumns = @JoinColumn(name = "idEspecialidad"))
    Set<Especialidad> especialidades;
}
