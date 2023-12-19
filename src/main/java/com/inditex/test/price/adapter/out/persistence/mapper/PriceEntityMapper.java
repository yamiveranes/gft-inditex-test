package com.inditex.test.price.adapter.out.persistence.mapper;

import com.inditex.test.price.adapter.out.persistence.entity.PriceEntity;
import com.inditex.test.price.domain.model.Price;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Price priceEntityToPrice(PriceEntity priceEntity);
}
