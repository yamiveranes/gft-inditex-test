package com.inditex.test.price.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Currency;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prices")
public class PriceEntity implements Serializable {
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * Identificador de la cadena
     */
    @Column(name = "brand_id", nullable = false)
    private Integer brandId;

    /**
     * Fecha a partir de la cual se aplica el precio tarifa
     */
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    /**
     * Fecha hasta la que se aplica el precio tarifa
     */
    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    /**
     * Identificador de la tarifa de precios
     */
    @Column(name = "price_list", nullable = false)
    private Integer priceList;

    /**
     * Identificador del producto
     */
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    /**
     * Prioridad de la tarifa de precios
     */
    @Column(name = "priority", nullable = false)
    private Integer priority;

    /**
     * Precio del producto
     */
    @Column(name = "price", nullable = false)
    private Double price;

    /**
     * ISO de la moneda
     */
    @Column(name = "curr", nullable = false)
    private Currency currency;
}
