package com.example.bootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice informs Spring to handle/intercept an entity exception
@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    // @ExceptionHandler informs what class throws an exception
  @ExceptionHandler(BusinessException.class)
  protected ResponseEntity<ExceptionResponse> handlerSecurity(BusinessException e) {
    // when intercepted it will return a JSON with HTTP 422 error code and a Body with the exception message
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
  }

  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<ExceptionResponse> handlerSecurity(NotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
  }
}
