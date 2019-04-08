package io.codelex.studentsystem.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Collections.singleton;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Component
class AuthenticationService {
    void authorise(String login) {
        Set<SimpleGrantedAuthority> authorities = singleton(new SimpleGrantedAuthority("Employer"));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login,
                null,
                authorities);
        getContext().setAuthentication(token);
    }

    void clearAuthentication() {
        getContext().setAuthentication(null);
    }
}