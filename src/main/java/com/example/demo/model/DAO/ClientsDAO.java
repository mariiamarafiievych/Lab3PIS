package com.example.demo.model.DAO;

import com.example.demo.model.Entities.Client;
import com.example.demo.model.IDAO.IClientsDAO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ClientsDAO implements IClientsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> getAll() throws SQLException {
        Query query = entityManager.createQuery("Select c FROM Client c");
        return (List<Client>) query.getResultList();
    }

    @Override
    public Optional<Client> get(Integer id) throws SQLException {
        Client client = entityManager.find(Client.class, id);
        return Optional.ofNullable(client);
    }

    @Override
    public void save(Client client) throws SQLException {
        entityManager.persist(client);
    }

    @Override
    public void update(Client client) throws SQLException {
        entityManager.merge(client);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Optional<Client> optionalClient = get(id);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            entityManager.remove(client);
        }
    }


}
