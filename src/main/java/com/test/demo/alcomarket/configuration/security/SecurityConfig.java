package com.test.demo.alcomarket.configuration.security;

import com.test.demo.alcomarket.security.JwtConfigurer;
import com.test.demo.alcomarket.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//
//    @Autowired
//    private AuthenticationProvider securityProvider;

//    @Autowired
//    private AccessDeniedHandler securityHandler;

//    @Autowired
//    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    CorsFilter myCorsFilter() {
//        return new CorsFilter();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
//        authentication.authenticationProvider(securityProvider);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
//                .addFilterBefore(myCorsFilter(), WebAsyncManagerIntegrationFilter.class)
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //guarantee that the application will not create any session at all
            .and()
            .authorizeRequests()
            .antMatchers("/drinks/**").permitAll()
            .antMatchers("/manufacturers/**").permitAll()
            .antMatchers("/registration").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
//                .exceptionHandling().accessDeniedHandler(securityHandler)
//                .and()
            .apply(new JwtConfigurer(jwtTokenProvider));
    }

}
