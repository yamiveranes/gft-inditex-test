package com.inditex.test.price.domain.port.in;

import com.inditex.test.price.domain.dto.GetPriceResponse;
import com.inditex.test.price.domain.dto.query.GetPriceQuery;

/**
 * Interfaz que define el manejador de obtención de tarifas de precios
 */
public interface IGetPriceHandler {

    /**
     * Obtiene la tarifa de precios a aplicar
     * @param query datos de consulta
     * @return tarifa de precios a aplicar
     */
    GetPriceResponse handle(GetPriceQuery query);
}
