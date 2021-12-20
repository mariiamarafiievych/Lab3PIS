package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

public interface CrudIDAO<Entity, Key> {
    List<Entity> getAll();

    Optional<Entity> get(Key id);

    void save(Entity entity);

    void update(Entity entity);

    void delete(Key id);
}
