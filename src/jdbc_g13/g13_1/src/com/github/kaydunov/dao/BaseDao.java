package com.github.kaydunov.dao;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao <K, E extends Entity>
{
    boolean create(E entity) throws DaoException;
    List<E> findAll() throws DaoException;
    E findById(K id) throws DaoException;
    boolean  update(E entity) throws DaoException;
    boolean delete(E entity) throws DaoException;
    boolean deleteById(K id) throws DaoException;

    default void close(Statement statement)
    {
        try {
            if (statement != null) {
                statement.close();
            }
        }
        catch (SQLException e) { // log
        }
    }

    default void close(Connection connection)
    {
        try {
            if (connection != null) {
                connection.close(); // or connection return code to the pool
            }
        }
        catch (SQLException e) {
            // log
        }
    }

}
