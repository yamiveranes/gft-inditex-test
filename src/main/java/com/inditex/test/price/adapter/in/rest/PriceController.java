package com.inditex.test.price.adapter.in.rest;


import com.inditex.test.price.adapter.rest.PriceApi;
import com.inditex.test.price.domain.dto.GetPriceResponse;
import com.inditex.test.price.domain.dto.query.GetPriceQuery;
import com.inditex.test.price.domain.port.in.IGetPriceHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@Validated
public class PriceController implements PriceApi {
    private final IGetPriceHandler handler;

    @Override
    public ResponseEntity<GetPriceResponse> findPrice(Integer brandId, Integer productId, LocalDateTime date) {
        GetPriceResponse response = handler.handle(new GetPriceQuery(brandId, productId, date));

        return ResponseEntity.ok(response);
    }
}
