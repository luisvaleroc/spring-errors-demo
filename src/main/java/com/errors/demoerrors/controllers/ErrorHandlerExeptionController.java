package com.errors.demoerrors.controllers;


import com.errors.demoerrors.exeptions.UserNotFoundExeption;
import com.errors.demoerrors.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandlerExeptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception ex){

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por zero");
        error.setMesagge(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public  ResponseEntity<Error> notFountEx(NoHandlerFoundException ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMesagge(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
    //public Map<String, String> NumberFormatException(Exception ex){
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> NumberFormatException(Exception ex){
        Map<String, Object> error = new HashMap<>();
       // error.put("date", new Date().toString());
        error.put("date", new Date());
        error.put("error", "no es un numero valido");
        error.put("message", ex.getMessage());
        //error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;

    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundExeption.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userFormatException(Exception ex){
        Map<String, Object> error = new HashMap<>();
        // error.put("date", new Date().toString());
        error.put("date", new Date());
        error.put("error", "Usuario o rol no existe");
        error.put("message", ex.getMessage());
        //error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;

    }

}
