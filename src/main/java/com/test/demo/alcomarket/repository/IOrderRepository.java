package com.test.demo.alcomarket.repository;

import com.test.demo.alcomarket.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
