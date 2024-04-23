package com.kaydunov.service;

import com.kaydunov.dao.ActorDao;
import com.kaydunov.dao.MovieDao;
import com.kaydunov.exception.DaoException;
import com.kaydunov.model.Actor;
import com.kaydunov.model.Movie;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoLibraryServiceImpl implements VideoLibraryService{
    private static final MovieDao movieDao = new MovieDao();
    private static final ActorDao actorDao = new ActorDao();

    @Override
    public List<Movie> getAllMoviesForThisAndLastYear(int year) throws SQLException, DaoException {
        return movieDao.getAllMoviesForThisAndLastYear(year);
    }

    @Override
    public List<Actor> getActorsByMovie(Movie movie) throws SQLException {
        return actorDao.getActorsByMovie(movie);
    }

    @Override
    public List<Actor> getActorsWhoAppearInNMoviesAndMore(int countOfMovies) throws SQLException {
        return actorDao.getActorsByCountOfMovieMoreThen(countOfMovies);
    }

    @Override
    public List<Actor> getActorsWhoHaveBeenDirected() throws SQLException {
        return actorDao.getActorsWhoHaveBeenDirected();
    }
}
