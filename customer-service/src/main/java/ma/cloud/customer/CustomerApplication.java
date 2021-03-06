package ma.cloud.customer;

import ma.cloud.customer.Repository.CustomerRepository;
import ma.cloud.customer.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args){
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		customerRepository.save(new Customer(null, "Hamza", "hamza@gmail.com"));
		customerRepository.save(new Customer(null, "Maryam", "maryam@gmail.com"));
		customerRepository.save(new Customer(null, "Saad", "saad@gmail.com"));
		customerRepository.save(new Customer(null, "Anas", "anas@gmail.com"));
	}
}




