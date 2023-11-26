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
//@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;
    @Column(nullable = false, length = 255) //es necesario poner el nombre de columna? No es necesario
    private String razonSocial;
    @Column(nullable = false, length = 20)
    private String cuit;
    @Column(nullable = false, length = 255)
    private String mail;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY) //como quiero que se levanten los datos LAZY o EAGER(me lo deja en memoria)
    @JoinTable(
            name = "clienteServicio",
            joinColumns = @JoinColumn(name = "idCliente"),
            inverseJoinColumns = @JoinColumn(name = "idServicio"))
    private Set<Servicio> servicios;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Incidente> incidentes;
}
