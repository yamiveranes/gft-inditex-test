package com.inditex.test.price.adapter.out.persistence.jpa.repository;

import com.inditex.test.price.adapter.exception.PriceNotFoundException;
import com.inditex.test.price.adapter.out.persistence.entity.PriceEntity;
import com.inditex.test.price.adapter.out.persistence.jpa.IPriceJpaRepository;
import com.inditex.test.price.adapter.out.persistence.mapper.PriceEntityMapper;
import com.inditex.test.price.domain.model.Price;

import com.inditex.test.price.domain.port.out.IPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PriceH2Repository implements IPriceRepository {
    private final IPriceJpaRepository repository;
    private final PriceEntityMapper mapper;

    @Override
    public Price find(Integer brandId, Integer productId, LocalDateTime date) {
        Optional<PriceEntity> entity = repository.findPrice(brandId, productId, date);

        PriceEntity priceEntity = entity.orElseThrow(() -> new PriceNotFoundException("Price not found"));

        return mapper.priceEntityToPrice(priceEntity);
    }
}
