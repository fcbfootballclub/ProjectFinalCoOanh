package com.example.final_v1.Product.Model;

import com.example.final_v1.ProductTag.Model.ProductTag;
import com.example.final_v1.ProductType.Model.ProductType;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Product")
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
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "created_at", nullable = false)
    private Date created_at;
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    // Many to One Có product trong một product type.
    @ManyToOne
    @JoinColumn(name = "id_product_type") // thông qua khóa ngoại id_product_type
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductType productType;

    // mappedBy trỏ tới tên biến persons ở trong Address.
    @ManyToMany(mappedBy = "products")
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @EqualsAndHashCode.Exclude
    private Collection<ProductTag> productTags;

    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}