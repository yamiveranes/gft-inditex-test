package com.inditex.test.price.adapter.exception;

/**
 * Excepción generada si no existe una tarifa de precio
 */
public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException(String message) {
        super(message);
    }
}
