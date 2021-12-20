package com.example.demo.model.Factory;

import com.example.demo.model.DAO.ClientsDAO;
import com.example.demo.model.DAO.ExcursionDAO;

import com.example.demo.model.DAO.ShipsDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component(value = "postgres")
@AllArgsConstructor
public class MySQLDaoFactory {
    private final ClientsDAO clientsDAO;
    private final ExcursionDAO excursionDAO;
    private final ShipsDAO shipDAO;

    public ClientsDAO getClientsDAO() {
        return clientsDAO;
    }
    public ExcursionDAO getExcursionDAO() {
        return excursionDAO;
    }
    public ShipsDAO getShipDAO() {
        return shipDAO;
    }

}
