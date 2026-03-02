package com.houston.streaming.dominio.dto;

import com.houston.streaming.dominio.Genre;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating
) {
}