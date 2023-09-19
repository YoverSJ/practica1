package com.practica1.infraestructure.config;

import com.practica1.application.service.ProductoService;
import com.practica1.application.usecase.ProductoUseCaseImpl;
import com.practica1.domain.ports.out.ProductoRepositoryPort;
import com.practica1.infraestructure.repository.ProductoJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductoService productoService(ProductoRepositoryPort productoRepositoryPort){
        return new ProductoService(new ProductoUseCaseImpl(productoRepositoryPort));
    }

    @Bean
    public ProductoRepositoryPort productoRepositoryPort(ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter){
        return productoJpaRepositoryAdapter;
    }

}
