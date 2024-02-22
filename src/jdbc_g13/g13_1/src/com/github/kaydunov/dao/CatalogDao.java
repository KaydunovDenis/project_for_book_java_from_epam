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

public class CatalogDao implements BaseDao<Long, Catalog>
{
    private static final String SQL_SELECT_ALL = "SELECT * FROM catalog";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM catalog WHERE id = ?";
    private static final String SQL_SELECT_DELETE_BY_ID = "DELETE FROM catalog WHERE id = ?";

    private static final String SQL_UPDATE =
        "UPDATE catalog SET name = ?, parent_catalog_id = ? WHERE id = ?";

    private static final String SQL_INSERT =
        "INSERT INTO catalog (name, parent_catalog_id) VALUES (?, ?)";

    @Override
    public boolean create(Catalog catalog) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, catalog.getName());
            statement.setLong(2, catalog.getParent().getId());
            int result = statement.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Catalog> findAll() throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection()) {
            List<Catalog> catalogs = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long parentCatalogId = resultSet.getLong("parent_catalog_id");
                Catalog catalog = new Catalog();
                catalog.setName(resultSet.getString("name"));
                if (parentCatalogId != 0) {
                    catalog.setParent(getCatalog(parentCatalogId, connection));
                }
                catalogs.add(catalog);
            }
            return catalogs;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Catalog findById(Long id) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection()) {
            return getCatalog(id, connection);
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Catalog getCatalog(long id, Connection connection) throws SQLException, DaoException
    {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
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
        try (Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            long parentId = Optional.ofNullable(catalog.getParent()).map(Catalog::getId).orElse(0L);
            statement.setString(1, catalog.getName());
            statement.setLong(2, parentId);
            statement.setLong(3, catalog.getId());
            int result = statement.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(Catalog catalog) throws DaoException
    {
        return deleteById(catalog.getId());
    }

    @Override
    public boolean deleteById(Long id) throws DaoException
    {
        try (Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_DELETE_BY_ID);
            statement.setLong(1, id);
            int result = statement.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
