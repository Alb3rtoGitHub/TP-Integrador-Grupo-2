package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Servicio;
import com.example.tpintegradorgrupo2.respository.ServicioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImp implements ServicioService{
    @Autowired
    private ServicioRespository servicioRespository;
    @Override
    public Servicio findServicioById(Long idServicio) {
        return servicioRespository.getReferenceById(idServicio);
    }
}
