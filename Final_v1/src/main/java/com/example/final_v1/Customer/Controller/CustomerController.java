package com.example.final_v1.Customer.Controller;

import com.example.final_v1.Customer.Model.Customer;
import com.example.final_v1.Customer.Service.CustomerService;
import com.example.final_v1.ErrorHandler.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping(path = "")
    ResponseObj getAllCustomer(){
        return new ResponseObj("OK", "Get all customer", customerService.getAllCustomer());
    }

    @GetMapping(path = "{id}")
    ResponseObj getCustomerById(@PathVariable long id){
        Optional<Customer> found = customerService.getCustomerById(id);
        return found.map(customer -> new ResponseObj("OK", "Found customer", customer)).orElseGet(() -> new ResponseObj("Failed", "Not found customer id " + id, ""));
    }

    @PostMapping(path = "")
    ResponseObj addCustomer(@RequestBody Customer customer){
        int i = customerService.addCustomer(customer);
        if(i == 1){
            return new ResponseObj("OK", "Add customer successfully!", customer);
        }
        return new ResponseObj("Falied", "Invalid customer", customer);
    }

    @PutMapping(path = "{id}")
    ResponseObj updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        int check = customerService.updateCustomer(id, customer);
        if(check == 1) {
            return new ResponseObj("OK", "Update successfuly", customer);
        }
        return new ResponseObj("Failed", "Update failed", customer);
    }
    @DeleteMapping(path = "{id}")
    ResponseObj deleteCustomer(@PathVariable long id){
        int check = customerService.deleteCustomer(id);
        if(check == 1){
            return new ResponseObj("OK", "Delete successfully", "");
        }
        return new ResponseObj("Failed", "Not found customer", "");
    }
}
