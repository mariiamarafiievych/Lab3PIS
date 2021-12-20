package com.example.demo.DAO.impl;

import com.example.demo.DAO.IClientsDAO;
import com.example.demo.Entities.Client;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ClientsDAO implements IClientsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> getAll() {
        Query query = entityManager.createQuery("Select c FROM Client c");
        return (List<Client>) query.getResultList();
    }

    @Override
    public Optional<Client> get(Integer id) {
        Client client = entityManager.find(Client.class, id);
        return Optional.ofNullable(client);
    }

    @Override
    public void save(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void update(Client client) {
        entityManager.merge(client);
    }

    @Override
    public void delete(Integer id) {
        Optional<Client> optionalClient = get(id);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            entityManager.remove(client);
        }
    }


}
