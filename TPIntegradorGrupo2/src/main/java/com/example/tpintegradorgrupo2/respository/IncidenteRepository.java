package com.example.tpintegradorgrupo2.respository;

import com.example.tpintegradorgrupo2.entity.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {
}
