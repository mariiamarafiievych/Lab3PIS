package com.example.demo.model.DAO;
import com.example.demo.model.IDAO.IExcursionDAO;
import com.example.demo.model.Entities.Excursion;
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
public class ExcursionDAO implements IExcursionDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Excursion> getAll() throws SQLException {
        Query query = entityManager.createQuery("Select o FROM Excursion o");
        return (List<Excursion>) query.getResultList();
    }

    @Override
    public Optional<Excursion> get(Integer id) throws SQLException {
        Excursion excursion = entityManager.find(Excursion.class, id);
        return Optional.ofNullable(excursion);
    }

    @Override
    public void save(Excursion excursion) throws SQLException {
        entityManager.persist(excursion);
    }

    @Override
    public void update(Excursion excursion) throws SQLException {
        entityManager.merge(excursion);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Optional<Excursion> optionalExcursion = get(id);

        if (optionalExcursion.isPresent()) {
            Excursion excursion = optionalExcursion.get();
            entityManager.remove(excursion);
        }
    }
}
