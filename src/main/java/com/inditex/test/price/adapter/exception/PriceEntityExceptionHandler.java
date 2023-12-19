package com.inditex.test.price.adapter.exception;

import com.inditex.test.price.domain.dto.ApiError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manejador de excepciones global
 */
@ControllerAdvice
public class PriceEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler ( PriceNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(PriceNotFoundException ex) {

        ApiError err = new ApiError(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now(ZoneId.of("UTC")), Collections.emptyList());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(HttpStatus.BAD_REQUEST.value(),
                "Validation Errors",
                LocalDateTime.now(ZoneId.of("UTC")),
                details);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Type Mismatch",
                LocalDateTime.now(ZoneId.of("UTC")),
                details);

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
