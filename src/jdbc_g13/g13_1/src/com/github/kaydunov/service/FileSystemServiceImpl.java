package com.github.kaydunov.service;

import com.github.kaydunov.dao.CatalogDao;
import com.github.kaydunov.dao.FileDao;
import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import com.github.kaydunov.model.Entity;

public class FileSystemServiceImpl implements FileSystemsService
{
    CatalogServiceImpl catalogService = new CatalogServiceImpl();
    CatalogDao catalogDao = new CatalogDao();
    FileDao fileDao = new FileDao();

    @Override
    public int countFiles(Catalog catalog) throws DaoException
    {
        return catalogService.countFiles(catalog);
    }

    @Override
    public int getSize(Catalog catalog) throws DaoException
    {
        return catalogDao.getSize(catalog);
    }

    @Override
    public void moveTo(Catalog destination, Catalog from) throws DaoException
    {
        Long destinationCatalogId = destination.getId();
        Long sourceCatalogId = from.getId();
        catalogDao.updateParentCatalog(destinationCatalogId, sourceCatalogId);
        fileDao.updateParentCatalog(destinationCatalogId, sourceCatalogId);
    }

    @Override
    public void clearCatalog(Catalog catalog) throws DaoException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getAbsolutePath(Entity entity)
    {
        throw new UnsupportedOperationException();
    }
}
