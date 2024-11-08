package org.sid.inventoryservice;

import org.sid.inventoryservice.Repositories.ProductRepository;
import org.sid.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(List.of(
                    Product.builder().name("Computer").price(1000).quantity(10).build(),
                    Product.builder().name("Printer").price(200).quantity(5).build(),
                    Product.builder().name("Smartphone").price(500).quantity(20).build()
            ));
        };
    }
}
