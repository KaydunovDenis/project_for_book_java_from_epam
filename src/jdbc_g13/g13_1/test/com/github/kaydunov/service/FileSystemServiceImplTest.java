package com.github.kaydunov.service;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import com.github.kaydunov.model.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileSystemServiceImplTest
{
    FileSystemServiceImpl fileSystemService;

    @BeforeEach
    void beforeEach() {
        fileSystemService = new FileSystemServiceImpl();
    }
    @Test
    void getAbsolutePathTest()
    {
        //Given
        Catalog grandParent = new Catalog(null, "GrandParent");
        Catalog parent = new Catalog(grandParent, "Parent");
        Catalog child = new Catalog(parent, "Child");
        //When
        String result = fileSystemService.getAbsolutePath(child);
        //Then
        assertEquals("/GrandParent/Parent", result);
    }

    @Test
    void getAbsolutePathTest2()
    {
        //Given
        Catalog parent = new Catalog(null, "Parent");
        Catalog child = new Catalog(parent, "Child");
        //When
        String result = fileSystemService.getAbsolutePath(child);
        //Then
        assertEquals("/Parent", result);
    }

    @Test
    void getAbsolutePathForFile()
    {
        //Given
        Catalog rootCatalog = new Catalog(null, "Parent");
        Catalog parentCatalogForFile = new Catalog(rootCatalog, "ParentCatalogForFile");
        File file = new File(parentCatalogForFile, "file.txt", 31);
        //When
        String result = fileSystemService.getAbsolutePath(file);
        //Then
        assertEquals("/Parent/Child", result);
    }

    @Test
    void findFilesByFullPathMask() throws DaoException
    {
        List<File> filesByFullPathMask = fileSystemService.findFilesByFullPathMask("Catalog 1");
        assertNotNull(filesByFullPathMask);
        assertEquals(7, filesByFullPathMask.size());
    }
}
