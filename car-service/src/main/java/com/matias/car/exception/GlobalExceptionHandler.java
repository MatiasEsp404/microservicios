package com.matias.car.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matias.car.dto.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException e) {
    ErrorResponse response = buildErrorResponse(
        HttpStatus.NOT_FOUND,
        "Entity not found.",
        e.getMessage()
    );
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  private ErrorResponse buildErrorResponse(HttpStatus status, String message, String info) {
    return buildErrorResponse(status, message, List.of(info));
  }

  private ErrorResponse buildErrorResponse(HttpStatus status, String message, List<String> info) {
    return ErrorResponse.builder()
        .statusCode(status.value())
        .message(message)
        .moreInfo(info)
        .build();
  }

}
