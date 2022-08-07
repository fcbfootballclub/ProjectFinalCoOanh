package com.example.final_v1.RoleCustomer.Service;

import com.example.final_v1.RoleCustomer.Model.RoleCustomer;

import java.util.List;

public interface RoleCustomerService {
    List<RoleCustomer> getAllUserRole();

    int addRoleCustomer(RoleCustomer roleCustomer);
}
