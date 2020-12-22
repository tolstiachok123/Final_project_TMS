package com.test.demo.alcomarket.security;

import com.test.demo.alcomarket.model.Role;
import com.test.demo.alcomarket.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CustomPrincipalFactory {

  public static CustomPrincipal create(User user) {
    return new CustomPrincipal(
        user.getId(),
        user.getUsername(),
        user.getEmail(),
        user.getPhone(),
        user.getPassword(),
        user.isActive(),
        user.getUpdated(),
        mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
    );
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
    return userRoles.stream()
        .map(role ->
            new SimpleGrantedAuthority(role.getName().toString())
        ).collect(Collectors.toList());
  }

}
