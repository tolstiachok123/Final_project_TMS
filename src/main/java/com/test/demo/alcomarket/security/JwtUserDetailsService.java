package com.test.demo.alcomarket.security;

import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private IUserRepository iUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = iUserRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User with username: " + username + " not found");
    }

    CustomPrincipal customPrincipal = CustomPrincipalFactory.create(user);
    return customPrincipal;
  }

}
