package com.inditex.test.price.domain.dto.query;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetPriceQueryTest {

    @Test
    void test(){
        Integer brand = 1;
        Integer product = 888;
        LocalDateTime date = LocalDateTime.now().minusDays(10);

        GetPriceQuery query = new GetPriceQuery(brand, product, date);

        assertEquals(query.getBrandId(), brand);
        assertEquals(query.getProductId(), product);
        assertEquals(query.getDate(), date);
    }
}