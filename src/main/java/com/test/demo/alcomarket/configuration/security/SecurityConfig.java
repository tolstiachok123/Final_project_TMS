package com.test.demo.alcomarket.configuration.security;

import com.test.demo.alcomarket.security.CorsFilter;
import com.test.demo.alcomarket.security.JwtConfigurer;
import com.test.demo.alcomarket.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationProvider securityProvider;

    @Autowired
    private AccessDeniedHandler securityHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsFilter myCorsFilter() {
        return new CorsFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.authenticationProvider(securityProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .addFilterBefore(myCorsFilter(), WebAsyncManagerIntegrationFilter.class)
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/drinks").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(securityHandler)
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
