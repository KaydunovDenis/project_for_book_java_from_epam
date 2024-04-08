package com.github.kaydunov.dao;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;

public interface SpecialCatalogDao extends BaseDao<Long, Catalog>
{
    int countFiles(Catalog catalog) throws DaoException;
    int getSize(Catalog catalog) throws DaoException;
    boolean clearCatalog(Catalog catalog) throws DaoException;
}
