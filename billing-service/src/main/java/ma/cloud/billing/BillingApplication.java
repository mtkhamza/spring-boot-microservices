package ma.cloud.billing;

import ma.cloud.billing.entities.Bill;
import ma.cloud.billing.entities.ProductItem;
import ma.cloud.billing.model.Customer;
import ma.cloud.billing.repository.BillRepository;
import ma.cloud.billing.repository.ProductItemRepository;
import ma.cloud.billing.service.CustomerRestClient;
import ma.cloud.billing.service.ProductItemRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            ProductItemRestClient productItemRestClient, CustomerRestClient customerRestClient) {
        return args -> {
            Bill bill = new Bill();
            bill.setBillingDate(new Date());
            Customer customer = customerRestClient.getCustomerById(1L);
            System.out.println(customer.toString());
            bill.setCustomerId(customer.getId());
            billRepository.save(bill);
            productItemRestClient.findall().forEach(p -> {
                productItemRepository.save(new ProductItem(null, (1 + Math.random() * 1000), p.getPrice(), p.getId(), bill, null));
            });
        };
    }

}


