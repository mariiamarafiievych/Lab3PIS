package com.example.demo.Factory;

import com.example.demo.DAO.impl.ClientsDAO;
import com.example.demo.DAO.impl.ExcursionDAO;
import com.example.demo.DAO.impl.ShipsDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component(value = "postgres")
@AllArgsConstructor
public class PostgresDaoFactory {
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
