package com.ifsul.tds_rodrigo.infra.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Acompanhamento de Hábitos")
                        .description("API Rest da aplicação tds_rodrigo, contendo as funcionalidades para CRUD de hábitos e usuários.")
                        .contact(new Contact()
                                .name("Rodrigo Miranda da Silva")
                                .email("rodrigo.miranda.silva.rms@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://localhost:8080/api/licenca")));
    }
}
