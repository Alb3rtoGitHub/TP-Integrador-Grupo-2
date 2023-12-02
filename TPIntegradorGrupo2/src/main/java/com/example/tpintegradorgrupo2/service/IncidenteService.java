package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Incidente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidenteService {
    //Create
    Incidente saveIncidente(Incidente incidente);

    //Read
    List<Incidente> getAllIncidentes();

    //Update
    Incidente updateIncidente(Incidente incidente, Long idIncidente);

    //Delete
    void deleteIncidenteById(Long idIncidente);

    Incidente findIncidenteById(Long aLong);
}
