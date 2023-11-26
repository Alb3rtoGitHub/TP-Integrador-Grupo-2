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
@Table(name = "tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTecnico;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(nullable = false, length = 255)
    private String mail;
    @Column(nullable = false, length = 20)
    private String numTel;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY) //como quiero que se levanten los datos LAZY o EAGER(me lo deja en memoria)
    @JoinTable(
            name = "tecnicoEspecialidad",
            joinColumns = @JoinColumn(name = "idTecnico"),
            inverseJoinColumns = @JoinColumn(name = "idEspecialidad"))
    private Set<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private Set<Incidente> incidentes;
}
