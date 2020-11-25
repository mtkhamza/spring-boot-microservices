package ma.cloud.billing;

import ma.cloud.billing.model.Customer;
import ma.cloud.billing.repository.BillRepository;
import ma.cloud.billing.repository.ProductItemRepository;
import ma.cloud.billing.service.CustomerRestClient;
import ma.cloud.billing.service.ProductItemRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class BillingApplication implements CommandLineRunner {


		@Autowired
		CustomerRestClient customerRestClient;

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
		System.out.println("billing service is running");

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
