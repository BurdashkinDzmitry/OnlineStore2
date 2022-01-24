package by.it.overone.onlinestore2.services;


import by.it.overone.onlinestore2.entity.Order;
import by.it.overone.onlinestore2.entity.Product;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped

public class OrderBean implements Serializable {
    private Order order;
    private String name;
    private int quantity;

    @EJB
    private OrdersManagerBean ordersManagerBean;

    @EJB
    private ProductManagerBean productManagerBean;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void createOrder() {
        if (order == null) {
order = ordersManagerBean.createOrder();
        }
    }
    public void createProduct(){
        productManagerBean.createProduct(name, quantity);

    }
    public List <Product> getProducts (){
        return productManagerBean.getProducts ();

    }
public void addProduct(Product product){
        if ((order == null)){
            return;
        }
        ordersManagerBean.addToOrder(product.getId(), order.getId(), quantity=1);

}
public List <Product> getProductsInOrder() {
        if (order == null){
            return Collections.emptyList();

        }
        return ordersManagerBean.getProductInOrders(order.getId());
}
}
