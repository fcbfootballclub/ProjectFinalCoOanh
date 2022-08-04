package com.example.final_v1.ProductTag.Model;

import com.example.final_v1.Product.Model.Product;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ProductTag")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "tag_name", nullable = false, length = 20, unique = true)
    private String tagName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()

    @JoinTable(name = "Product_And_Tag", //Tạo ra một join Table tên là "Product_Tag"
            joinColumns = @JoinColumn(name = "id_tag"),  // TRong đó, khóa ngoại chính là address_id trỏ tới class hiện tại (Address)
            inverseJoinColumns = @JoinColumn(name = "id_product") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Person)
    )
    private Collection<Product> products;
}
