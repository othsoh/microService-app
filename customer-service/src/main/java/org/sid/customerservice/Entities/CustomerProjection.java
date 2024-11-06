package org.sid.customerservice.Entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Customer.class)
public interface CustomerProjection {
    public String getName();
    public String getEmail();

}
