package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.IncidenteDetalle;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IncidenteDetalleService { /////POR AHI NO HACEN FALTA TODOS ESTOS METODOS
    //Create
    IncidenteDetalle saveIncidenteDetalle (IncidenteDetalle incidenteDetalle);

    //Read
    List<IncidenteDetalle> getAllIncidenteDetalles();

    //Update
    IncidenteDetalle updateIncidenteDetalle(IncidenteDetalle incidenteDetalle, Long idIncidenteDetalle);

    //Delete
    void deleteIncidenteDetalleById(Long idIncidenteDetalle);

    IncidenteDetalle findIncidenteDetalleById(Long idIncidenteDetalle);
}
