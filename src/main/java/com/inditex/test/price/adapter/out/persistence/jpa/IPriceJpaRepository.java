package com.inditex.test.price.adapter.out.persistence.jpa;


import com.inditex.test.price.adapter.out.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * Repositorio de la entidad PriceEntity
 */
public interface IPriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Obtien el precio final  y la tarifa que aplica a un producto de una cadena
     * @param brand identificador de la cadena
     * @param product identificador del producto
     * @param date fecha de aplicación
     * @return
     */
    @Query(value = "select * FROM prices p where p.brand_id = ?1 and p.product_id = ?2 and p.start_date <= ?3 and " +
            "p.end_date >= ?3 order by p.priority desc limit 1 ", nativeQuery = true)
    Optional<PriceEntity> findPrice( Integer brand, Integer product, LocalDateTime date);

}

