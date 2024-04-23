package com.kaydunov.service;

import com.kaydunov.dao.DirectorDao;
import com.kaydunov.exception.DaoException;
import com.kaydunov.model.Director;

import java.sql.SQLException;

public class DirectorService {

    private static final DirectorDao directorDao = new DirectorDao();

    public Director findById(Integer id) throws SQLException, DaoException {
        return directorDao.findById(id);
    }
}
