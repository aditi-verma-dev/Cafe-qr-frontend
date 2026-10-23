package com.cafeqr.cafeQR.Repository;

import com.cafeqr.cafeQR.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
