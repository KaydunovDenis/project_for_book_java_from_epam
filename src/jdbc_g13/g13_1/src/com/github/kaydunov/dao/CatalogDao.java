package com.github.kaydunov.dao;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogDao implements SpecialCatalogDao
{
    private static final String SQL_SELECT_ALL = "select * from CATALOG";
    private static final String SQL_SELECT_CATALOG_BY_ID =
        "select * from CATALOG where CATALOG_ID = ?";
    private static final String SQL_DELETE_CATALOG_BY_ID =
        "delete from CATALOG where CATALOG_ID = ?";

    private static final String SQL_UPDATE =
        "UPDATE CATALOG set NAME = ?, PARENT_CATALOG_ID = ? where CATALOG_ID = ?";

    private static final String SQL_INSERT =
        "INSERT INTO CATALOG (name, parent_catalog_id) values (?, ?)";

    private static final String SQL_CLEAR_CATALOG =
        "delete from CATALOG where PARENT_CATALOG_ID = ?";

    private static final String SQL_UPDATE_PARENT_CATALOG_ID =
        "UPDATE CATALOG " + "SET PARENT_CATALOG_ID = ? WHERE PARENT_CATALOG_ID = ?";

    private static final String SQL_COUNT_FILES_IN_CATALOG = """
        WITH RECURSIVE catalog_ids AS (
            SELECT CATALOG_ID
            FROM CATALOG
            WHERE PARENT_CATALOG_ID = ?
                
            UNION ALL
                
            SELECT CATALOG_ID
            FROM CATALOG
            WHERE PARENT_CATALOG_ID IN (SELECT CATALOG_ID FROM catalog_ids)
        )
                
        SELECT COUNT(*)
        FROM FILE
        WHERE PARENT_CATALOG_ID IN (
            SELECT CATALOG_ID FROM catalog_ids
            UNION
            SELECT ? AS CATALOG_ID
            );
        """;

    private static final String SQL_COUNT_CATALOG_SIZE = """
        WITH RECURSIVE catalog_ids AS (
            SELECT CATALOG_ID
            FROM CATALOG
            WHERE PARENT_CATALOG_ID = ?
                
            UNION ALL
                
            SELECT CATALOG_ID
            FROM CATALOG
            WHERE PARENT_CATALOG_ID IN (SELECT CATALOG_ID FROM catalog_ids)
        )
                
        SELECT SUM(SIZE)
        FROM FILE
        WHERE PARENT_CATALOG_ID IN (
            SELECT CATALOG_ID FROM catalog_ids
            UNION
            SELECT ? AS CATALOG_ID
            );
        """;

    @Override
    public boolean create(Catalog catalog) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT)
        ) {
            statement.setString(1, catalog.getName());
            statement.setLong(2, catalog.getParent().getId());
            int result = statement.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            throw new DaoException("Error creating data: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Catalog> findAll() throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL)
        ) {
            List<Catalog> catalogs = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long parentCatalogId = resultSet.getLong("PARENT_CATALOG_ID");
                Catalog catalog = new Catalog();
                catalog.setName(resultSet.getString("NAME"));
                catalog.setParent(getCatalog(parentCatalogId, connection));
                catalogs.add(catalog);
            }
            return catalogs;
        }
        catch (SQLException e) {
            throw new DaoException("Error finding data: " + e.getMessage(), e);
        }
    }

    @Override
    public Catalog findById(Long id) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection()) {
            return getCatalog(id, connection);
        }
        catch (SQLException e) {
            throw new DaoException("Error finding data by Id: " + e.getMessage(), e);
        }
    }

    private Catalog getCatalog(long id, Connection connection) throws SQLException, DaoException
    {
        ResultSet resultSet;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CATALOG_BY_ID)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
        }
        if (id != 0 && resultSet.next()) {
            Catalog parent = findById(resultSet.getLong("PARENT_CATALOG_ID"));
            String name = resultSet.getString("NAME");
            return new Catalog(parent, name);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean update(Catalog catalog) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            long parentId = Optional.ofNullable(catalog.getParent()).map(Catalog::getId).orElse(0L);
            statement.setString(1, catalog.getName());
            statement.setLong(2, parentId);
            statement.setLong(3, catalog.getId());
            int result = statement.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            throw new DaoException("Error updating data: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_CATALOG_BY_ID)) {
            statement.setLong(1, id);
            int result = statement.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            throw new DaoException("Error deleting data: " + e.getMessage(), e);
        }
    }

    @Override
    public int countFiles(Catalog catalog) throws DaoException
    {
        Long catalogId = catalog.getId();
        return executeSQLWithParameter(SQL_COUNT_FILES_IN_CATALOG, catalogId);
    }

    @Override
    public int getSize(Catalog catalog) throws DaoException
    {
        Long catalogId = catalog.getId();
        return executeSQLWithParameter(SQL_COUNT_CATALOG_SIZE, catalogId);
    }

    private int executeSQLWithParameter(String query, Long catalogId) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setLong(1, catalogId);
            statement.setLong(2, catalogId);
            ResultSet result = statement.executeQuery();
            return result.getInt(1);
        }
        catch (SQLException e) {
            throw new DaoException("Error finding size file: " + e.getMessage(), e);
        }
    }

    /**
     * Move all catalogs from Source Catalog to Destination Catalog
     *
     * @param destinationCatalogId
     * @param sourceCatalogId
     * @throws DaoException
     */
    public void updateParentCatalog(Long destinationCatalogId, long sourceCatalogId)
        throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PARENT_CATALOG_ID)
        ) {
            statement.setLong(1, destinationCatalogId);
            statement.setLong(2, sourceCatalogId);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DaoException("Error updating og parent catalog: " + e.getMessage(), e);
        }
    }

    public void clearCatalog(Catalog catalog) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CLEAR_CATALOG)
        ) {
            statement.setLong(1, catalog.getId());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DaoException("Error clearing catalog: " + e.getMessage(), e);
        }
    }
}
