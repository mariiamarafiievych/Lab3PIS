package com.example.demo.model.Services;

import com.example.demo.model.DAO.ShipsDAO;
import com.example.demo.model.Entities.Excursion;
import com.example.demo.model.Entities.Ship;
import com.example.demo.model.Factory.MySQLDaoFactory;
import com.example.demo.model.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class ShipService {
    private final ShipsDAO shipDAO;


    @Autowired
    public ShipService(MySQLDaoFactory mySQLDaoFactory) {
        this.shipDAO = mySQLDaoFactory.getShipDAO();
    }

    public List<Ship> getAll() throws SQLException {
        return shipDAO.getAll();
    }

    public void create(Ship ship) throws SQLException {
        shipDAO.save(ship);
    }

    public void update(Integer id, String route) throws ObjectNotFoundException, SQLException {
        Ship ship = shipDAO.get(id).orElseThrow(ObjectNotFoundException::new);
        ship.setRoute(route);
        shipDAO.update(ship);
    }

    public void delete(Integer id) throws SQLException {
        shipDAO.delete(id);
    }
}
