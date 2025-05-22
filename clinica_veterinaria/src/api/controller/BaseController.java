package api.controller;

import api.model.BaseEntity;

import java.util.List;

public abstract class BaseController<T extends BaseEntity> {

    public abstract T save(T entity);

    public abstract T findById(int id);

    public abstract List<T> findAll();

    public abstract void delete(int id);

    public abstract T update(int id, T entity);
}
