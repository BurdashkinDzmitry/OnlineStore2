package by.it.overone.onlinestore2.services;

import by.it.overone.onlinestore2.entity.Product;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ProductService {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Product createProduct(String name, int quantity){
        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        entityManager.persist(product);
        return product;
    }
    public List<Product> getProducts (){
        TypedQuery<Product> query = entityManager.createQuery("select c from Product c", Product.class);
        return query.getResultList();

    }


}
