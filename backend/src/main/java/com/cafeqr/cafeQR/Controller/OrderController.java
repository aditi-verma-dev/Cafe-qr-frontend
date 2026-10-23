package com.cafeqr.cafeQR.Controller;



import com.cafeqr.cafeQR.Entity.Order;
import com.cafeqr.cafeQR.Entity.OrderItem;
import com.cafeqr.cafeQR.Entity.CafeTable;
import com.cafeqr.cafeQR.Service.OrderService;
import com.cafeqr.cafeQR.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TableService tableService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/table/{tableId}")
    public Order createOrder(@PathVariable Long tableId, @RequestBody List<OrderItem> items) {
        CafeTable table = tableService.getTableById(tableId);
        return orderService.createOrder(table, items);
    }
} 