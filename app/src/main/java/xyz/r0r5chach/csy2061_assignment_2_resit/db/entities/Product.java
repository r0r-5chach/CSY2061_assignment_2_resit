package xyz.r0r5chach.csy2061_assignment_2_resit.db.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Product extends DescribedEntity {
    private int category;
    private double price, listPrice, retailPrice;
    private final LocalDate dateCreated;
    private LocalDate dateUpdated;

    public Product() {
        super("", "");
        this.dateCreated = LocalDate.now();
    }

    public Product(int id, String name, String description, double price, double listPrice, double retailPrice, LocalDate dateCreated, LocalDate dateUpdated, int category) {
        this(id, name, description, price, listPrice, retailPrice, dateCreated, category);
        this.dateUpdated = dateUpdated;
    }

    public Product(int id, String name, String description, double price, double listPrice, double retailPrice, LocalDate dateCreated, int category) {
        this(id, name, description, price, listPrice, retailPrice, dateCreated);
        this.category = category;
    }

    public Product(String name, String description, double price, double listPrice, double retailPrice, LocalDate dateCreated, int category) {
        this(name, description, price, listPrice, retailPrice, dateCreated);
        this.category = category;
    }

    public Product(int id, String name, String description, double price, double listPrice, double retailPrice, LocalDate dateCreated) {
        super(id, name, description);
        this.price = price;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
        this.dateCreated = dateCreated;
    }

    public Product(String name, String description, double price, double listPrice, double retailPrice, LocalDate dateCreated) {
        super(name, description);
        this.price = price;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
        this.dateCreated = dateCreated;
    }

    public double getPrice(PriceType type) {
        return switch(type) {
            case ACTUAL -> price;
            case LIST -> listPrice;
            case RETAIL -> retailPrice;
        };
    }

    public  LocalDate getDate(DateType type) {
        return switch(type) {
            case CREATED -> dateCreated;
            case UPDATED -> dateUpdated;
            case REGISTERED -> null;
        };
    }

    public List<Product> toList() {
        List<Product> product = new ArrayList<>();
        product.add(this);
        return product;
    }

    public void setPrice(double price, PriceType type) {
        switch(type) {
            case ACTUAL -> this.price = price;
            case LIST -> listPrice = price;
            case RETAIL -> retailPrice = price;
        }
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getCategory() {
        return category;
    }
}
