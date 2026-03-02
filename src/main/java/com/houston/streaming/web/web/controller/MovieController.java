package com.houston.streaming.web.web.controller;

import com.houston.streaming.dominio.dto.MovieDto;
import com.houston.streaming.dominio.service.MovieService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MovieDto>> getMovies() {
        List<MovieDto> movieDtos = this.movieService.getAll();
        if (movieDtos == null || movieDtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDtos);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if(movieDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }
}
