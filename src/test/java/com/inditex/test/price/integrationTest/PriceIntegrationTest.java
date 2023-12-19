package com.inditex.test.price.integrationTest;

import com.inditex.test.price.domain.dto.GetPriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @ParameterizedTest
    @MethodSource
    public void testFindPriceList(Integer brand, Integer product, LocalDateTime date, GetPriceResponse expectedPrice) {
        this.webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/price")
                                .queryParam("brandId", brand)
                                .queryParam("productId", product)
                                .queryParam("date", date)
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(GetPriceResponse.class)
                .consumeWith(r -> {
                    assertEquals(expectedPrice, r.getResponseBody());
                });
    }

    static Stream<Arguments> testFindPriceList() {
        Integer brand = 1;
        Integer product = 35455;
        return Stream.of(
                //Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
                Arguments.of(brand, product, LocalDateTime.of(2020, 6, 14, 10, 0, 0),
                        new GetPriceResponse(brand, product, 1, LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                                LocalDateTime.of(2020, 12, 31, 23, 59, 59), 35.5)),

                // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
                Arguments.of(brand, product, LocalDateTime.of(2020, 6, 14, 16, 0, 0),
                        new GetPriceResponse(brand, product, 2, LocalDateTime.of(2020, 6, 14, 15, 0, 0),
                                LocalDateTime.of(2020, 6, 14, 18, 30, 0), 25.45)),

                //Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
                Arguments.of(brand, product, LocalDateTime.of(2020, 6, 14, 21, 0, 0),
                        new GetPriceResponse(brand, product, 1, LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                                LocalDateTime.of(2020, 12, 31, 23, 59, 59), 35.5)),

                //Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
                Arguments.of(brand, product, LocalDateTime.of(2020, 6, 15, 10, 0, 0),
                        new GetPriceResponse(brand, product, 3, LocalDateTime.of(2020, 6, 15, 0, 0, 0),
                                LocalDateTime.of(2020, 6, 15, 11, 0, 0), 30.5)),

                //Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
                Arguments.of(brand, product, LocalDateTime.of(2020, 6, 16, 21, 0, 0),
                        new GetPriceResponse(brand, product, 4, LocalDateTime.of(2020, 6, 15, 16, 0, 0),
                                LocalDateTime.of(2020, 12, 31, 23, 59, 59), 38.95)));
    }

    @Test
    public void testPriceNotFound() {
        this.webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/price")
                                .queryParam("brandId", 8)
                                .queryParam("productId", 56)
                                .queryParam("date", LocalDateTime.now())
                                .build())
                .exchange()
                .expectStatus().isNotFound();
    }
}