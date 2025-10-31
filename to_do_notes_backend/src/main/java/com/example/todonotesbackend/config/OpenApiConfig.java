package com.example.todonotesbackend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration for API metadata and tags.
 */
@Configuration
public class OpenApiConfig {

    // PUBLIC_INTERFACE
    @Bean
    public OpenAPI todoNotesOpenAPI() {
        /** Provides OpenAPI metadata and groups tags for the API docs. */
        return new OpenAPI()
                .info(new Info()
                        .title("To-Do Notes API")
                        .description("REST API for managing to-do notes with CRUD operations")
                        .version("0.1.0")
                        .contact(new Contact().name("API Support").email("support@example.com")))
                .addTagsItem(new Tag().name("Notes").description("CRUD operations for to-do notes"))
                .externalDocs(new ExternalDocumentation()
                        .description("Swagger UI")
                        .url("/swagger-ui.html"));
    }
}
