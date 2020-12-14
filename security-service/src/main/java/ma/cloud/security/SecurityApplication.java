package ma.cloud.security;

import ma.cloud.security.entities.Role;
import ma.cloud.security.entities.User;
import ma.cloud.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        System.out.println("Security service is running ...");
        SpringApplication.run(SecurityApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addRole(new Role(null,"USER"));
            accountService.addRole(new Role(null,"ADMIN"));
            accountService.addRole(new Role(null,"CUSTOMER_MANAGER"));
            accountService.addRole(new Role(null,"PRODUCT_MANAGER"));
            accountService.addRole(new Role(null,"BILLS_MANAGER"));

            accountService.addUser(new User(null,"user1","1234",new ArrayList<>()));
            accountService.addUser(new User(null,"admin","1234",new ArrayList<>()));
            accountService.addUser(new User(null,"user2","1234",new ArrayList<>()));
            accountService.addUser(new User(null,"user3","1234",new ArrayList<>()));
            accountService.addUser(new User(null,"admin2","1234",new ArrayList<>()));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","user");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
        };
    }
}
