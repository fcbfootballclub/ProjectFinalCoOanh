package com.example.final_v1.RoleCustomer.Controller;

import com.example.final_v1.ErrorHandler.ResponseObj;
import com.example.final_v1.Role.Model.Role;
import com.example.final_v1.RoleCustomer.Model.RoleCustomer;
import com.example.final_v1.RoleCustomer.Service.RoleCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/role_user")
public class RoleCustomerController {
    @Autowired
    RoleCustomerService roleCustomerService;

    @GetMapping(path = "")
    ResponseObj getAllRoleCustomer(){
        return new ResponseObj("OK", "Get all role users", roleCustomerService.getAllUserRole());
    }

    @PostMapping(path = "")
    ResponseObj addRoleCustomer(@RequestBody RoleCustomer roleCustomer){
        return new ResponseObj("OK", "Success", roleCustomerService.addRoleCustomer(roleCustomer));
    }
}
