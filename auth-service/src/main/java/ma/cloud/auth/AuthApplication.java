package ma.cloud.auth;

import ma.cloud.auth.entities.AppRole;
import ma.cloud.auth.entities.AppUser;
import ma.cloud.auth.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication

public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
        System.out.println("service is running");
    }


    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addRole(new AppRole(null,"USER"));
            accountService.addRole(new AppRole(null,"ADMIN"));
            accountService.addRole(new AppRole(null,"CUSTOMER_MANAGER"));
            accountService.addRole(new AppRole(null,"PRODUCT_MANAGER"));
            accountService.addRole(new AppRole(null,"BILLS_MANAGER"));

            accountService.addUser(new AppUser(null,"user1","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"admin","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"user2","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"user3","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"admin2","1234",new ArrayList<>()));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
        };
    }

}
