package com.inditex.test.price.application.query;

import com.inditex.test.price.application.mapper.PriceDtoMapper;
import com.inditex.test.price.domain.dto.GetPriceResponse;
import com.inditex.test.price.domain.dto.query.GetPriceQuery;
import com.inditex.test.price.domain.model.Price;
import com.inditex.test.price.domain.port.in.IGetPriceHandler;
import com.inditex.test.price.domain.port.out.IPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Manejador de obtención de tarifas de precios
 */
@Component
@AllArgsConstructor
public class GetPriceHandler implements IGetPriceHandler {
    private final IPriceRepository repository;
    private final PriceDtoMapper mapper;

    public GetPriceResponse handle(GetPriceQuery query) {
        Price price = repository.find(query.getBrandId(), query.getProductId(), query.getDate());

        return mapper.priceToPriceResponse(price);
    }
}
