package com.example.tpintegradorgrupo2.service;

import org.springframework.stereotype.Service;
import com.example.tpintegradorgrupo2.entity.Tecnico;

import java.util.List;

@Service
public interface TecnicoService {
    //Create
    Tecnico saveTecnico(Tecnico tecnico);

    //Read
    List<Tecnico> getAllTecnicos();

    //Update
    Tecnico updateTecnico(Tecnico tecnico, Long idTecnico);

    //Delete
    void deleteTecnicoById(Long idTecnico);

    Tecnico findTecnicoById(Long idTecnico);
}
