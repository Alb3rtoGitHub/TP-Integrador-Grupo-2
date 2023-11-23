package com.example.tpintegradorgrupo2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "incidenteDetalle")
public class IncidenteDetalle {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idIncidenteDetalle;
    @Column(nullable = false, length = 255)
    private String descripcion;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idIncidente", nullable=false)
    private Incidente incidente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idServicio", nullable=false)
    private Servicio servicio;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idTipoProblema", nullable=false)
    private TipoProblema tipoProblema;


    // COMO HAGO CON ESTO?  private Incidente incidente;
    // COMO HAGO CON ESTO?  private Servicio servicio;
    // COMO HAGO CON ESTO ? private TipoProblema tipoProblema;
}
