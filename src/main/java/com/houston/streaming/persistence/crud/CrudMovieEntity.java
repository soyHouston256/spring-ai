package com.houston.streaming.persistence.crud;

import com.houston.streaming.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
    MovieEntity findFirstByTitulo(String titulo);
}
