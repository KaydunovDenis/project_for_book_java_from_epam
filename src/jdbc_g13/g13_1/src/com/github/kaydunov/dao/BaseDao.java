package com.github.kaydunov.dao;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Entity;

import java.util.List;

public interface BaseDao <K, E extends Entity>
{
    boolean create(E entity) throws DaoException;
    List<E> findAll() throws DaoException;
    E findById(K id) throws DaoException;
    boolean  update(E entity) throws DaoException;
    boolean deleteById(K id) throws DaoException;
}
