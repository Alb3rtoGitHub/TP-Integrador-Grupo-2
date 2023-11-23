package com.example.tpintegradorgrupo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int tiempoEstimado; //en Dias

}
