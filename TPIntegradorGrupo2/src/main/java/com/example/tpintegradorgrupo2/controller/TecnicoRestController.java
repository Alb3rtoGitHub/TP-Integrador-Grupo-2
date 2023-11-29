package com.example.tpintegradorgrupo2.controller;

import com.example.tpintegradorgrupo2.entity.Tecnico;
import com.example.tpintegradorgrupo2.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TecnicoRestController {
    @Autowired
    private TecnicoService tecnicoService;

    //Create
    @PostMapping("/tecnicos")
    public Tecnico saveTecnico(@Validated @RequestBody Tecnico tecnico){
        return tecnicoService.saveTecnico(tecnico);
    }

    //Read
    @GetMapping("/tecnicos")
    public List<Tecnico> fetchTecnicoList(){
        return tecnicoService.getAllTecnicos();
    }

    //Update
    @PutMapping("/tecnicos/{idTecnico}")
    public Tecnico updateTecnico(@RequestBody Tecnico tecnico, @PathVariable("idTecnico") Long idTecnico){
        return tecnicoService.updateTecnico(tecnico, idTecnico);
    }

    //Delete
    @DeleteMapping("/tecnicos/{idTecnico}")
    public String deleteTecnicoById(@PathVariable("idTecnico") Long idTecnico){
        tecnicoService.deleteTecnicoById(idTecnico);
        return "Eliminado correctamente";
    }
}
