package com.fragile.user_service.exception;

import com.fragile.user_service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends RuntimeException {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourcesNotFoundException ex){
      String message = ex.getMessage();
      ApiResponse response = ApiResponse
              .builder()
              .message(message)
              .status(HttpStatus.NOT_FOUND)
              .success(true)
              .build();
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND );
    }
}
