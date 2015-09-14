package com.bakigoal.repository.impl;

import com.bakigoal.repository.SuperRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by bakigoal on 12.09.15.
 */
public abstract class AbstractBaseRepositoryImpl<T, P> implements SuperRepository<T, P> {
    @PersistenceContext
    protected EntityManager em;

    @Override
    public T create(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T get(P id) {
        return this.em.find(getEntityClass(), id);
    }

    @Override
    public T update(T t) {
        T merge = this.em.merge(t);
        return merge;
    }

    @Override
    public void delete(T t) {
        T newT = this.em.merge(t);
        this.em.remove(newT);
    }

    @Override
    public List<T> getAll() {
        TypedQuery<T> namedQuery = em.createNamedQuery(getEntityClass().getSimpleName() + ".findAll", getEntityClass());
        return namedQuery.getResultList();
    }

    protected abstract Class<T> getEntityClass();
}
