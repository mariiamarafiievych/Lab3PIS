package com.example.demo.model.Services;

import com.example.demo.model.DAO.ClientsDAO;
import com.example.demo.model.Entities.Client;
import com.example.demo.model.Factory.MySQLDaoFactory;
import com.example.demo.model.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientsDAO clientsDAO;


    @Autowired
    public ClientService(MySQLDaoFactory mySQLDaoFactory) {
        this.clientsDAO = mySQLDaoFactory.getClientsDAO();
    }

    public List<Client> getAll() throws SQLException {
        return clientsDAO.getAll();
    }

    public void create(Client client) throws SQLException {
        clientsDAO.save(client);
    }

    public void update(Integer id, String clientBonus) throws ObjectNotFoundException, SQLException {
        Client client = clientsDAO.get(id).orElseThrow(ObjectNotFoundException::new);
        client.setClientBonus(clientBonus);
        clientsDAO.update(client);
    }

    public void delete(Integer id) throws SQLException {
        clientsDAO.delete(id);
    }
}
