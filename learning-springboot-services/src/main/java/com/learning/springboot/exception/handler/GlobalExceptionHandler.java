package com.learning.springboot.exception.handler;

import com.learning.springboot.model.handler.ExceptionResponse;
import com.learning.springboot.model.handler.NoContentException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by krvh271 on 12/24/17.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    ExceptionResponse exceptionResponse;

    @ExceptionHandler({ NoContentException.class })
    public ResponseEntity<ExceptionResponse> handleConstraintViolation(
            NoContentException ex, WebRequest webRequest) {
        exceptionResponse.setHappendedAt(new Date(System.currentTimeMillis()));
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setDescription(webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        exceptionResponse.setHappendedAt(new Date(System.currentTimeMillis()));
        exceptionResponse.setMessage("Validation Failed for Argument passed");
        exceptionResponse.setDescription(ex.getBindingResult().toString());
        return new ResponseEntity<>(exceptionResponse,new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }
}
