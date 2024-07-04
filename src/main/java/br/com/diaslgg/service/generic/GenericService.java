package br.com.diaslgg.service.generic;

import br.com.diaslgg.dao.Persistent;
import br.com.diaslgg.dao.generic.IGenericDAO;
import br.com.diaslgg.exception.KeyNotFoundException;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericService<T extends Persistent, E extends Serializable> implements IGenericService<T, E> {

    protected IGenericDAO <T, E> dao;

    public GenericService(IGenericDAO <T, E> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean signUp(T entity) throws KeyNotFoundException {
        return this.dao.signUp(entity);
    }

    @Override
    public void exclude(E value) {
        this.dao.exclude(value);
    }

    @Override
    public void edit(T entity) throws KeyNotFoundException {
        this.dao.edit(entity);
    }

    @Override
    public T check(E value) {
        return this.dao.check(value);
    }

    @Override
    public Collection<T> searchAll() {
        return this.dao.searchAll();
    }
}
