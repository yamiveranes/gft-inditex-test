package com.inditex.test.price.adapter.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PriceNotFoundExceptionTest {

    @Test
    public void test() {
        PriceNotFoundException exception = new PriceNotFoundException("Price not found");
        assertEquals(exception.getMessage(), "Price not found");
    }
}