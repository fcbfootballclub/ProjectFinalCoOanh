package com.example.final_v1.OrderDetail.Service;
import com.example.final_v1.OrderDetail.Model.OrderDetail;
import com.example.final_v1.Product.Model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetail();
    Optional<OrderDetail> getOrderDetailById(long id);
    int addOrderDetail(OrderDetail orderDetail);
    int updateOrderDetail(long id, OrderDetail orderDetail);
    int deleteOrderDetail(long id);
    Page<OrderDetail> findPageOrderDetail(int pageNo, int pageSize);
}
