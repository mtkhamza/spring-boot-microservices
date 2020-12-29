package ma.cloud.customer.projection;

import ma.cloud.customer.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer", types = Customer.class)
interface CustomerProjection {
     Long getId();
     String getName();
     String getEmail();
}
