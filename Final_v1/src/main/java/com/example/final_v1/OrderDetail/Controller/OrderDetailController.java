package com.example.final_v1.OrderDetail.Controller;

import com.example.final_v1.ErrorHandler.ResponseObj;
import com.example.final_v1.OrderDetail.Model.OrderDetail;
import com.example.final_v1.OrderDetail.Service.OrderDetailService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = {"/order_detail"})
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping(path = {"/page", "/page/{page}"})
    ResponseObj getAllOrderDetail(@PathVariable(required = false, name = "page") Integer page){
        int size = 20;
        if(page != null){
            return new ResponseObj("OK", "Get all order details", orderDetailService.findPageOrderDetail(page, size));
        }
        return new ResponseObj("OK", "Get all order details", orderDetailService.findPageOrderDetail(1, size));
    }

    @GetMapping(path = "{id}")
    ResponseObj getOrderDetailById(@PathVariable long id){
        Optional<OrderDetail> found = orderDetailService.getOrderDetailById(id);
        return found.map(orderDetail -> new ResponseObj("OK", "Found order detail", orderDetail)).orElseGet(() -> new ResponseObj("Failed", "Not found order detail " + id, ""));
    }

    @PostMapping(path = "")
    ResponseObj addOrderDetail(OrderDetail orderDetail){
        orderDetailService.addOrderDetail(orderDetail);
        return new ResponseObj("OK", "Add successfiully", orderDetail);
    }
    @PutMapping(path = "{id}")
    ResponseObj updateOrderDetail(@PathVariable long id, @RequestBody OrderDetail orderDetail){
        int i = orderDetailService.updateOrderDetail(id, orderDetail);
        if(i == 1){
            return new ResponseObj("OK", "Successfully", orderDetail);
        }
        return new ResponseObj("Failed", "Not found order detail", orderDetail);
    }

    @DeleteMapping(path = "{id}")
    ResponseObj deleteOrderDetail(@PathVariable long id){
        int i = orderDetailService.deleteOrderDetail(id);
        return (i == 1) ? new ResponseObj("OK", "Delete successfully", "") : new ResponseObj("Failed", "Not success", "");
    }
}
