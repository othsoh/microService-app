package org.sid.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.customerservice.Entities.Customer;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    private long customerID;
    @Transient
    private Customer customer;
}
