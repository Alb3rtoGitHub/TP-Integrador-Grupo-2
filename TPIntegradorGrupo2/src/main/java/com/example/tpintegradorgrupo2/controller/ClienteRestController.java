package com.example.tpintegradorgrupo2.controller;

import com.example.tpintegradorgrupo2.entity.Cliente;
import com.example.tpintegradorgrupo2.entity.Incidente;
import com.example.tpintegradorgrupo2.entity.Servicio;
import com.example.tpintegradorgrupo2.service.ClienteService;
import com.example.tpintegradorgrupo2.service.IncidenteService;
import com.example.tpintegradorgrupo2.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private IncidenteService incidenteService;

    @Autowired
    private ServicioService servicioService;

    //Create
    @PostMapping("/clientes")
    public Cliente saveCliente(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        //RAZON SOCIAL
        String razonSocial = String.valueOf(body.get("razonSocial"));

        //CUIT
        String cuit = String.valueOf(body.get("cuit"));

        //EMAIL
        String mail = String.valueOf(body.get("mail"));

        //SERVICIOS
        Set<Servicio> s = new HashSet<Servicio>();
        for (Integer id: (ArrayList<Integer>) body.get("servicios")) {
            Servicio servicio = servicioService.findServicioById(Long.valueOf(id));
            s.add(servicio);
        }

        //INCIDENTES
        Set<Incidente> i = new HashSet<Incidente>();
        for (Integer id: (ArrayList<Integer>) body.get("incidentes")) {
            Incidente incidente = incidenteService.findIncidenteById(Long.valueOf(id));
            i.add(incidente);
        }


        //CREACION DEL OBJETO CLIENTE
        Cliente c = new Cliente();
        c.setRazonSocial(razonSocial);
        c.setCuit(cuit);
        c.setMail(mail);
        c.setServicios(s);
        c.setIncidentes(i);

        return clienteService.saveCliente(c);
    }

    //Read
    @GetMapping("/clientes")
    public List<Cliente> fetchClienteList(){
        return clienteService.getAllClientes();
    }

    //Update
    @PutMapping("/clientes/{idCliente}")
    public Cliente updateCliente(@RequestBody Map<String, Object> body, @PathVariable("id") Long idCliente){
        //CREACION DEL OBJETO CLIENTE
        Cliente c = new Cliente();

        //LECTURA DE DATOS:
        //RAZON SOCIAL
        if(body.get("razonSocial") != null) {
            String razonSocial = String.valueOf(body.get("razonSocial"));
            c.setRazonSocial(razonSocial);
        }

        //CUIT
        if(body.get("cuit") != null) {
            String cuit = String.valueOf(body.get("cuit"));
            c.setCuit(cuit);
        }

        //MAIL
        if(body.get("mail") != null) {
            String mail = String.valueOf(body.get("mail"));
            c.setMail(mail);
        }

        //SERVICIOS
        Set<Servicio> s = new HashSet<Servicio>();
        if (body.get("servicios") != null) {
            for (Integer servicioId: (ArrayList<Integer>) body.get("servicios")) {
                Servicio servicio = servicioService.findServicioById(Long.valueOf(servicioId));
                s.add(servicio);
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

        c.setServicios(s);
        c.setIncidentes(i);

        return clienteService.updateCliente(c, idCliente);
    }

    //Delete
    @DeleteMapping("/clientes/{idCliente}")
    public String deleteClienteById(@PathVariable("idCliente") Long idCliente){
        clienteService.deleteClienteById(idCliente);
        return "Eliminado correctamente";
    }
}
