package com.example.final_v1.RoleCustomer.Model;
import com.example.final_v1.Customer.Model.Customer;
import com.example.final_v1.Role.Model.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "UserRole")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RoleCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_role")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Role role;
}
