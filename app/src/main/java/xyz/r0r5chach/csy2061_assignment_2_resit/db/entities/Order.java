package xyz.r0r5chach.csy2061_assignment_2_resit.db.entities;

import java.util.List;

public class Order extends NamedEntity {
    private User user;
    private List<Product> products;
    private OrderStatus status;

    public Order() {
        super("");
    }

    public Order(int id, String name, User user, List<Product> products, OrderStatus status) {
        super(id, name);
        this.user = user;
        this.products = products;
        this.status = status;
    }

    public Order(int id, String name, User user, Product product, OrderStatus status) {
        this(id, name, user, product.toList(), status);
    }

    public Order(String name, User user, List<Product> products, OrderStatus status) {
        super(name);
    }

    public Order(String name, User user, Product product, OrderStatus status) {
        this(name, user, product.toList(), status);
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
