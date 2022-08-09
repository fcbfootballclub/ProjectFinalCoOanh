package com.example.final_v1.Product.Model;

import com.example.final_v1.OrderDetail.Model.OrderDetail;
import com.example.final_v1.ProductTag.Model.ProductTag;
import com.example.final_v1.ProductType.Model.ProductType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", length = 200, nullable = false)
    private String title;
    @Column(name = "description", nullable = false, length = 2000)
    private String description;
    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "created_at", nullable = true, updatable = false)
    @CreationTimestamp
    private Date created_at;
    @Column(name = "updated_at", nullable = true)
    @UpdateTimestamp
    private Date updated_at;

    // Many to One Có product trong một product type.
    @ManyToOne
    @JoinColumn(name = "id_product_type") // thông qua khóa ngoại id_product_type
    private ProductType productType;

    // mappedBy trỏ tới tên biến persons ở trong Address.
    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<ProductTag> productTags;

    @OneToMany(mappedBy = "product")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Collection<OrderDetail> orderDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id || Objects.equals(title, product.title);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Product(String title, String description, String link, float price, ProductType productType) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.price = price;
        this.productType = productType;
        this.created_at = Date.valueOf("2022-10-10");
    }

    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product.getCreated_at());
    }
}
