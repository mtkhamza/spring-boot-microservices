package ma.cloud.billing.repository;

import ma.cloud.billing.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface BillRepository  extends JpaRepository<Bill, Long> {

}









