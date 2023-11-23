package com.example.tpintegradorgrupo2.respository;

import com.example.tpintegradorgrupo2.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
