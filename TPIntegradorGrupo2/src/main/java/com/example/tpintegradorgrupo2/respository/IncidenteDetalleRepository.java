package com.example.tpintegradorgrupo2.respository;

import com.example.tpintegradorgrupo2.entity.IncidenteDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenteDetalleRepository extends JpaRepository <IncidenteDetalle, Long> {
}
