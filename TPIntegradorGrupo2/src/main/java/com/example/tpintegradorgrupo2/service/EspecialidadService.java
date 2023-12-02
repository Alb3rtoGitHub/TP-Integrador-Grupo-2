package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Especialidad;
import org.springframework.stereotype.Service;

@Service
public interface EspecialidadService {
    Especialidad findEspecialidadById(Long idEspecialidad);
}
