package com.inditex.test.price.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Currency;

/**
 * Clase que reprsenta una tarifa de precio
 */
@Builder
@Getter
@AllArgsConstructor
public class Price implements Serializable {
    /**
     * Identificador
     */
    private final Long id;
    /**
     * Identificador de la cadena
     */
    private final Integer brandId;
    /**
     * Fecha a partir de la cual se aplica el precio tarifa
     */
    private final LocalDateTime startDate;
    /**
     * Fecha hasta la que se aplica el precio tarifa
     */
    private final LocalDateTime endDate;
    /**
     * Identificador de la tarifa de precios
     */
    private final Integer priceList;
    /**
     * Identificador del producto
     */
    private final Integer productId;
    /**
     * Prioridad de la tarifa de precios
     */
    private final Integer priority;
    /**
     * Precio del producto
     */
    private final Double price;
    /**
     * ISO de la moneda
     */
    private final Currency currency;

}
