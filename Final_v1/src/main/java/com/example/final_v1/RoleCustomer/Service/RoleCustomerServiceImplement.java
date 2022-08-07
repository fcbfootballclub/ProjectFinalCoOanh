package com.example.final_v1.RoleCustomer.Service;

import com.example.final_v1.RoleCustomer.Model.RoleCustomer;
import com.example.final_v1.RoleCustomer.Repository.RoleCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleCustomerServiceImplement implements RoleCustomerService{
    @Autowired
    private RoleCustomerRepository roleCustomerRepository;
    @Override
    public List<RoleCustomer> getAllUserRole() {
        return roleCustomerRepository.findAll();
    }
}
