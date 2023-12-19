package com.inditex.test.price.adapter.exception;

import com.inditex.test.price.domain.dto.ApiError;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Pruebas unitarias de la clase PriceEntityExceptionHandler
 */
class PriceEntityExceptionHandlerTest {

    final PriceEntityExceptionHandler handler = new  PriceEntityExceptionHandler();

    @Test
    void testPriceNotFound() {
        final String message = "Price not found";
        final ResponseEntity<Object> handled = handler.handleNotFound(new PriceNotFoundException(message));

        assertEquals(HttpStatus.NOT_FOUND, handled.getStatusCode());
        assertTrue(handled.getBody() instanceof ApiError);

        ApiError err = (ApiError) handled.getBody();

        assertEquals(HttpStatus.NOT_FOUND.value(), err.getStatus());
        assertEquals(message, err.getMessage());
    }

    @Test
    void testContraintViolation() {
        final String message = "Validation Errors";
        final String detail = "FindPrice.product: must be greater than or equal to 1";

        ConstraintViolationException exception = mock(ConstraintViolationException.class);
        when(exception.getMessage()).thenReturn(detail);
        final ResponseEntity<Object> handled = handler.handleConstraintViolationException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, handled.getStatusCode());
        assertTrue(handled.getBody() instanceof ApiError);

        ApiError err = (ApiError) handled.getBody();

        assertEquals(HttpStatus.BAD_REQUEST.value(), err.getStatus());
        assertEquals(message, err.getMessage());
        assertEquals(detail, err.getDetails().get(0));
    }

    @Test
    void testMethodArgumentTypeMismatch() {
        final String message = "Type Mismatch";
        final String detail = "Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'";

        MethodArgumentTypeMismatchException exception = mock(MethodArgumentTypeMismatchException.class);
        when(exception.getMessage()).thenReturn(detail);
        final ResponseEntity<Object> handled = handler.handleMethodArgumentTypeMismatch(exception);

        assertEquals(HttpStatus.BAD_REQUEST, handled.getStatusCode());
        assertTrue(handled.getBody() instanceof ApiError);

        ApiError err = (ApiError) handled.getBody();

        assertEquals(HttpStatus.BAD_REQUEST.value(), err.getStatus());
        assertEquals(message, err.getMessage());
        assertEquals(detail, err.getDetails().get(0));
    }
}