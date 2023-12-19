package com.inditex.test.price.adapter.out.persistence.jpa.repository;

import com.inditex.test.price.adapter.exception.PriceNotFoundException;
import com.inditex.test.price.adapter.out.persistence.entity.PriceEntity;
import com.inditex.test.price.adapter.out.persistence.jpa.IPriceJpaRepository;
import com.inditex.test.price.adapter.out.persistence.mapper.PriceEntityMapper;
import com.inditex.test.price.domain.model.Price;
import com.inditex.test.price.domain.port.out.IPriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Pruebas unitarias de la clase PriceH2Repository
 */
@ExtendWith({MockitoExtension.class})
class PriceH2RepositoryTest {
    @Mock
    private IPriceJpaRepository jpaRepository;

    private IPriceRepository repository;

    @BeforeEach
    void setUp() {
        PriceEntityMapper mapper = Mappers.getMapper(PriceEntityMapper.class);
        repository = new PriceH2Repository(jpaRepository, mapper);
    }

    @Test
    void find() {
        Long id = 65L;
        Integer brand = 1;
        Integer product = 888;
        Integer priceList = 1;
        Integer priority = 10;
        Double finalPrice = 25.5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now().plusDays(5);
        Currency currency = Currency.getInstance("EUR");

        PriceEntity priceResult = new PriceEntity(id, brand, startDate, endDate, priceList, product, priority, finalPrice, currency);

        when(jpaRepository.findPrice( any(), any(), any()))
                .thenReturn(Optional.of(priceResult));

        Price price = repository.find(brand, product, startDate);

        assertEquals(id, price.getId());
        assertEquals(brand, price.getBrandId());
        assertEquals(product, price.getProductId());
        assertEquals(priceList, price.getPriceList());
        assertEquals(startDate, price.getStartDate());
        assertEquals(endDate, price.getEndDate());
        assertEquals(finalPrice, price.getPrice());
        assertEquals(priority, price.getPriority());
        assertEquals(currency, price.getCurrency());
    }

    @Test
    void findNotFound() {

        Integer brand = 1;
        Integer product = 888;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);

        when(jpaRepository.findPrice( any(), any(), any()))
                .thenReturn(Optional.empty());

        Exception exception = assertThrows(PriceNotFoundException.class, () -> repository.find(brand, product, startDate));

        String expectedMessage = "Price not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}