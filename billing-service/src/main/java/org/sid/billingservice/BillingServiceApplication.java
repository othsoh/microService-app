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
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository itemRepository,
                            CustomerRestClient customerRestClient,
                            ProductRestClient productRestClient) {
        {
            return args -> {
                Collection<Product> products = productRestClient.allProducts().getContent();
                Customer customer1 = customerRestClient.getCustomerById(1L);
                Customer customer2 = customerRestClient.getCustomerById(1L);
                if (customer1 == null && customer2 == null) {
                    throw new RuntimeException("Customer not found");
                }
                Bill bill1 = new Bill();
                bill1.setBillingDate(new Date());
                bill1.setCustomerID(1L);
                Bill savedBill1 = billRepository.save(bill1);
                products.forEach(p -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(p.getPrice());
                    productItem.setQuantity(1 + new Random().nextInt(20));
                    productItem.setProductId(p.getId());
                    productItem.setBill(savedBill1);
                    itemRepository.save(productItem);
                });
                Bill bill2 = new Bill();
                bill2.setBillingDate(new Date());
                bill2.setCustomerID(1L);
                Bill savedBill2 = billRepository.save(bill2);
                products.forEach(p -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(p.getPrice());
                    productItem.setQuantity(1 + new Random().nextInt(5));
                    productItem.setProductId(p.getId());
                    productItem.setBill(savedBill2);
                    itemRepository.save(productItem);
                });
                Bill bill3 = new Bill();
                bill3.setBillingDate(new Date());
                bill3.setCustomerID(2L);
                Bill savedBill3 = billRepository.save(bill3);
                products.forEach(p -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(p.getPrice());
                    productItem.setQuantity(1 + new Random().nextInt(5));
                    productItem.setProductId(p.getId());
                    productItem.setBill(savedBill3);
                    itemRepository.save(productItem);
                });
            };
        }
    }
}