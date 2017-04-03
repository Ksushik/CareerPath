package com.syniaeva.model;

import com.syniaeva.entity.MappedProduct;

public class Product {

    private String name;
    private String category;
    private String manufacturer;
    private int price;
    private boolean isAvailable;
    private String description;

    public Product(String name, String category, String manufacturer, int price,
                   boolean isAvailable, String description) {
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.price = price;
        this.isAvailable = isAvailable;
        this.description = description;
    }

    public Product(MappedProduct mappedProduct) {
        this(mappedProduct.getName(), mappedProduct.getCategory().getName(),
                mappedProduct.getManufacturer().getName(),
                mappedProduct.getPrice(), mappedProduct.isAvailable(),
                mappedProduct.getDescription());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return java.util.Objects.equals(name, product.name) &&
                java.util.Objects.equals(category, product.category) &&
                java.util.Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, category, manufacturer);
    }
}
