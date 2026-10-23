package com.cafeqr.cafeQR.Service;

import com.cafeqr.cafeQR.Entity.CafeTable;
import com.cafeqr.cafeQR.Entity.MenuItem;
import com.cafeqr.cafeQR.Entity.Order;
import com.cafeqr.cafeQR.Entity.OrderItem;
import com.cafeqr.cafeQR.Repository.OrderRepository;
import com.cafeqr.cafeQR.Repository.OrderItemRepository;
import com.cafeqr.cafeQR.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public Order createOrder(CafeTable cafeTable, List<OrderItem> items) {
        Order order = new Order();
        order.setCafeTable(cafeTable);
        order.setStatus("PENDING");

        long total = 0;
        for (OrderItem item : items) {
            MenuItem fullMenuItem = menuItemRepository.findById(item.getMenuItem().getId()).orElse(null);
            item.setMenuItem(fullMenuItem);
            total = total + (fullMenuItem.getPrice() * item.getQuantity());
        }
        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);

        for (OrderItem item : items) {
            item.setOrder(savedOrder);
            orderItemRepository.save(item);
        }

        return savedOrder;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}