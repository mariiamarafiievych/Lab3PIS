package com.example.demo.model.DAO;

import com.example.demo.model.Entities.Excursion;
import com.example.demo.model.Entities.Ship;
import com.example.demo.model.IDAO.IShipDAO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
@Transactional
public class ShipsDAO implements IShipDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Ship> getAll() throws SQLException {
        Query query = entityManager.createQuery("Select o FROM Ship o");
        return (List<Ship>) query.getResultList();
    }

    @Override
    public Optional<Ship> get(Integer id) throws SQLException {
        Ship ship = entityManager.find(Ship.class, id);
        return Optional.ofNullable(ship);
    }

    @Override
    public void save(Ship ship) throws SQLException {
        entityManager.persist(ship);
    }

    @Override
    public void update(Ship ship) throws SQLException {
        entityManager.merge(ship);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Optional<Ship> optionalShip = get(id);

        if (optionalShip.isPresent()) {
            Ship ship = optionalShip.get();
            entityManager.remove(ship);
        }
    }
}
