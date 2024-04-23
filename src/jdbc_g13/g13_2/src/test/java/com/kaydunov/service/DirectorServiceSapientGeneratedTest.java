package com.kaydunov.service;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import com.kaydunov.exception.DaoException;
import com.kaydunov.model.Director;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Disabled;

@Timeout(value = 5)
class DirectorServiceSapientGeneratedTest {

    @Test()
    void findById() throws SQLException, DaoException {
        //Arrange Statement(s)
        DirectorService target = new DirectorService();
        //Act Statement(s)
        Director result = target.findById(1);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(notNullValue())));
    }
}
