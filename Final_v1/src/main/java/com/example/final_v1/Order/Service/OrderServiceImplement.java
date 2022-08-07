package com.example.final_v1.Order.Service;
import com.example.final_v1.Order.Model.Order;
import com.example.final_v1.Order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplement implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public int addOrder(Order order) {
       orderRepository.save(order);
       return 1;
    }

    @Override
    public int updateOrder(long id, Order order) {
        Optional<Order> found = orderRepository.findById(id);
        if(found.isPresent()){
            found.get().setNote(order.getNote());
            orderRepository.save(order);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteOrder(long id) {
        Optional<Order> found = orderRepository.findById(id);
        if(found.isPresent()){
            orderRepository.delete(found.get());
            return 1;
        }
        return 0;
    }
}
