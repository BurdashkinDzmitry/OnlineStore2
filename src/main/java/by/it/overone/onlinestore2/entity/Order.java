package by.it.overone.onlinestore2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zakaz")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany (mappedBy =  "order")
    private List<ProductInOrder> productInOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ProductInOrder> getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(List<ProductInOrder> productInOrder) {
        this.productInOrder = productInOrder;
    }
}
