package com.syniaeva.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by stoxa on 01.04.17.
 */

@Entity
@Table(name = "categories")
public class Category {

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "NAME", length=255, nullable=false, unique = true)
    private String name;

    @Column(name = "IS_ROOT", nullable = false)
    private Boolean root;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade={CascadeType.ALL})
    private List<MappedProduct> productList;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="CATEGORY_MANUFACTURERS",
            joinColumns={@JoinColumn(name="CATEGORY_ID")},
            inverseJoinColumns={@JoinColumn(name="MANUFACTURER_ID")})
    private List<Manufacturer> manufacturers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public List<MappedProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<MappedProduct> productList) {
        this.productList = productList;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
