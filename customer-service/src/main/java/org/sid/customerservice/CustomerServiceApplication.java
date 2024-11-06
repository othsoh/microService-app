package org.sid.customerservice;

import org.sid.customerservice.Entities.Customer;
import org.sid.customerservice.Repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RestControllerConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(CustomerRepository customerRepository,
                                                RepositoryRestConfiguration restConf) {
        return args -> {
            restConf.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                    Customer.builder().name("Hassan").email("Hassan@gmail.com").build(),
                    Customer.builder().name("Mohamed").email("Mohamed@gmail.com").build(),
                    Customer.builder().name("Ali").email("Ali@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
