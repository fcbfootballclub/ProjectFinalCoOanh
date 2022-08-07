package com.example.final_v1.Order.Controller;

import com.example.final_v1.ErrorHandler.ResponseObj;
import com.example.final_v1.Order.Model.Order;
import com.example.final_v1.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "")
    ResponseObj getAllOrder(){
        return new ResponseObj("OK", "Successfully", orderService.getAllOrder());
    }

    @GetMapping(path = "{id}")
    ResponseObj getOrderById(@PathVariable long id){
        Optional<Order> found = orderService.getOrderById(id);
        return found.map(order -> new ResponseObj("OK", "Found order", order)).orElseGet(() -> new ResponseObj("Failed", "Not found", ""));
    }

    @PostMapping(path = "")
    ResponseObj addOrder(@RequestBody Order order){
        return new ResponseObj("Ok", "Order successfully", orderService.addOrder(order));
    }

    @PutMapping(path = "{id}")
    ResponseObj updateOrder(@PathVariable long id, @RequestBody Order order){
        int i = orderService.updateOrder(id, order);
        if(i == 1){
            return new ResponseObj("OK", "Update order successfully", order);
        }
        return new ResponseObj("Failed", "Update failed", order);
    }

}
