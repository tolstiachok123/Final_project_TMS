package com.test.demo.alcomarket.repository;

import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<Order, Integer> {

    @Query("from Order where user =:user and status = true")
    public Order getCurrentOrder(User user);
}
