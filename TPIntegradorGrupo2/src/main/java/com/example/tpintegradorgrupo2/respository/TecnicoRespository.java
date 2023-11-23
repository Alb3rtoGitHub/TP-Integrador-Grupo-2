package com.example.tpintegradorgrupo2.respository;

import com.example.tpintegradorgrupo2.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRespository extends JpaRepository<Tecnico, Long> {
}
