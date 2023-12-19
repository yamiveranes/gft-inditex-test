package com.inditex.test.price.domain.port.out;


import com.inditex.test.price.domain.model.Price;

import java.time.LocalDateTime;

public interface IPriceRepository {
    /**
     * Repositorio depende del modelo de dominio
     * @param brandId Identificador de la marca
     * @param productId Identificador del producto
     * @param date Fecha
     * @return Tarifa de precios a aplicar
     */
    Price find(Integer brandId, Integer productId, LocalDateTime date);
}
