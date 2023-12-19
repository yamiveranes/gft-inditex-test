package com.inditex.test.price.adapter.out.persistence.jpa;

import com.inditex.test.price.adapter.out.persistence.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario de la clase IPriceQueryJpaRepository
 */
@SpringBootTest
class IPriceJpaRepositoryTest {
    @Autowired
    IPriceJpaRepository repository;

    @Test
    void testExistsListPrice() {
        Integer brand = 1;
        Integer product = 35455;

        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        Optional<PriceEntity> optionalPrice = repository.findPrice(brand, product, date);

        assertTrue(optionalPrice.isPresent());

        PriceEntity price = optionalPrice.get();

        assertEquals(price.getBrandId(), brand);
        assertEquals(price.getProductId(), product);
        assertTrue(price.getStartDate().isBefore(date) || price.getStartDate().isEqual(date));
        assertTrue(price.getEndDate().isAfter(date) || price.getEndDate().isEqual(date));
        assertEquals(price.getPriority(), 0);
    }

    @Test
    void testNotExistsListPrice() {
        Integer brand = 5;
        Integer product = 35455;

        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 20, 0, 0);
        Optional<PriceEntity> price = repository.findPrice(brand, product, date);

        assertFalse(price.isPresent());
    }

    @Test
    void testPriorityListPrice() {
        Integer brand = 1;
        Integer product = 35455;

        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 10, 0, 0);
        Optional<PriceEntity> optionalPrice = repository.findPrice(brand, product, date);

        assertTrue(optionalPrice.isPresent());

        PriceEntity price = optionalPrice.get();

        assertEquals(price.getBrandId(), 1);
        assertEquals(price.getProductId(), 35455);
        assertTrue(price.getStartDate().isBefore(date) || price.getStartDate().isEqual(date));
        assertTrue(price.getEndDate().isAfter(date) || price.getEndDate().isEqual(date));
        assertEquals(price.getPriority(), 1);
    }
}