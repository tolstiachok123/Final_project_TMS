package com.test.demo.alcomarket.security.provider;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class AppAuthenticationProvider /*implements AuthenticationProvider*/ {

    @Autowired
    @Qualifier("appUserDetailsService")
    private UserDetailsService detailsService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public Authentication getAuthentication(String token, String secretKey) {
        UserDetails userDetails = this.detailsService.loadUserByUsername(getUsername(token, secretKey));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

//    @Override
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//        CustomPrincipal userDetails = (CustomPrincipal) detailsService.loadUserByUsername(auth.getName());
//        if (userDetails == null) {
//            throw new UsernameNotFoundException(String.format("User not found: %s", auth.getName()));
//        }
//        String password = auth.getCredentials().toString();
//
//        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
//            throw new BadCredentialsException("Incorrect username or password");
//        }
//        Collection<GrantedAuthority> authorities = userDetails.getAuthorities();
//        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
//    }

//    @Override
//    public boolean supports(Class<?> aClass) {
//        return aClass.equals(UsernamePasswordAuthenticationToken.class);
//    }
}
