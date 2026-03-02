package com.houston.streaming.dominio.service;

import com.houston.streaming.dominio.dto.MovieDto;
import com.houston.streaming.dominio.dto.UpdateMovieDto;
import com.houston.streaming.dominio.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Search Movies")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getByID(id);
    }

    public MovieDto add(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto movieDto) {
        return this.movieRepository.update(id, movieDto);
    }

    public void delete(long id) {
        this.movieRepository.delete(id);
    }
}
