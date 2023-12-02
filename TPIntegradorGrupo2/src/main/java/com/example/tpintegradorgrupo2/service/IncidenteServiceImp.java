package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Incidente;
import com.example.tpintegradorgrupo2.entity.Servicio;
import com.example.tpintegradorgrupo2.respository.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteServiceImp implements IncidenteService {

    @Autowired
    private IncidenteRepository incidenteRepository;

    @Override
    public Incidente saveIncidente(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    @Override
    public List<Incidente> getAllIncidentes() {
        return incidenteRepository.findAll();
    }

    @Override
    public Incidente updateIncidente(Incidente incidente, Long idIncidente) {
        Incidente incidenteDB = incidenteRepository.findById(idIncidente).get();
        if (!incidente.getAlias().trim().isEmpty()){
            incidenteDB.setAlias(incidente.getAlias());
        }
        if (incidente.getFechaEstimada() != null){
            incidenteDB.setFechaEstimada(incidente.getFechaEstimada());
        }
        if (incidente.getFechaDesde() != null){
            incidenteDB.setFechaDesde(incidente.getFechaDesde());
        }
        if (incidente.getFechaHasta() != null){
            incidenteDB.setFechaHasta(incidente.getFechaHasta());
        }
        if (!incidente.isResuelto()){
            incidenteDB.setResuelto(incidente.isResuelto());
        }
        if (!incidente.getConsideraciones().trim().isEmpty()){
            incidenteDB.setConsideraciones(incidente.getConsideraciones());
        }
        return incidenteRepository.save(incidenteDB);
    }

    @Override
    public void deleteIncidenteById(Long idIncidente) {
        incidenteRepository.deleteById(idIncidente);
    }

    @Override
    public Incidente findIncidenteById(Long idIncidente) {
        return incidenteRepository.getReferenceById(idIncidente);
    }
}
