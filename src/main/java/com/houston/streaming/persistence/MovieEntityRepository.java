package com.houston.streaming.persistence;

import com.houston.streaming.dominio.dto.MovieDto;
import com.houston.streaming.dominio.dto.UpdateMovieDto;
import com.houston.streaming.dominio.repository.MovieRepository;
import com.houston.streaming.persistence.crud.CrudMovieEntity;
import com.houston.streaming.persistence.entity.MovieEntity;
import com.houston.streaming.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;

    }

    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    public MovieDto getByID(long id) {
        MovieEntity movieEntity =  this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setEstado("D");
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    public MovieDto update(long id, UpdateMovieDto movieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if (movieEntity == null) {
            return null;
        }
        movieEntity.setTitulo(movieDto.title());
        movieEntity.setFechaEstreno(movieDto.releaseDate());
        movieEntity.setClasificacion(movieDto.rating());

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    public void delete(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if (movieEntity == null) {
            throw new RuntimeException("Movie not found");
        }
        this.crudMovieEntity.delete(movieEntity);
    }
}
