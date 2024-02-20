package jdbc_g13.example_6.dao;

import jdbc_g13.example_6.exception.DaoException;
import jdbc_g13.example_6.model.Abonent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AbonentDaoImpl implements AbonentDao
{
    private static final String SQL_SELECT_ALL_ABONENTS =
        "SELECT * FROM phonebook";
    private static final String SQL_SELECT_ABONENT_BY_LASTNAME =
        "SELECT idphonebook, phone FROM phonebook WHERE lastname = ?";

    @Override
    public List<Abonent> findAbonentByLastname(String namePattern) throws DaoException
    {
        List<Abonent> abonents = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ABONENT_BY_LASTNAME);
            statement.setString(1, namePattern);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt("idphonebook"));
                abonent.setPhone(resultSet.getInt("phone"));
                abonent.setName(namePattern);
                abonents.add(abonent);
            }
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            close(statement);
            close(connection);
        }
        return abonents;
    }

    @Override
    public List<Abonent> findAll() throws DaoException
    {
        List<Abonent> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ABONENTS);

            while (resultSet.next()) {
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt(1));
                abonent.setName(resultSet.getString(2));
                abonent.setPhone(resultSet.getInt(3));
                abonents.add(abonent);
            }
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            close(statement);
            close(connection);
        }
        return abonents;
    }

    @Override
    public Abonent findEntityById(Long id) throws DaoException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Abonent abonent) throws DaoException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Long id) throws DaoException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Abonent abonent) throws DaoException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Abonent update(Abonent abonent) throws DaoException
    {
        throw new UnsupportedOperationException();
    }
}