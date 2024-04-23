package com.kaydunov.service;

import com.kaydunov.exception.DaoException;
import com.kaydunov.model.Actor;
import com.kaydunov.model.Movie;

import java.sql.SQLException;
import java.util.List;

public interface VideoLibraryService {
    /**
     * 1 Find all movies released on the screen this year and last year.
     */
    List<Movie> getAllMoviesForThisAndLastYear(int year) throws SQLException, DaoException;

    /**
     * 2 Extract information about the actors who acted in the given film.
     */
    List<Actor> getActorsByMovie(Movie movie) throws SQLException;

/** 3 Extract information about actors who have appeared in at least N films.*/
    List<Actor> getActorsWhoAppearInNMoviesAndMore(int countOfMovies) throws SQLException;

/** 4 Extract information about actors who have been directed at least od-
 from movies.*/
    List<Actor> getActorsWhoHaveBeenDirected() throws SQLException;
}
