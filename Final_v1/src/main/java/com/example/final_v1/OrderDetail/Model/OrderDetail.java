package com.example.final_v1.OrderDetail.Model;

import com.example.final_v1.Order.Model.Order;
import com.example.final_v1.Product.Model.Product;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_order")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Transient
    @Column(name = "sub_total")
    private float subTotal;
}
