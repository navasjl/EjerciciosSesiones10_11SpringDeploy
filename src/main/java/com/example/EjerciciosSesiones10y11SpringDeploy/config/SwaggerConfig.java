package com.example.EjerciciosSesiones10y11SpringDeploy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Boot API REST for Laptops",
                "Library api rest documentation about laptops",
                "1.0",
                "www.bestlaptops.com",
                new Contact("Jose","www.bestlaptops.com","jose@bestlaptops.org"),
                "MIT",
                "www.bestlaptops.com",
                Collections.emptyList());
    }
}
