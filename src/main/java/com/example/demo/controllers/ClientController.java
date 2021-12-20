package com.example.demo.controllers;

import com.example.demo.Entities.Client;
import com.example.demo.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() throws SQLException {
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id) throws SQLException {
        return ResponseEntity.ok(clientService.getClient(id));
    }
}