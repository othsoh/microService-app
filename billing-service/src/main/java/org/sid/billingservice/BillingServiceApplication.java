package org.sid.billingservice;

import org.sid.billingservice.Repositories.BillRepository;
import org.sid.billingservice.Repositories.ProductItemRepository;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.services.CustomerRestClient;
import org.sid.billingservice.services.ProductRestClient;
import org.sid.customerservice.Entities.Customer;
import org.sid.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication @EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository itemRepository,
                            CustomerRestClient customerRestClient,
                            ProductRestClient productRestClient){ {
        return args -> {
            Collection<Product> products = productRestClient.allProducts().getContent();
            Long customerId = 1L;
            Customer customer = customerRestClient.getCustomerById(customerId);
            if (customer == null) {
                throw new RuntimeException("Customer not found");
            }
            Bill bill = new Bill();
            bill.setBillingDate(new Date());
            bill.setCustomerID(customerId);
            Bill savedBill =billRepository.save(bill);
            products.forEach(p -> {
                ProductItem productItem = new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setProductId(p.getId());
                productItem.setBill(savedBill);
                itemRepository.save(productItem);
        });
    };
}
    }}