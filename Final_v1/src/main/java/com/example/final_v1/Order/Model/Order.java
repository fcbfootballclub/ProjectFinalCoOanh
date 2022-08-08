package com.example.final_v1.Order.Model;

import com.example.final_v1.Customer.Model.Customer;
import com.example.final_v1.OrderDetail.Model.OrderDetail;
import com.example.final_v1.Shipping.Model.Shipping;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "tblOrder")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "shipping_city")
    private String shippingCity;
    @Column(name = "shipping_country")
    private String shippingCountry;
    @Column(name = "shipping_phone")
    private String shippingPhone;
    @Column(name = "note")
    private String note;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    private Date modifiedAt;
    @Column(name = "order_status")
    private boolean status; //0 chưa giao hàng, 1 là đã giao hàng

    @ManyToOne
    @JoinColumn(name = "id_customer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_shipping_fee")
    @EqualsAndHashCode.Exclude
    private Shipping shipping;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Collection<OrderDetail> orderDetails;

    public Order() {
    }

    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order);
        System.out.println(order.getCreatedAt());
    }
}
