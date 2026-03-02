package com.houston.streaming.dominio.execption;

public class MovieAlreadyExistException extends RuntimeException{
        public MovieAlreadyExistException(String title) {
            super("la pelicula con el titulo " + title + " ya existe en la base de datos");
        }
}
