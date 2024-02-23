package com.github.kaydunov.service;

import com.github.kaydunov.dao.CatalogDao;
import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import com.github.kaydunov.model.Entity;

import java.nio.file.FileSystems;
import java.util.List;

public class CatalogServiceImpl implements CatalogService
{
    private final CatalogDao catalogDao;

    public CatalogServiceImpl(CatalogDao catalogDao)
    {
        this.catalogDao = catalogDao;
    }

    @Override
    public int countFiles(Catalog catalog)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize(Catalog catalog)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveTo(Catalog from, Catalog destination)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearCatalog(Catalog catalog)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getAbsolutePath(Entity entity)
    {
        String absolutePath = "";
        Catalog parent = entity.getParent();
        if (parent != null) {
            String separator = FileSystems.getDefault().getSeparator();
            absolutePath = getAbsolutePath(parent) + separator + parent.getName();
        }
        return absolutePath;
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
