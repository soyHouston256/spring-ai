package com.houston.streaming.dominio.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(
        @NotNull
        @NotEmpty
        @NotBlank(message = "Title cannot be blank")
        String title,

        @PastOrPresent(message = "the is incorrect")
        LocalDate releaseDate,

        @Max(value = 5, message = "The rating must be between 0 and 5")
        @Min(value = 0, message = "The rating must be between 0 and 0")
        BigDecimal rating
) {
}