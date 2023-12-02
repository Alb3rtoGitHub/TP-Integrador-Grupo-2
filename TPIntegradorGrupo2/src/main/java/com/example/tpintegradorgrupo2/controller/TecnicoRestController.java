package com.example.tpintegradorgrupo2.controller;

import com.example.tpintegradorgrupo2.entity.*;
import com.example.tpintegradorgrupo2.service.EspecialidadService;
import com.example.tpintegradorgrupo2.service.IncidenteService;
import com.example.tpintegradorgrupo2.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TecnicoRestController {

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private IncidenteService incidenteService;

    //Create
    @PostMapping("/tecnicos")
    public Tecnico saveTecnico(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        //NOMBRE
        String nombre = String.valueOf(body.get("nombre"));

        //MAIL
        String mail = String.valueOf(body.get("mail"));

        //NUMERO TELEFONO
        String numTel = String.valueOf(body.get("numTel"));

        //ESPECIALIDAD
        Set<Especialidad> e = new HashSet<Especialidad>();
        for (Integer id: (ArrayList<Integer>) body.get("especialidades")) {
            Especialidad especialidad = especialidadService.findEspecialidadById(Long.valueOf(id));
            e.add(especialidad);
        }

        //INCIDENTES
        Set<Incidente> i = new HashSet<Incidente>();
        for (Integer id: (ArrayList<Integer>) body.get("incidentes")) {
            Incidente incidente = incidenteService.findIncidenteById(Long.valueOf(id));
            i.add(incidente);
        }


        //CREACION DEL OBJETO TECNICO
        Tecnico t = new Tecnico();
        t.setNombre(nombre);
        t.setMail(mail);
        t.setNumTel(numTel);
        t.setEspecialidades(e);
        t.setIncidentes(i);

        return tecnicoService.saveTecnico(t);
    }

    //Read
    @GetMapping("/tecnicos")
    public List<Tecnico> fetchTecnicoList(){
        return tecnicoService.getAllTecnicos();
    }

    //Update
    @PutMapping("/tecnicos/{idTecnico}")
    public Tecnico updateTecnico(@RequestBody Map<String, Object> body, @PathVariable("idTecnico") Long idTecnico){

        //CREACION DEL OBJETO TECNICO
        Tecnico t = new Tecnico();

        //LECTURA DE DATOS:
        //NOMBRE
        if(body.get("nombre") != null) {
            String nombre = String.valueOf(body.get("nombre"));
            t.setNombre(nombre);
        }

        //MAIL
        if(body.get("mail") != null) {
            String mail = String.valueOf(body.get("mail"));
            t.setMail(mail);
        }

        //NUMERO TELEFONO
        if(body.get("numTel") != null) {
            String numTel = String.valueOf(body.get("numTel"));
            t.setNumTel(numTel);
        }


        //ESPECIALIDAD
        Set<Especialidad> e = new HashSet<Especialidad>();
        if (body.get("especialidades") != null) {
            for (Integer especialidadId: (ArrayList<Integer>) body.get("especialidades")) {
                Especialidad especialidad = especialidadService.findEspecialidadById(Long.valueOf(especialidadId));
                e.add(especialidad);
            }
        }

        //INCIDENTES
        Set<Incidente> i = new HashSet<Incidente>();
        if (body.get("incidentes") != null) {
            for (Integer incidenteId: (ArrayList<Integer>) body.get("incidentes")) {
                Incidente incidente = incidenteService.findIncidenteById(Long.valueOf(incidenteId));
                i.add(incidente);
            }
        }

        t.setEspecialidades(e);
        t.setIncidentes(i);

        return tecnicoService.updateTecnico(t, idTecnico);
    }

    //Delete
    @DeleteMapping("/tecnicos/{idTecnico}")
    public String deleteTecnicoById(@PathVariable("idTecnico") Long idTecnico){
        tecnicoService.deleteTecnicoById(idTecnico);
        return "Eliminado correctamente";
    }
}
