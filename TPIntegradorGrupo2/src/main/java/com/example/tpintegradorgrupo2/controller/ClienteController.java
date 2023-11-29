package com.example.tpintegradorgrupo2.controller;

import com.example.tpintegradorgrupo2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/viewClientes")
    public String viewBooks(Model model) {
        model.getAttribute("clientes"); //, clienteService.getAllClientes());
        return "view-clientes";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "saludo";
    }
}
