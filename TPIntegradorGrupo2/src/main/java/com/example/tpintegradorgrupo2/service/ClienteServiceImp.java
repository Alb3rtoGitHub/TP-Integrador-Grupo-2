package com.example.tpintegradorgrupo2.service;

import com.example.tpintegradorgrupo2.entity.Cliente;
import com.example.tpintegradorgrupo2.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
        System.out.println(clienteRepository.findAll());
        return clienteRepository.findAll();
    }

    @Override
    public Cliente updateCliente(Cliente cliente, Long idCliente) {
        Cliente clienteDB = clienteRepository.getReferenceById(idCliente);
        if (!cliente.getRazonSocial().trim().isEmpty()){
            clienteDB.setRazonSocial(cliente.getRazonSocial());
        }
        if (!cliente.getCuit().trim().isEmpty()){
            clienteDB.setCuit(cliente.getCuit());
        }
        if (!cliente.getMail().trim().isEmpty()){
            clienteDB.setMail(cliente.getMail());
        }
        clienteDB.setServicios(cliente.getServicios());
        clienteDB.setIncidentes(cliente.getIncidentes());

        return clienteRepository.save(clienteDB);
    }

    @Override
    public void deleteClienteById(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public Cliente findClienteById(Long idCliente) {
        return clienteRepository.getReferenceById(idCliente);
    }
}
