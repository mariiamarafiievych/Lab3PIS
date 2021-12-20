package com.example.demo.model.IDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MainIDAO <Entity, Key>{
    List<Entity> getAll() throws SQLException;

    Optional<Entity> get(Key id) throws SQLException;

    void save(Entity entity) throws SQLException;

    void update(Entity entity) throws SQLException;

    void delete(Key id) throws SQLException;
}
