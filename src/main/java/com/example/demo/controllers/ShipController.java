package com.example.demo.controllers;

import com.example.demo.Entities.Ship;
import com.example.demo.Services.ShipService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("ship")
@AllArgsConstructor
public class ShipController {
    private final ShipService shipService;

    @GetMapping
    public ResponseEntity<List<Ship>> getClients() throws SQLException {
        return ResponseEntity.ok(shipService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Ship> getClient(@PathVariable Integer id) throws SQLException {
        return ResponseEntity.ok(shipService.getShip(id));
    }
}