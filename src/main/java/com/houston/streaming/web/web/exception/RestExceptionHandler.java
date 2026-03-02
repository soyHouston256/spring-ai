package com.houston.streaming.web.web.exception;

import com.houston.streaming.dominio.execption.MovieAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistException ex){
           Error error = new Error("movie-already-exist" , ex.getMessage());
           return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex){
        List<Error> errors = new ArrayList<>();
         ex.getBindingResult().getFieldErrors().forEach(error -> {
             String fieldName = error.getObjectName();
             String errorMessage = error.getDefaultMessage();
             errors.add(new Error(fieldName, errorMessage));
         });
        return ResponseEntity.badRequest().body(errors);
    }
}
