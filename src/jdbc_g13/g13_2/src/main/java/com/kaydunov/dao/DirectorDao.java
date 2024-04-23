package com.kaydunov.dao;

import com.kaydunov.model.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kaydunov.dao.ConnectionManager.getConnectionManager;

public class DirectorDao  {
    private static final String SQL_FIND_BY_ID = "SELECT * FROM G13_2.director WHERE ID = ?";


    public Director findById(Integer id) throws SQLException {
        Connection connection = getConnectionManager().getConnection();
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        }
        return mapResultSetToDirector(resultSet);
    }

    private Director mapResultSetToDirector(ResultSet resultSet) throws SQLException {
        Director director = new Director();
        if(resultSet.next()) {
            director.setId(resultSet.getInt("id"));
            director.setName(resultSet.getString("name"));
            director.setDateOfBirth(resultSet.getDate("date_of_birth"));
        }
        return director;
    }
}
