package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Servicio;
import org.springframework.stereotype.Service;

@Service
public interface ServicioService {
    Servicio findServicioById(Long idServicio);
}
