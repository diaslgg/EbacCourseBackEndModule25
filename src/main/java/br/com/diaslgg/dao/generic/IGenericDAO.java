package br.com.diaslgg.dao.generic;

import br.com.diaslgg.dao.Persistent;
import br.com.diaslgg.exception.KeyNotFoundException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistent, E extends Serializable> {

    public Boolean signUp(T entity) throws KeyNotFoundException;

    public void exclude(E value);

    public void edit(T entity) throws KeyNotFoundException;

    public T check(E valor);

    public Collection<T> searchAll();

}
