package com.github.kaydunov.service;

import com.github.kaydunov.dao.CatalogDao;
import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;

import java.util.List;

public class CatalogService
{
    private final CatalogDao catalogDao = new CatalogDao();

    public int countFiles(Catalog catalog) throws DaoException
    {
        return catalogDao.countFiles(catalog);
    }

    public void clearCatalog(Catalog catalog) throws DaoException
    {
        catalogDao.clearCatalog(catalog);
    }


    public List<Catalog> getAll() throws DaoException
    {
        return catalogDao.findAll();
    }

    public Catalog getById(Long id) throws DaoException {
        return catalogDao.findById(id);
    }

    public boolean deleteById(Long id) throws DaoException {
        return catalogDao.deleteById(id);
    }

    public boolean create(Catalog catalog) throws DaoException
    {
        return catalogDao.create(catalog);
    }

    public boolean update(Catalog catalog) throws DaoException
    {
        return catalogDao.update(catalog);
    }
}
