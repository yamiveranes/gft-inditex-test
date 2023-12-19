package com.inditex.test.price.application.mapper;


import com.inditex.test.price.domain.dto.GetPriceResponse;
import com.inditex.test.price.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper  {
    GetPriceResponse priceToPriceResponse(Price price);
}
