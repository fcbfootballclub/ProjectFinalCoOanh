package com.example.final_v1.Shipping.Model;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;

@Entity
@Table(name = "Shipping")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "min_order_value")
    private float minOrderValue;
    @Column(name = "max_order_value")
    private float maxOrderValue;
    @Column(name = "shipping_fee")
    private float shippingFee;
}
