package ma.cloud.billing.service;

import ma.cloud.billing.entities.ProductItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping("/products/{id}")
    public ProductItem getProductItemById(@PathVariable(name = "id") Long id);
}