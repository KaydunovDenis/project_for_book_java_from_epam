package com.kaydunov.dao;

import com.kaydunov.exception.DaoException;
import com.kaydunov.model.Director;
import com.kaydunov.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MovieDao {
    private static final String SQL_GET_ALL_MOVIES_FOR_THIS_AND_LAST_YEAR = """
            SELECT *
            FROM g13_2.movie
            WHERE YEAR(release_date) >= YEAR(?) - 1;""";

    private DirectorDao directorDao = new DirectorDao();

    public List<Movie> getAllMoviesForThisAndLastYear(int year) throws SQLException, DaoException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_MOVIES_FOR_THIS_AND_LAST_YEAR);
        Date date = new Date(year - 1900, 0, 1);
        preparedStatement.setDate(1, date);
        ResultSet resultSet = preparedStatement.executeQuery();
        return mapResultSetToMovies(resultSet);

    }

    private List<Movie> mapResultSetToMovies(ResultSet resultSet) throws SQLException, DaoException {
        List<Movie> movies = new ArrayList<>();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setName(resultSet.getString("name"));
                movie.setReleaseDate(resultSet.getDate("release_date"));
                movie.setReleaseCountry(resultSet.getString("release_country"));
                int directorId = resultSet.getInt("director_id");
                Director director = directorDao.findById(directorId);
                movie.setDirector(director);
                movies.add(movie);
            }
        return movies;
    }


}
