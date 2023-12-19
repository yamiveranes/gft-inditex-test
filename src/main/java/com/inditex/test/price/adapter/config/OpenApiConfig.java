package com.inditex.test.price.adapter.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@OpenAPI31
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Inditex Test API")
                        .description("")
                        .termsOfService("terms")
                        .contact(new Contact().email("@test.dev"))
                        .license(new License().name("GNU"))
                        .version("1.0"));
    }
}
