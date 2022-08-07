package com.example.final_v1.RoleCustomer.Controller;

import com.example.final_v1.ErrorHandler.ResponseObj;
import com.example.final_v1.RoleCustomer.Service.RoleCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/role_user")
public class RoleCustomerController {
    @Autowired
    RoleCustomerService roleCustomerService;

    @GetMapping(path = "")
    ResponseObj getAllRoleCustomer(){
        return new ResponseObj("OK", "Get all role users", roleCustomerService.getAllUserRole());
    }
}
