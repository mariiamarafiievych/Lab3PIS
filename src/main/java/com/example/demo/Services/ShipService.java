package com.example.demo.Services;

import com.example.demo.DAO.impl.ShipsDAO;
import com.example.demo.Entities.Ship;
import com.example.demo.Factory.PostgresDaoFactory;
import com.example.demo.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ShipService {
    private final ShipsDAO shipDAO;


    @Autowired
    public ShipService(PostgresDaoFactory postgresDaoFactory) {
        this.shipDAO = postgresDaoFactory.getShipDAO();
    }

    public List<Ship> getAll() throws SQLException {
        return shipDAO.getAll();
    }

    public Ship getShip(Integer id) {
        return shipDAO.get(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void create(Ship ship) {
        shipDAO.save(ship);
    }

    public void update(Integer id, String route) throws ObjectNotFoundException, SQLException {
        Ship ship = shipDAO.get(id).orElseThrow(ObjectNotFoundException::new);
        ship.setRoute(route);
        shipDAO.update(ship);
    }

    public void delete(Integer id) {
        shipDAO.delete(id);
    }
}
