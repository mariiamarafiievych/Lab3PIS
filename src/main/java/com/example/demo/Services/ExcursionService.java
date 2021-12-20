package com.example.demo.Services;

import com.example.demo.DAO.impl.ExcursionDAO;
import com.example.demo.Entities.Excursion;
import com.example.demo.Factory.PostgresDaoFactory;
import com.example.demo.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ExcursionService {
    private final ExcursionDAO excursionDAO;


    @Autowired
    public ExcursionService(PostgresDaoFactory postgresDaoFactory) {
        this.excursionDAO = postgresDaoFactory.getExcursionDAO();
    }

    public List<Excursion> getAll() throws SQLException {
        return excursionDAO.getAll();
    }

    public Excursion getExcursion(Integer id) {
        return excursionDAO.get(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void create(Excursion excursion) {
        excursionDAO.save(excursion);
    }

    public void update(Integer id, String excursionName) throws ObjectNotFoundException {
        Excursion excursion = excursionDAO.get(id).orElseThrow(ObjectNotFoundException::new);
        excursion.setExcursionName(excursionName);
        excursionDAO.update(excursion);
    }

    public void delete(Integer id) {
        excursionDAO.delete(id);
    }
}
