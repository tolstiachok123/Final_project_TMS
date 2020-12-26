package com.test.demo.alcomarket.repository;

import com.test.demo.alcomarket.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

    @Query("from Role where name = :roleName")
    Role findByName(String roleName);

}
