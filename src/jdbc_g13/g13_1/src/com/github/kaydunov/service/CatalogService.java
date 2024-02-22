package com.github.kaydunov.service;

import com.github.kaydunov.model.Catalog;

public interface CatalogService extends Service
{
    int countFiles(Catalog catalog);
    int getSize(Catalog catalog);
    /**Move files and subdirectories from one directory to another.
     */
    void moveTo(Catalog from, Catalog destination);
    void clearCatalog(Catalog catalog);
}
