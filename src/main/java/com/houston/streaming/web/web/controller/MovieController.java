package com.houston.streaming.web.web.controller;

import com.houston.streaming.dominio.dto.MovieDto;
import com.houston.streaming.dominio.dto.SuggestRequestMovieDto;
import com.houston.streaming.dominio.dto.UpdateMovieDto;
import com.houston.streaming.dominio.service.MovieService;
import com.houston.streaming.dominio.service.StreamAiService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;
    private final StreamAiService streamAiService;
    public MovieController(MovieService movieService,  StreamAiService streamAiService) {
        this.movieService = movieService;
        this.streamAiService = streamAiService;
    }

    @GetMapping("/movie")
    public ResponseEntity<List<MovieDto>> getMovies() {
        List<MovieDto> movies = this.movieService.getAll();
        if (movies == null || movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if(movieDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        MovieDto movie = this.movieService.add(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> recommendation(@RequestBody SuggestRequestMovieDto suggestRequestMovieDto) {
        return ResponseEntity.ok(this.streamAiService.generateMovieRecommendation(suggestRequestMovieDto.userPreferences()));
    }


    @PutMapping("/movie/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto movieDto) {
       return ResponseEntity.ok(this.movieService.update(id, movieDto));
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
