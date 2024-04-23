package com.kaydunov.mapper;

import com.kaydunov.model.Movie;
import org.mapstruct.Mapper;

import javax.annotation.processing.Generated;
import java.sql.ResultSet;

@Generated(value = "")
@Mapper
public interface MovieMapper {
    Movie resultSetToMovie(ResultSet resultSet);
}
