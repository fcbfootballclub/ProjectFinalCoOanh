package com.example.final_v1.ProductAndTag;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductAndTag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "id_tag")
    Long id_tag;

    @Column(name = "id_product")
    Long id_product;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

    public ProductAndTag(Long id_tag, Long id_product) {
        this.id_tag = id_tag;
        this.id_product = id_product;
    }

    public ProductAndTag() {
    }

    public Long getId_tag() {
        return id_tag;
    }

    public void setId_tag(Long id_tag) {
        this.id_tag = id_tag;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    @Override
    public String toString() {
        return "ProductAndTag{" +
                "id_tag=" + id_tag +
                ", id_product=" + id_product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAndTag that = (ProductAndTag) o;
        return Objects.equals(id_tag, that.id_tag) && Objects.equals(id_product, that.id_product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_tag, id_product);
    }
}
