package com.github.kaydunov.service;

import com.github.kaydunov.dao.CatalogDao;
import com.github.kaydunov.model.Catalog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogServiceImplTest
{
    private FileSystemsService catalogService;

    @BeforeEach
    void beforeEach() {
        CatalogDao catalogDao = new CatalogDao();
        catalogService = new CatalogServiceImpl(catalogDao);
    }
    @Test
    void getAbsolutePathTest()
    {
        //Given
        Catalog grandParent = new Catalog(null, "GrandParent");
        Catalog parent = new Catalog(grandParent, "Parent");
        Catalog child = new Catalog(parent, "Child");
        //When
        String result = catalogService.getAbsolutePath(child);
        //Then
        Assertions.assertEquals("/GrandParent/Parent", result);
    }

    @Test
    void getAbsolutePathTest2()
    {
        //Given
        Catalog parent = new Catalog(null, "Parent");
        Catalog child = new Catalog(parent, "Child");
        //When
        String result = catalogService.getAbsolutePath(child);
        //Then
        Assertions.assertEquals("/Parent", result);
    }




}
