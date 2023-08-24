package com.prodigasistemas.vendas.projeto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfigure {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("Access-Control-Allow-Origin",
                                "*",
                                "POST, GET, OPTIONS, PUT, DELETE",
                                "Access-Control-Allow-Headers",
                                "Origin, X-Requested-With, Content-Type, Accept")
                        .allowedMethods("*");

            }
        };
    }
}
