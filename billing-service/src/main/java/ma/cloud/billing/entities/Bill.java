package ma.cloud.billing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingData;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItem;

}
