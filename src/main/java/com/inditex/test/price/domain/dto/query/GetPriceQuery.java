package com.inditex.test.price.domain.dto.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Representa la consulta de tarifa de precios
 */
@AllArgsConstructor
@Getter
public class GetPriceQuery {
    /**
     * Identificador de la marca
     */
    private final Integer brandId;
    /**
     * Identificador del producto
     */
    private final Integer productId;
    /**
     * Fecha de aplicación
     */
    private final LocalDateTime date;
}
