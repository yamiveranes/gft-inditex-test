package com.inditex.test.price.domain.model;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias de la clase price
 */
class PriceTest {

    @Test
    void test(){

        Long id = 65l;
        Integer brand = 1;
        Integer product = 888;
        Integer priceList = 1;
        Integer priority = 10;
        Double final_price = 25.5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now().plusDays(5);
        Currency currency = Currency.getInstance("EUR");

        Price price = new Price(id, brand, startDate, endDate, priceList, product, priority, final_price, currency);

        assertEquals(price.getId(), id);
        assertEquals(price.getBrandId(), brand);
        assertEquals(price.getProductId(), product);
        assertEquals(price.getPriceList(), priceList);
        assertEquals(price.getPriority(), priority);
        assertEquals(price.getStartDate(), startDate);
        assertEquals(price.getEndDate(), endDate);
        assertEquals(price.getPrice(), final_price);
        assertEquals(price.getCurrency(), currency);
    }
}