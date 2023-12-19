package com.inditex.test.price.domain.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GetPriceResponseTest {

    @Test
    void testPriceNoArgs() {
        Integer brand = 1;
        Integer product = 888;
        Integer priceList = 1;
        Double final_price = 25.5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now().plusDays(5);

        GetPriceResponse price = new GetPriceResponse(brand, product, priceList, startDate, endDate, final_price);

        assertEquals(price.getBrandId(), brand);
        assertEquals(price.getProductId(), product);
        assertEquals(price.getPriceList(), priceList);
        assertEquals(price.getStartDate(), startDate);
        assertEquals(price.getEndDate(), endDate);
        assertEquals(price.getPrice(), final_price);
    }

    @Test
    void testEqual() {
        Integer brand = 1;
        Integer product = 888;
        Integer priceList = 1;
        Double final_price = 25.5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now().plusDays(5);

        GetPriceResponse price = new GetPriceResponse(brand, product, priceList, startDate, endDate, final_price);

        GetPriceResponse anotherPrice = new GetPriceResponse(brand, product, priceList, startDate, endDate, final_price);

        assertEquals(price, anotherPrice);
    }

    @Test
    void testNotEqual() {
        Integer brand = 1;
        Integer product = 888;
        Integer priceList = 1;
        Double final_price = 25.5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now().plusDays(5);

        GetPriceResponse price = new GetPriceResponse(brand, product, priceList, startDate, endDate, final_price);

        GetPriceResponse anotherPrice = new GetPriceResponse(2, product, priceList, startDate, endDate, final_price);


        assertNotEquals(price, anotherPrice);
        assertNotEquals(price,null);
    }

}