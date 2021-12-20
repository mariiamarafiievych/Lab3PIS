package com.example.demo;

import com.example.demo.model.DAO.ClientsDAO;
import com.example.demo.model.DAO.ExcursionDAO;
import com.example.demo.model.DAO.ShipsDAO;
import com.example.demo.model.Entities.Client;
import com.example.demo.model.Entities.Excursion;
import com.example.demo.model.Entities.Ship;
import com.example.demo.model.Factory.MySQLDaoFactory;
import com.example.demo.model.Services.ClientService;
import com.example.demo.model.Services.ExcursionService;
import com.example.demo.model.Services.ShipService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException {


    }

}
