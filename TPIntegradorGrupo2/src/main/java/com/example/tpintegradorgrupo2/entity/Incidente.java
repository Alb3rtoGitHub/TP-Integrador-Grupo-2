package com.example.tpintegradorgrupo2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "incidente")
public class Incidente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idIncidente;
    @Column(nullable = false, length = 255)
    private String alias;
    @Column(nullable = false)
    private LocalDate fechaEstimada;
    @Column(nullable = false)
    private LocalDate fechaDesde;
    @Column(nullable = true)
    private LocalDate fechaHasta;
    @Column(nullable = false, columnDefinition = "boolean default false" ) //valor por defecto desde SQL
    private boolean resuelto; // o lo inicializo > private boolean resuelto = false;
    @Column(nullable = true, length = 1000) //para tener en cuenta el tipo TEXT de la DER
    private String consideraciones;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //se usa cuando se use el FetchType.LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable=false)
    private Cliente cliente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idTecnico", nullable=false)
    private Tecnico tecnico;

    @OneToMany(mappedBy = "incidente", cascade = CascadeType.ALL)
    private Set<IncidenteDetalle> detalles;
}
