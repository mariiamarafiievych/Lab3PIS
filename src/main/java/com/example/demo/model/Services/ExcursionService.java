package com.example.demo.model.Services;

import com.example.demo.model.DAO.ExcursionDAO;
import com.example.demo.model.Entities.Client;
import com.example.demo.model.Entities.Excursion;
import com.example.demo.model.Factory.MySQLDaoFactory;
import com.example.demo.model.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ExcursionService {
    private final ExcursionDAO excursionDAO;


    @Autowired
    public ExcursionService(MySQLDaoFactory mySQLDaoFactory) {
        this.excursionDAO = mySQLDaoFactory.getExcursionDAO();
    }

    public List<Excursion> getAll() throws SQLException {
        return excursionDAO.getAll();
    }

    public void create(Excursion excursion) throws SQLException {
        excursionDAO.save(excursion);
    }

    public void update(Integer id, String excursionName) throws ObjectNotFoundException, SQLException {
        Excursion excursion = excursionDAO.get(id).orElseThrow(ObjectNotFoundException::new);
        excursion.setExcursionName(excursionName);
        excursionDAO.update(excursion);
    }

    public void delete(Integer id) throws SQLException {
        excursionDAO.delete(id);
    }
}
