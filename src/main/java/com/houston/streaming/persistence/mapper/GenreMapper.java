package com.houston.streaming.persistence.mapper;

import com.houston.streaming.dominio.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named( "stringToGenre")
    public static Genre stringToGenre(String genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Genre cannot be null");
        }

        return switch (genre.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "DRAMA" -> Genre.DRAMA;
            case "CIENCIA_FICCION" -> Genre.SCIENCE_FICTION;
            case "ANIMADA" -> Genre.ANIMATION;
            case "TERROR" -> Genre.HORROR;
            default -> throw new IllegalArgumentException("Unknown genre: " + genre);
        };
    }

    @Named( "genreToString")
    public static String genreToString(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Genre cannot be null");
        }

        return switch (genre) {
            case ACTION -> "ACCION";
            case DRAMA -> "DRAMA";
            case HORROR -> "TERROR";
            case SCIENCE_FICTION -> "CIENCIA_FICCION";
            case ANIMATION -> "ANIMADA";
            default -> throw new IllegalStateException("Unexpected value: " + genre);
        };
    }
}
