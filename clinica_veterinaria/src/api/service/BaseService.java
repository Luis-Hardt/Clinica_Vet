package api.service;

import api.model.BaseEntity;

import java.util.List;
import java.util.Map;

public abstract class BaseService<T extends BaseEntity> {

    public abstract T save(T entity);

    public abstract T findById(int id);

    public abstract List<T> findAll();

    public abstract void delete(int id);

    public abstract T update(int id, T entity);
}
