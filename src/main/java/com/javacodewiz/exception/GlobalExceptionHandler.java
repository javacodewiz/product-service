package com.javacodewiz.exception;


import com.javacodewiz.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(Exception exception, WebRequest request)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ErrorDTO.builder()
                        .apiPath(request.getDescription(false))
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message(exception.getMessage())
                        .timestamp(LocalDateTime.now()).build()
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorDTO.builder()
                        .apiPath(request.getDescription(false))
                        .status(HttpStatus.NOT_FOUND)
                        .message(exception.getMessage())
                        .timestamp(LocalDateTime.now()).build()
        );
    }
}
