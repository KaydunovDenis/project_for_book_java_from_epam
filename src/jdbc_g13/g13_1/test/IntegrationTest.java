import com.github.kaydunov.dao.CatalogDao;
import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.github.kaydunov.service.CatalogService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest
{
    private final CatalogService catalogService = new CatalogService();

    @Test
    void create() throws DaoException
    {
        Catalog parentCatalog = new Catalog(null, "Root");
        parentCatalog.setId(1L);
        Catalog newCatalog = new Catalog();
        newCatalog.setParent(parentCatalog);
        newCatalog.setName("test");
        boolean result = catalogService.create(newCatalog);
        assertTrue(result);
    }

    @Test
    void update() throws DaoException
    {
        Catalog catalog = new Catalog(1L, null, "New Root");
        boolean result = catalogService.update(catalog);
        assertTrue(result);
    }

    @Test
    void getById_root() throws DaoException
    {
        Catalog result = catalogService.getById(1L);
        assertNotNull(result);
    }

    @Test
    void getById_child() throws DaoException
    {
        Catalog result = catalogService.getById(4L);
        assertNotNull(result);
        assertEquals("Root", result.getParent().getParent().getParent().getName());
    }

    @Test
    void getAll() throws DaoException
    {
        List<Catalog> result = catalogService.getAll();
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void delete() throws DaoException
    {
        boolean result = catalogService.deleteById(4L);
        assertTrue(result);
    }

    @Test
    void clearCatalog() throws DaoException
    {
        Catalog catalog = new Catalog();
        catalog.setId(2L);
        catalogService.clearCatalog(catalog);
    }

    @Test
    void countFiles() throws DaoException
    {
        Catalog catalog = new Catalog();
        catalog.setId(1L);
        int result = catalogService.countFiles(catalog);
        Assertions.assertEquals(10, result);
    }
}
