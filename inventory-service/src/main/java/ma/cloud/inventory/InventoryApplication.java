package ma.cloud.inventory;

import ma.cloud.inventory.Repository.ProductRepository;
import ma.cloud.inventory.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"Mouse",20,2));
		productRepository.save(new Product(null,"Keyboard",30,3));
		productRepository.save(new Product(null,"Printer",500,1));
		productRepository.save(new Product(null,"Guitar",2500,2));
	}
}



