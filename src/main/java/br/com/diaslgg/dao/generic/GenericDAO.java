package br.com.diaslgg.dao.generic;

import br.com.diaslgg.annotation.KeyType;
import br.com.diaslgg.dao.Persistent;
import br.com.diaslgg.exception.KeyNotFoundException;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persistent, E extends Serializable> implements IGenericDAO<T,E> {

    private SingletonMap singletonMap;

    public abstract Class<T> getClassType();

    public abstract void updateData(T entity, T entityCreated);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    public E getKey(T entity) throws KeyNotFoundException {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(KeyType.class)) {
                KeyType keyType = field.getAnnotation(KeyType.class);
                String methodName = keyType.value();
                try {
                    Method method = entity.getClass().getMethod(methodName);
                    returnValue = (E) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new KeyNotFoundException("Main key from object " + entity.getClass() + " not found", e);
                }
            }
        }
        if (returnValue == null) {
            String message = "Main key from object " + entity.getClass() + " not found";
            throw new KeyNotFoundException(message);
        }
        return null;
    }

    @Override
    public Boolean signUp(T entity) throws KeyNotFoundException {
        Map<E, T> internalMap = getMap();
        E key = getKey(entity);
        if (internalMap.containsKey(key)) {
            return false;
        }

        internalMap.put(key, entity);
        return true;
    }

    private Map<E, T> getMap() {
        Map<E, T> internalMap = (Map<E, T>) this.singletonMap.getMap().get(getClassType());
        if (internalMap == null) {
            internalMap = new HashMap<>();
            this.singletonMap.getMap().put(getClassType(), internalMap);
        }
        return internalMap;
    }

    @Override
    public void exclude(E valor) {
        //Map<Long, T> interalMap = this.map.get(getTipoClasse());
        Map<E, T> interalMap = getMap();
        T objectCreated = interalMap.get(valor);
        if (objectCreated != null) {
            interalMap.remove(valor, objectCreated);
        }
    }

    @Override
    public void edit(T entity) throws KeyNotFoundException {
        Map<E, T> interalMap = getMap();
        E key = getKey(entity);
        T objectCreated = interalMap.get(key);
        if (objectCreated != null) {
            updateData(entity, objectCreated);
        }
    }

    @Override
    public T check(E valor) {
        Map<E, T> interalMap = getMap();
        return interalMap.get(valor);
    }

    @Override
    public Collection<T> searchAll() {
        Map<E, T> interalMap = getMap();
        return interalMap.values();
    }
}
