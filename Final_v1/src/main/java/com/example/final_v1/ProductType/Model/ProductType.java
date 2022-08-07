package com.example.final_v1.ProductType.Model;

import com.example.final_v1.Product.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_type", nullable = false, unique = true)
    private String productType;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Product)
    // MapopedBy trỏ tới tên biến.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    @JsonIgnore
    private Collection<Product> products;

    //constructor
    public ProductType(String productType) {
        this.productType = productType;
    }
}
