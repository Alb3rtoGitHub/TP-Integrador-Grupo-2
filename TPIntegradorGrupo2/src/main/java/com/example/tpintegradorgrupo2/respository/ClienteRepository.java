package com.example.tpintegradorgrupo2.respository;

import com.example.tpintegradorgrupo2.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import java.util.ArrayList;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //si quiero agregar un método
    //@Query("SELECT * FROM cliente WHERE activo = 1")
    //ArrayList<Cliente> getAllClientesActivos();
}