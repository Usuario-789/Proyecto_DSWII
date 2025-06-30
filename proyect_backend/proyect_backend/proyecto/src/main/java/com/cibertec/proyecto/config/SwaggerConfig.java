package com.cibertec.proyecto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .select()                                  
                .apis(RequestHandlerSelectors.basePackage("com.cibertec.proyecto")) // Asegúrate de que esta sea la ruta correcta
                .paths(PathSelectors.ant("/api/**")) // Aquí defines las rutas de la API que quieres documentar
                .build();                                           
    }
}