package com.example.tpintegradorgrupo2.controller;

import com.example.tpintegradorgrupo2.entity.Incidente;
import com.example.tpintegradorgrupo2.entity.IncidenteDetalle;
import com.example.tpintegradorgrupo2.service.ClienteService;
import com.example.tpintegradorgrupo2.service.IncidenteDetalleService;
import com.example.tpintegradorgrupo2.service.IncidenteService;
import com.example.tpintegradorgrupo2.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
public class IncidenteRestController {
    @Autowired
    private IncidenteService incidenteService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private IncidenteDetalleService incidenteDetalleService;

    //Create
    @PostMapping("/incidentes")
    public Incidente saveIncidente(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        //ALIAS
        String alias = String.valueOf(body.get("alias"));

        //FECHA ESTIMADA
        LocalDate fechaEstimada = LocalDate.parse(body.get("fechaEstimada").toString());

        //FECHA DESDE
        LocalDate fechaDesde = LocalDate.parse(body.get("fechaDesde").toString());

        //FECHA HASTA
        LocalDate fechaHasta = LocalDate.parse(body.get("fechaHasta").toString());

        //RESUELTO
        Boolean resuelto = (Boolean) body.get("resuelto");

        //CONSIDERACIONES
        String consideraciones = String.valueOf(body.get("consideraciones"));

        //CLIENTE

        //TECNICO

        //INCIDENTES
        Set<Incidente> i = new HashSet<Incidente>();
        for (Integer id: (ArrayList<Integer>) body.get("incidentes")) {
            Incidente incidente = incidenteService.findIncidenteById(Long.valueOf(id));
            i.add(incidente);
        }


        //CREACION DEL OBJETO INCIDENTE
        Incidente incidente = new Incidente();
// continuar...

        //return IncidenteService.saveIncidente(incidente);
        return null;
    }

}
