package com.inditex.test.price.adapter.in.rest;


import com.inditex.test.price.application.query.GetPriceHandler;
import com.inditex.test.price.domain.dto.GetPriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PriceControllerTest {
    @Mock
    private GetPriceHandler handler;

    private PriceController controller;

    @BeforeEach
    void setUp() {
        controller = new PriceController(handler);
    }

    @Test
    void findPrice() {
        Integer brand = 1;
        Integer product = 34;
        Integer priceList = 1;
        Double finalPrice = 25.5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now().plusDays(5);

        when(handler.handle(any())).thenReturn(new GetPriceResponse(brand, product, priceList, startDate, endDate, finalPrice));

        ResponseEntity<GetPriceResponse> price = controller.findPrice(brand, product, startDate);
        assertEquals(price.getStatusCode(), HttpStatus.OK);
    }
}