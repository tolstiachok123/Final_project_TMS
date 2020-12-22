package com.test.demo.alcomarket.security;

import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private IUserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User with username: " + username + " not found");
    }

    CustomPrincipal customPrincipal = CustomPrincipalFactory.create(user);
    return customPrincipal;
  }

}
