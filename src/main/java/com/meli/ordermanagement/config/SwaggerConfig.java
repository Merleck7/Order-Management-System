package com.meli.ordermanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger / OpenAPI Configuration for the Order Management API.
 * This configuration automatically generates interactive API documentation
 * accessible via Swagger UI.
 *
 * Compatible with Spring Boot 3.3.x and springdoc-openapi-starter-webmvc-ui 2.6.0
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI orderManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Management API")
                        .version("1.0.0")
                        .description("REST API for managing customer orders, including creation, retrieval, updates, and deletions.")
                        .contact(new Contact()
                                .name("Order Management Team")
                                .email("mendozarl07@outlook.es")
                                .url("https://github.com/Merleck7"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
