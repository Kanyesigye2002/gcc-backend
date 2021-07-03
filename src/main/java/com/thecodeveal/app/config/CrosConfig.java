package com.thecodeveal.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig {

    @Bean
    public WebMvcConfigurer gerCrosConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("https://main.d2ia5wwug43lbw.amplifyapp.com/")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
