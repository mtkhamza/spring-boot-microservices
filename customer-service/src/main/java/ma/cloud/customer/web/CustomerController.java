package ma.cloud.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String home(){
        return "Hello from Customer Service running at port: " + environment.getProperty("local.server.port");
    }
}



