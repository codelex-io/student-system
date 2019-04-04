package io.codelex.studentsystem;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import static java.util.Collections.singleton;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Component
class AuthenticationService {

    void authorise(String email, String role) {
        getContext().setAuthentication(new UsernamePasswordAuthenticationToken(email, null, singleton(new SimpleGrantedAuthority(role))));
    }

    void clearAuthentication() {
        getContext().setAuthentication(null);
    }
}