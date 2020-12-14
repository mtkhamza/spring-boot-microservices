package ma.cloud.billing.web;

import ma.cloud.billing.model.Customer;
import ma.cloud.billing.model.Product;
import ma.cloud.billing.service.CustomerRestClient;
import ma.cloud.billing.service.ProductItemRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    @Autowired
    private Environment environment;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductItemRestClient productItemRestClient;
    
    @GetMapping("/")
    public String home(){
        return "Hello from Billing Service running at port: " + environment.getProperty("local.server.port");
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable(name = "id") Long id){
        return customerRestClient.getCustomerById(id);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id){
        return productItemRestClient.getProductItemById(id);
    }

}












