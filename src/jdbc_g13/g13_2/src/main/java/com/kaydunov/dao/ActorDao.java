package com.kaydunov.dao;

import com.kaydunov.model.Actor;
import com.kaydunov.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ActorDao {

    private static final String SQL_FIND_ACTORS_BY_MOVIE = """
            SELECT * FROM G13_2.actor 
            WHERE id IN (SELECT ACTOR_ID FROM G13_2.movie_actor WHERE MOVIE_ID = ?);
            """;

    private static final String SQL_FIND_ACTORS_BY_COUNT_OF_MOVIE = """
           SELECT * FROM G13_2.actor
           WHERE ID IN (
               SELECT ACTOR_ID FROM G13_2.MOVIE_ACTOR
               GROUP BY ACTOR_ID
               HAVING count(MOVIE_ID) >= ?);
            """;

    private static final String SQL_FIND_ACTORS_WHO_HAS_BEEN_DIRECTOR = """
            SELECT DISTINCT ACTOR.*
            FROM G13_2.ACTOR ACTOR
                     INNER JOIN G13_2.DIRECTOR DIRECTOR
                                ON ACTOR.NAME = DIRECTOR.NAME
                                    AND ACTOR.DATE_OF_BIRTH = DIRECTOR.DATE_OF_BIRTH
                     INNER JOIN G13_2.MOVIE MOVIE
                                ON DIRECTOR.ID = MOVIE.DIRECTOR_ID;
            """;

    public List<Actor> getActorsByMovie(Movie movie) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        ResultSet resultSet;
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_ACTORS_BY_MOVIE)) {
            statement.setInt(1, movie.getId());
            resultSet = statement.executeQuery();
        }
        return mapResultSetToActors(resultSet);
    }

    public List<Actor> getActorsByCountOfMovieMoreThen(Integer count) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        ResultSet resultSet;
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_ACTORS_BY_COUNT_OF_MOVIE)) {
            statement.setInt(1, count);
            resultSet = statement.executeQuery();
        }
        return mapResultSetToActors(resultSet);
    }

    public List<Actor> getActorsWhoHaveBeenDirected() throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        ResultSet resultSet;
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_ACTORS_WHO_HAS_BEEN_DIRECTOR)) {
            resultSet = statement.executeQuery();
        }
        return mapResultSetToActors(resultSet);
    }

    private List<Actor> mapResultSetToActors(ResultSet resultSet) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        while (resultSet.next()) {
            Actor actor = new Actor();
            actor.setId(resultSet.getInt("id"));
            actor.setName(resultSet.getString("name"));
            actor.setDateOfBirth(resultSet.getDate("date_Of_Birth"));
            actors.add(actor);
        }
        return actors;
    }
}
