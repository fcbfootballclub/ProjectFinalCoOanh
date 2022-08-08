package com.example.final_v1.OrderDetail.Service;

import com.example.final_v1.OrderDetail.Model.OrderDetail;
import com.example.final_v1.OrderDetail.Repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImplement implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> getOrderDetailById(long id) {
        return orderDetailRepository.findById(id);
    }
    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
        return 1;
    }

    @Override
    public int updateOrderDetail(long id, OrderDetail orderDetail) {
        Optional<OrderDetail> found = orderDetailRepository.findById(id);
        if(found.isPresent()){
            found.get().setProduct(orderDetail.getProduct());
            found.get().setQuantity(orderDetail.getQuantity());
            orderDetailRepository.save(found.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteOrderDetail(long id) {
        Optional<OrderDetail> found = orderDetailRepository.findById(id);
        if(found.isPresent()) {
            orderDetailRepository.delete(found.get());
            return 1;
        }
        return 0;
    }

    @Override
    public Page<OrderDetail> findPageOrderDetail(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return orderDetailRepository.findAll(pageable);
    }
}
