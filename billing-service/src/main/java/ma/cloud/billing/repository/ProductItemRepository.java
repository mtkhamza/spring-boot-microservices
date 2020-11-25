package ma.cloud.billing.repository;

import ma.cloud.billing.entities.Bill;
import ma.cloud.billing.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
