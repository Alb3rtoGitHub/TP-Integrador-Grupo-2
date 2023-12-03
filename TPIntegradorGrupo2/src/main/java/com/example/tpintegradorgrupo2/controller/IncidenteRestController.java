package com.example.tpintegradorgrupo2.controller;

import com.example.tpintegradorgrupo2.entity.Cliente;
import com.example.tpintegradorgrupo2.entity.Incidente;
import com.example.tpintegradorgrupo2.entity.IncidenteDetalle;
import com.example.tpintegradorgrupo2.entity.Tecnico;
import com.example.tpintegradorgrupo2.service.ClienteService;
import com.example.tpintegradorgrupo2.service.IncidenteDetalleService;
import com.example.tpintegradorgrupo2.service.IncidenteService;
import com.example.tpintegradorgrupo2.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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
        Long idCliente = (Long) body.get("idCliente");
        Cliente c = clienteService.findClienteById(idCliente);

        //TECNICO
        Long idTecnico = (Long) body.get("idTecnico");
        Tecnico t = tecnicoService.findTecnicoById(idTecnico);

        //INCIDENTE_DETALLE
        Set<IncidenteDetalle> incidenteDetalles = new HashSet<IncidenteDetalle>();
        for (Integer id: (ArrayList<Integer>) body.get("incidentes_detalles")) {
            IncidenteDetalle incidenteDetalle = incidenteDetalleService.findIncidenteDetalleById(Long.valueOf(id));
            incidenteDetalles.add(incidenteDetalle);
        }

        //CREACION DEL OBJETO INCIDENTE
        Incidente incidente = new Incidente();
        incidente.setAlias(alias);
        incidente.setFechaEstimada(fechaEstimada);
        incidente.setFechaDesde(fechaDesde);
        incidente.setFechaHasta(fechaHasta);
        incidente.setResuelto(resuelto);
        incidente.setConsideraciones(consideraciones);
        incidente.setCliente(c);
        incidente.setTecnico(t);
        incidente.setIncidenteDetalles(incidenteDetalles);

        return incidenteService.saveIncidente(incidente);
    }

    // Read
    @GetMapping("/incidentes")
    public List<Incidente> fetchIncidenteList(){
        return incidenteService.getAllIncidentes();
    }

    // Update
    @PutMapping("/incidentes/{id}")
    public Incidente updateIncidente(@Validated @RequestBody Map<String, Object> body, @PathVariable("id") Long id){
        //CREACION DEL OBJETO INCIDENTE
        Incidente incidente = new Incidente();

        //LECTURA DE DATOS
        //ALIAS
        if(body.get("alias") != null) {
            String alias = String.valueOf(body.get("alias"));
            incidente.setAlias(alias);
        }

        //FECHAESTIMADA
        if (body.get("fechaEstimada") != null) {
            LocalDate fechaEstimada = LocalDate.parse(body.get("fechaEstimada").toString());
            incidente.setFechaEstimada(fechaEstimada);
        }

        //FECHADESDE
        if (body.get("fechaDesde") != null) {
            LocalDate fechaDesde = LocalDate.parse(body.get("fechaDesde").toString());
            incidente.setFechaDesde(fechaDesde);
        }

        //FECHAHASTA
        if (body.get("fechaHasta") != null) {
            LocalDate fechaHasta = LocalDate.parse(body.get("fechaHasta").toString());
            incidente.setFechaHasta(fechaHasta);
        }

        //RESUELTO
        if (body.get("resuelto") != null) {
            Boolean resuelto = (Boolean) body.get("resuelto");
            incidente.setResuelto(resuelto);
        }

        //CONSIDERACIONES
        if (body.get("consideraciones") != null) {
            String consideraciones = String.valueOf(body.get("consideraciones"));
            incidente.setConsideraciones(consideraciones);
        }

        //CLIENTE
        if (body.get("idCliente") != null) {
            Long idCliente = (Long) body.get("idCliente");
            Cliente c = clienteService.findClienteById(idCliente);
            incidente.setCliente(c);
        }

        //TECNICO
        if (body.get("idTecnico") != null) {
            Long idTecnico = (Long) body.get("idTecnico");
            Tecnico t = tecnicoService.findTecnicoById(idTecnico);
            incidente.setTecnico(t);
        }

        //INCIDENTEDETALLE
        if(body.get("incidenteDetalles") != null) {
            Set<IncidenteDetalle> incidenteDetalles = new HashSet<>();
            for (Integer incidenteDetalleId: (ArrayList<Integer>) body.get("incidenteDetalles")){
                IncidenteDetalle incidenteDetalle = incidenteDetalleService.findIncidenteDetalleById(Long.valueOf(incidenteDetalleId));
                incidenteDetalles.add(incidenteDetalle);
            }
            incidente.setIncidenteDetalles(incidenteDetalles);
        }

        return incidenteService.updateIncidente(incidente, id);
    }


    // Delete
    @DeleteMapping("/incidentes/{id}")
    public String deleteIncidenteById(@PathVariable("id") Long id){
        incidenteService.deleteIncidenteById(id);
        return "Eliminado correctamente";
    }
}
