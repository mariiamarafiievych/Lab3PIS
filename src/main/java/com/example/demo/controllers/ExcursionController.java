package com.example.demo.controllers;

import com.example.demo.Entities.Excursion;
import com.example.demo.Services.ExcursionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("excursion")
@AllArgsConstructor
public class ExcursionController {
    private final ExcursionService excursionService;

    @GetMapping
    public ResponseEntity<List<Excursion>> getClients() throws SQLException {
        return ResponseEntity.ok(excursionService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Excursion> getClient(@PathVariable Integer id) throws SQLException {
        return ResponseEntity.ok(excursionService.getExcursion(id));
    }
}
