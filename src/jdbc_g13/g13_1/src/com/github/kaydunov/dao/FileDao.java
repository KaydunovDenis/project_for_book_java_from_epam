package com.github.kaydunov.dao;

import com.github.kaydunov.exception.DaoException;
import com.github.kaydunov.model.Catalog;
import com.github.kaydunov.model.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FileDao implements BaseDao<Long, File> {
    private static final String SQL_SELECT_ALL = "SELECT * FROM FILE";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM FILE WHERE FILE_ID = ?";
    private static final String SQL_UPDATE = "UPDATE FILE SET NAME = ?, SIZE = ? WHERE FILE_ID = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM FILE WHERE FILE_ID = ?";
    private static final String SQL_INSERT = "INSERT INTO FILE (PARENT_CATALOG_ID, NAME, SIZE) VALUES (?, ?, ?)";

    private static final String SQL_UPDATE_PARENT_CATALOG_ID = "UPDATE FILE " +
        "SET PARENT_CATALOG_ID = ? WHERE PARENT_CATALOG_ID = ?";

    @Override
    public boolean create(File file) throws DaoException {
        try (Connection connection = ConnectionCreator.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setLong(1, file.getParent().getId());
            statement.setString(2, file.getName());
            statement.setInt(3, file.getSize());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            throw new DaoException("Error creating file: " + e.getMessage(), e);
        }
    }

    @Override
    public List<File> findAll() throws DaoException {
        List<File> files = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                File file = extractFileFromResultSet(resultSet);
                files.add(file);
            }
        } catch (SQLException e) {
            throw new DaoException("Error finding all files: " + e.getMessage(), e);
        }
        return files;
    }

    @Override
    public File findById(Long id) throws DaoException {
        try (Connection connection = ConnectionCreator.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractFileFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error finding file by id: " + e.getMessage(), e);
        }
        return null;
    }

    private File extractFileFromResultSet(ResultSet resultSet) throws SQLException, DaoException
    {
        long id = resultSet.getLong("FILE_ID");
        long parentCatalogId = resultSet.getLong("PARENT_CATALOG_ID");
        CatalogDao catalogDao = new CatalogDao();
        Catalog catalog = catalogDao.findById(parentCatalogId);
        String name = resultSet.getString("NAME");
        int size = resultSet.getInt("SIZE");
        return new File(id, catalog, name, size);
    }

    @Override
    public boolean update(File file) throws DaoException {
        try (Connection connection = ConnectionCreator.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, file.getName());
            statement.setInt(2, file.getSize());
            statement.setLong(3, file.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new DaoException("Error updating file: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionCreator.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new DaoException("Error deleting file by id: " + e.getMessage(), e);
        }
    }

    /**
     * Move all files from Source Catalog to Destination Catalog
     * @param destinationCatalogId
     * @param sourceCatalogId
     * @return return true if any catalog was moved
     * @throws DaoException
     */
    public boolean updateParentCatalog(Long destinationCatalogId, long sourceCatalogId)
        throws DaoException
    {
        try (Connection connection = ConnectionCreator.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PARENT_CATALOG_ID);
            statement.setLong(1, destinationCatalogId);
            statement.setLong(2, sourceCatalogId);
            int result = statement.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            throw new DaoException("Error finding data: " + e.getMessage(), e);
        }
    }
}