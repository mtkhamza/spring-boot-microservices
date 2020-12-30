package ma.cloud.billing.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import ma.cloud.billing.entities.Bill;
import ma.cloud.billing.entities.ProductItem;
import ma.cloud.billing.model.Customer;
import ma.cloud.billing.model.Product;
import ma.cloud.billing.repository.BillRepository;
import ma.cloud.billing.repository.ProductItemRepository;
import ma.cloud.billing.service.CustomerRestClient;
import ma.cloud.billing.service.ProductItemRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BillingController {

    @Autowired
    private Environment environment;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductItemRestClient productItemRestClient;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;

    @GetMapping("/")
    public String home() {
        return "Hello from Billing Service running at port: " + environment.getProperty("local.server.port");
    }

    @HystrixCommand(fallbackMethod = "getCustomerFallBack")
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable(name = "id") Long id) {
        return customerRestClient.getCustomerById(id);
    }

    public Customer getCustomerFallBack(@PathVariable(name = "id") Long id) {
        return new Customer(null, "Customer Not Found", "error@error.com");
    }

    @HystrixCommand(fallbackMethod = "getProductFallBack")
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id) {
        return productItemRestClient.getProductItemById(id);
    }

    public Product getProductFallBack(@PathVariable(name = "id") Long id) {
        return new Product(null,"Product Not Found", 0.0, 0.0);
    }


    @HystrixCommand(fallbackMethod = "getBillFallBack")
    @GetMapping("/bills/full/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.setProductItem(productItemRepository.findByBillId(id));
        bill.getProductItem().forEach(pi -> {
            pi.setProduct(productItemRestClient.getProductItemById(pi.getProductID()));
        });
        return bill;
    }

    public Bill getBillFallBack(@PathVariable(name = "id") Long id) {
        return new Bill(null, new Date(), null, null, 0);
    }

}












