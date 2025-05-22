package api.repository;

import api.model.BaseEntity;

import java.util.List;
import java.util.Map;

public interface Repository<T extends BaseEntity> {
    T save(T entity);

    T findById(int id);

    Map<Integer, T> findAll();

    void delete(int id);
}
