package com.syniaeva.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue
    @Column(name = "MANUFACTURER_ID")
    private long id;

    @Column(name = "NAME", length=255, nullable=false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer", cascade={CascadeType.ALL})
    private List<MappedProduct> productList;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="manufacturers", cascade={CascadeType.ALL})
    private List<Category> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
