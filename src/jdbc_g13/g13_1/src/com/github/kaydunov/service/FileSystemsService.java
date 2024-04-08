package com.github.kaydunov.service;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;

public interface FileSystemsService extends Service
{
    /**
     * Count the number of files in the specified directory, including nested files and directories.
     * @param catalog
     * @return
     * @throws DaoException
     */
    int countFiles(Catalog catalog) throws DaoException;

    /**
     * Count the disk space occupied by the contents of the specified directory.
     * @param catalog
     * @return
     */
    int getSize(Catalog catalog) throws DaoException;

    /**
     * Move files and subdirectories from one directory to another.
     */
    void moveTo(Catalog destination, Catalog from) throws DaoException;

    /**
     * Delete files and directories of the specified directory.
     * @param catalog
     * @throws DaoException
     */
    void clearCatalog(Catalog catalog) throws DaoException;
}
