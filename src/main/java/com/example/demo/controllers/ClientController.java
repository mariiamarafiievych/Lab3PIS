package com.example.demo.controllers;
import com.example.demo.model.Entities.Client;
import com.example.demo.model.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> show() throws SQLException {
        return ResponseEntity.ok(clientService.getAll());
    }

}