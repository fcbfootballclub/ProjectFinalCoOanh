package com.example.final_v1.Order.Service;

import com.example.final_v1.Order.Model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrder();
    Optional<Order> getOrderById(long id);

    int addOrder(Order order);

    int updateOrder(long id, Order order);

    int deleteOrder(long id);
}
