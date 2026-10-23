package com.cafeqr.cafeQR.Repository;

import com.cafeqr.cafeQR.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}