package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.IncidenteDetalle;
import com.example.tpintegradorgrupo2.respository.IncidenteDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteDetalleServiceImp implements IncidenteDetalleService{

    @Autowired
    private IncidenteDetalleRepository incidenteDetalleRepository;

    @Override
    public IncidenteDetalle saveIncidenteDetalle(IncidenteDetalle incidenteDetalle) {
        return null;
    }

    @Override
    public List<IncidenteDetalle> getAllIncidenteDetalles() {
        return null;
    }

    @Override
    public IncidenteDetalle updateIncidenteDetalle(IncidenteDetalle incidenteDetalle, Long idIncidenteDetalle) {
        return null;
    }

    @Override
    public void deleteIncidenteDetalleById(Long idIncidenteDetalle) {

    }

    @Override
    public IncidenteDetalle findIncidenteDetalleById(Long idIncidenteDetalle) {
        return null;
    }
}
