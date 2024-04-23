package com.kaydunov.service;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import com.kaydunov.exception.DaoException;

import java.util.List;

import com.kaydunov.model.Movie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Disabled;
import com.kaydunov.model.Actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@Timeout(value = 5)
class VideoLibraryServiceImplSapientGeneratedTest {

    @Test()
    void getAllMoviesForThisAndLastYearTest() throws SQLException, DaoException {

        //Arrange Statement(s)
        VideoLibraryServiceImpl target = new VideoLibraryServiceImpl();
        //Act Statement(s)
        List<Movie> result = target.getAllMoviesForThisAndLastYear(0);
        //Assert statement(s)
        assertEquals(6, result.size());
    }

    @Test()
    void getActorsByMovieTest() throws SQLException {
        //Arrange Statement(s)
        VideoLibraryServiceImpl target = new VideoLibraryServiceImpl();
        Movie movie = new Movie();
        movie.setId(1);
        //Act Statement(s)
        List<Actor> result = target.getActorsByMovie(movie);
        //Assert statement(s)
        assertEquals(2, result.size());
    }

    @Test()
    void getActorsWhoAppearInNMoviesAndMoreTest() throws SQLException {
        //Arrange Statement(s)
        VideoLibraryServiceImpl target = new VideoLibraryServiceImpl();
        //Act Statement(s)
        List<Actor> result = target.getActorsWhoAppearInNMoviesAndMore(2);
        //Assert statement(s)
        assertEquals(3, result.size());
    }

    @Test()
    void getActorsWhoHaveBeenDirectedTest() throws SQLException {
        //Arrange Statement(s)
        VideoLibraryServiceImpl target = new VideoLibraryServiceImpl();
        //Act Statement(s)
        List<Actor> result = target.getActorsWhoHaveBeenDirected();
        //Assert statement(s)
        assertAll("result", () -> assertThat(result.size(), equalTo(4)));
    }
}
