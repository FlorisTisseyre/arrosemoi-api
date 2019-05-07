package com.octo.arrosemoi.infrastructure;

import com.octo.arrosemoi.catalog.InMemoryCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArroseMoiConfiguration {
    @Bean
    public InMemoryCatalog catalog() {
        return new InMemoryCatalog();
    }
}
