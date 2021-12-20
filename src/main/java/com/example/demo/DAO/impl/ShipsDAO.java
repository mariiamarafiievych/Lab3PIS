package com.example.demo.DAO.impl;

import com.example.demo.DAO.IShipDAO;
import com.example.demo.Entities.Ship;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ShipsDAO implements IShipDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Ship> getAll() {
        Query query = entityManager.createQuery("Select o FROM Ship o");
        return (List<Ship>) query.getResultList();
    }

    @Override
    public Optional<Ship> get(Integer id) {
        Ship ship = entityManager.find(Ship.class, id);
        return Optional.ofNullable(ship);
    }

    @Override
    public void save(Ship ship) {
        entityManager.persist(ship);
    }

    @Override
    public void update(Ship ship) {
        entityManager.merge(ship);
    }

    @Override
    public void delete(Integer id) {
        Optional<Ship> optionalShip = get(id);

        if (optionalShip.isPresent()) {
            Ship ship = optionalShip.get();
            entityManager.remove(ship);
        }
    }
}
