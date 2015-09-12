package com.bakigoal.repository;

import java.util.List;

/**
 *
 * @author ilmir
 * @param <T>
 */
public interface SuperRepository<T,P> {

    public T create(T t);

    public T get(P id);

    public T update(T t);

    public void delete(T t);

    public List<T> getAll();
}
