package com.houston.streaming.web.web.controller;

import com.houston.streaming.dominio.dto.MovieDto;
import com.houston.streaming.dominio.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<MovieDto> getMovies() {
        return this.movieService.getAll();
    }

    @GetMapping("/movie/{id}")
    public MovieDto getMovie(@PathVariable long id) {
        return this.movieService.getById(id);
    }
}
