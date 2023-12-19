package com.inditex.test.price.application.query;

import com.inditex.test.price.application.mapper.PriceDtoMapper;
import com.inditex.test.price.domain.dto.GetPriceResponse;
import com.inditex.test.price.domain.dto.query.GetPriceQuery;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPriceHandlerTest {
    @Mock
    private IPriceRepository repository;
    private PriceDtoMapper mapper;
    private GetPriceHandler handler;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(PriceDtoMapper.class);
        handler = new GetPriceHandler(repository, mapper);
    }

    @Test
    void testHandle() {
        Long id = 65l;
        Integer brand = 1;
        Integer product = 888;
        Integer priceList = 1;
        Integer priority = 10;
        Double finalPrice = 25.5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now().plusDays(5);
        Currency currency = Currency.getInstance("EUR");

        Price price = new Price(id, brand, startDate, endDate, priceList, product, priority, finalPrice, currency);

        when(repository.find(any(), any(), any())).thenReturn(price);
        GetPriceResponse priceResponse = handler.handle(new GetPriceQuery(brand, product, startDate));

        assertEquals(priceResponse.getBrandId(), brand);
        assertEquals(priceResponse.getProductId(), product);
        assertEquals(priceResponse.getPriceList(), priceList);
        assertEquals(priceResponse.getStartDate(), startDate);
        assertEquals(priceResponse.getEndDate(), endDate);
        assertEquals(priceResponse.getPrice(), finalPrice);

    }
}