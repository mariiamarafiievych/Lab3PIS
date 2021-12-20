package com.example.demo.Services;

import com.example.demo.DAO.impl.ClientsDAO;
import com.example.demo.Entities.Client;
import com.example.demo.Factory.PostgresDaoFactory;
import com.example.demo.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClientService {
    private final ClientsDAO clientsDAO;


    @Autowired
    public ClientService(PostgresDaoFactory postgresDaoFactory) {
        this.clientsDAO = postgresDaoFactory.getClientsDAO();
    }

    public List<Client> getAll() throws SQLException {
        return clientsDAO.getAll();
    }

    public Client getClient(Integer id) {
        return clientsDAO.get(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void create(Client client) {
        clientsDAO.save(client);
    }

    public void update(Integer id, String clientBonus) throws ObjectNotFoundException {
        Client client = clientsDAO.get(id).orElseThrow(ObjectNotFoundException::new);
        client.setClientBonus(clientBonus);
        clientsDAO.update(client);
    }

    public void delete(Integer id) {
        clientsDAO.delete(id);
    }
}
