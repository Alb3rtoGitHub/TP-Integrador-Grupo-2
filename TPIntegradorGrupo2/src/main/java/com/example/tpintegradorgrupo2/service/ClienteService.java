package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    //Create
    Cliente saveCliente(Cliente cliente);

    //Read
    List<Cliente> getAllClientes();

    Cliente leerCliente();

    //Update
    Cliente updateCliente(Cliente cliente, Long idCliente);

    //Delete
    void deleteClienteById(Long idCliente);

    Cliente findClienteById(Long idCliente);
}
