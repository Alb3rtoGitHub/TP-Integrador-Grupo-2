package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Tecnico;
import com.example.tpintegradorgrupo2.respository.TecnicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImp implements TecnicoService{

    @Autowired
    private TecnicoRespository tecnicoRespository;

    @Override
    public Tecnico saveTecnico(Tecnico tecnico) {
        return tecnicoRespository.save(tecnico);
    }

    @Override
    public List<Tecnico> getAllTecnicos() {
        return tecnicoRespository.findAll();
    }

    @Override
    public Tecnico updateTecnico(Tecnico tecnico, Long idTecnico) {
        Tecnico tecnicoDB = tecnicoRespository.getReferenceById(idTecnico);
        if (!tecnico.getNombre().trim().isEmpty()){
            tecnicoDB.setNombre(tecnico.getNombre());
        }
        if (!tecnico.getMail().trim().isEmpty()){
            tecnicoDB.setMail(tecnico.getMail());
        }
        if (!tecnico.getNumTel().trim().isEmpty()){
            tecnicoDB.setNumTel(tecnico.getNumTel());
        }
        return tecnicoRespository.save(tecnicoDB);
    }

    @Override
    public void deleteTecnicoById(Long idTecnico) {
        tecnicoRespository.deleteById(idTecnico);
    }
}
