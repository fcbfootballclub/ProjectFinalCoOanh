package com.example.final_v1.RoleCustomer.Repository;

import com.example.final_v1.RoleCustomer.Model.RoleCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleCustomerRepository extends JpaRepository<RoleCustomer, Long> {
}
