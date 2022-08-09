package com.example.final_v1.ProductTag.Model;

import com.example.final_v1.Product.Model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "product_tag")
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    @JoinTable(name = "product_and_tag", //Tạo ra một join Table tên là "Product_Tag"
            joinColumns = @JoinColumn(name = "id_tag"),  // TRong đó, khóa ngoại chính là address_id trỏ tới class hiện tại (Address)
            inverseJoinColumns = @JoinColumn(name = "id_product") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Person)
    )
    @JsonIgnore
    private Set<Product> products;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTag that = (ProductTag) o;
        return id == that.id || this.tagName.equals(that.tagName);
    }

    @Override
    public int hashCode() {
        return tagName.hashCode();
    }
}
