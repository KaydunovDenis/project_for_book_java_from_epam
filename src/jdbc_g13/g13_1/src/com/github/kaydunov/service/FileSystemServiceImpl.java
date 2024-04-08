package com.github.kaydunov.service;

import com.github.kaydunov.dao.CatalogDao;
import com.github.kaydunov.dao.FileDao;
import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import com.github.kaydunov.model.Entity;
import com.github.kaydunov.model.File;

import java.nio.file.FileSystems;
import java.util.List;

public class FileSystemServiceImpl implements FileSystemsService
{
    CatalogService catalogService = new CatalogService();
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
    public List<File> findFilesByFullPathMask(String mask) throws DaoException
    {
        throw new UnsupportedOperationException();
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
        catalogService.clearCatalog(catalog);
    }

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
}
