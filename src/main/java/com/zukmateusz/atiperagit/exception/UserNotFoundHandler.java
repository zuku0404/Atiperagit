package com.zukmateusz.atiperagit.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class UserNotFoundHandler extends RuntimeException{
    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<Object> handleUserNotFoundRequestException(HttpClientErrorException e){
        HttpStatus notFoundRequest = HttpStatus.NOT_FOUND;
        UserNotExistException exception = new UserNotExistException(
                notFoundRequest.value(),
                e.getMessage()
        );
        return new ResponseEntity(exception,notFoundRequest);
    }
}
