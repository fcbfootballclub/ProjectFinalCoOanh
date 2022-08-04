package com.example.final_v1.ProductType.Model;

import com.example.final_v1.Product.Model.Product;
import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "productType")
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
    private String product_type;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Product)
    // MapopedBy trỏ tới tên biến.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<Product> products;

    //constructor
    public ProductType(String product_type) {
        this.product_type = product_type;
    }
}
