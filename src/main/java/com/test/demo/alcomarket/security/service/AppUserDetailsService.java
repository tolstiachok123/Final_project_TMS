package com.test.demo.alcomarket.security.service;

import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IUserRepository;
import com.test.demo.alcomarket.security.CustomPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final IUserRepository iUserRepository;

    @Autowired
    public AppUserDetailsService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        return new CustomPrincipal(user);
    }
}
