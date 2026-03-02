package com.houston.streaming.dominio.repository;

import com.houston.streaming.dominio.dto.MovieDto;
import com.houston.streaming.dominio.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();

    MovieDto getByID(long id);

    MovieDto save(MovieDto movieDto);

    MovieDto  update(long id, UpdateMovieDto movieDto);

    void delete(long id);
}
