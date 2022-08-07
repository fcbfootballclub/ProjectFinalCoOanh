package com.example.final_v1.Order.Model;

import com.example.final_v1.Customer.Model.Customer;
import com.example.final_v1.Shipping.Model.Shipping;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tblOrder")
@Getter
@Setter
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
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "modified_at")
    private Date modifiedAt;
    @Column(name = "order_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_shipping_fee")
    @EqualsAndHashCode.Exclude
    private Shipping shipping;
}
