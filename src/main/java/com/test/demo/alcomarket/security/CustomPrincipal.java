package com.test.demo.alcomarket.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class CustomPrincipal implements UserDetails {

    private boolean active;
    private Collection<? extends GrantedAuthority> authorities;
    private String email;
    private Integer id;
    private Date lastPasswordResetDate;
    private String password;
    private String phone;
    private String username;

    public CustomPrincipal(Integer id, String username, String email, String phone, String password, boolean active, Date lastPasswordResetDate, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.active = active;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public Integer getId() {
        return id;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

}
