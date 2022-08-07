package com.example.final_v1.Customer.Service;

import com.example.final_v1.Customer.Model.Customer;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getAllCustomer();
    public Optional<Customer> getCustomerById(long id);
    public int addCustomer(Customer customer);
    public int updateCustomer(long id, Customer customer);
    public int deleteCustomer(long id);

    public Page<Customer> findPaginateCustomer(int pageNo, int pageSize);
}
