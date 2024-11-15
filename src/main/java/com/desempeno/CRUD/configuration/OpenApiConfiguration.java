package com.desempeno.CRUD.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Autowired(required = false)
    private BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        String title = (buildProperties != null) ? String.format("%s.%s", buildProperties.getGroup(), buildProperties.getName()) : "CRUD CLIENTES V2";
        String version = (buildProperties != null) ? buildProperties.getVersion() : "1.0.0";
        String description = (buildProperties != null) ? buildProperties.get("description") : "API para gestion de clientes";

        return new OpenAPI().components(new Components()).info(new Info()
                .title(title)
                .version(version)
                .description(description)
                .contact(new Contact().name("Jesus Castillo").email("jesus.ecastillo25@gmail.com"))
                .license(new License().name("ISSD").url("https://issd.edu.ar/")));
    }

}
