package com.example.tpintegradorgrupo2.controller;

import com.example.tpintegradorgrupo2.entity.Cliente;
import com.example.tpintegradorgrupo2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;

    //Create
    @PostMapping("/clientes")
    public Cliente saveCliente(@Validated @RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    //Read
    @GetMapping("/clientes")
    public List<Cliente> fetchClienteList(){
        return clienteService.getAllClientes();
    }

    //Update
    @PutMapping("/clientes/{idCliente}")
    public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable("idCliente") Long idCliente){
        return clienteService.updateCliente(cliente, idCliente);
    }

    //Delete
    @DeleteMapping("/clientes/{idCliente}")
    public String deleteClienteById(@PathVariable("idCliente") Long idCliente){
        clienteService.deleteClienteById(idCliente);
        return "Eliminado correctamente";
    }
}
