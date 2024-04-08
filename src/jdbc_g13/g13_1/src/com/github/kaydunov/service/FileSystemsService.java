package com.github.kaydunov.service;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import com.github.kaydunov.model.Entity;
import com.github.kaydunov.model.File;

import java.util.List;

public interface FileSystemsService
{

    /**
     * 1 Define the full path of the specified file (directory).
     *
     * @param entity
     * @return
     * @throws DaoException
     */
    String getAbsolutePath(Entity entity) throws DaoException;

    /**
     * 2 Count the number of files in the specified directory, including nested files and
     * directories.
     *
     * @param catalog
     * @return
     * @throws DaoException
     */
    int countFiles(Catalog catalog) throws DaoException;

    /**
     * 3 Count the disk space occupied by the contents of the specified directory.
     *
     * @param catalog
     * @return
     */
    int getSize(Catalog catalog) throws DaoException;

    /**
     * 4 Find files in the database using a given mask with a full path.
     */
    List<File> findFilesByFullPathMask(String mask) throws DaoException;

    /**
     * 5 Move files and subdirectories from one directory to another.
     */
    void moveTo(Catalog destination, Catalog from) throws DaoException;

    /**
     * 6 Delete files and directories of the specified directory.
     *
     * @param catalog
     * @throws DaoException
     */
    void clearCatalog(Catalog catalog) throws DaoException;

}
