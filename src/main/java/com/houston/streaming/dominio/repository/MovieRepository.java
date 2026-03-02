package com.houston.streaming.dominio.repository;

import com.houston.streaming.dominio.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();

    MovieDto getByID(long id);

    MovieDto save(MovieDto movieDto);
}
