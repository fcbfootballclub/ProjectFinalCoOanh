package com.example.final_v1.ProductTag.Model;
import com.example.final_v1.Product.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "product_and_tag",
            joinColumns = @JoinColumn(name = "id_tag"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    @JsonIgnore
    private Collection<Product> products;

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

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
