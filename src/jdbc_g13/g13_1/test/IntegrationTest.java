import com.github.kaydunov.dao.CatalogDao;
import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest
{
    private final CatalogDao catalogDao = new CatalogDao();

    @Test
    void create() throws DaoException
    {
        Catalog parentCatalog = new Catalog(null, "Root");
        parentCatalog.setId(1L);
        Catalog newCatalog = new Catalog();
        newCatalog.setParent(parentCatalog);
        newCatalog.setName("test");
        boolean result = catalogDao.create(newCatalog);
        assertTrue(result);
    }

    @Test
    void update() throws DaoException
    {
        Catalog catalog = new Catalog(1L, null, "New Root");
        boolean result = catalogDao.update(catalog);
        assertTrue(result);
    }

    @Test
    void findById_root() throws DaoException
    {
        Catalog result = catalogDao.findById(1L);
        assertNotNull(result);
    }

    @Test
    void findById_child() throws DaoException
    {
        Catalog result = catalogDao.findById(4L);
        assertNotNull(result);
        assertEquals("Root", result.getParent().getParent().getParent().getName());
    }

    @Test
    void getAll() throws DaoException
    {
        List<Catalog> result = catalogDao.findAll();
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void delete() throws DaoException
    {
        boolean result = catalogDao.deleteById(4L);
        assertTrue(result);
    }

    @Test
    void clearCatalog() throws DaoException
    {
        Catalog catalog = new Catalog();
        catalog.setId(2L);
        catalogDao.clearCatalog(catalog);
    }

    @Test
    void countFiles() throws DaoException
    {
        Catalog catalog = new Catalog();
        catalog.setId(1L);
        int result = catalogDao.countFiles(catalog);
        Assertions.assertEquals(10, result);
    }
}
