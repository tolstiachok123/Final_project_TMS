package com.test.demo.alcomarket.repository;

import com.test.demo.alcomarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("from User where username = :username")
    User findByUsername(String username);

}
