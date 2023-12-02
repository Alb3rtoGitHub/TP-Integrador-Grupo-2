package com.example.tpintegradorgrupo2.respository;

import com.example.tpintegradorgrupo2.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRespository extends JpaRepository <Servicio, Long>{
}
