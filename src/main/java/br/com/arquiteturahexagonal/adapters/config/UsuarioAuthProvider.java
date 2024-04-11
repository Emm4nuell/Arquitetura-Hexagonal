package br.com.arquiteturahexagonal.adapters.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String usuario = authentication.getName();
        String senha = (String) authentication.getCredentials();
        Authentication auth =
                new UsernamePasswordAuthenticationToken("Eduardo Emmanuel", null, List.of(new SimpleGrantedAuthority("ROLE_COTACAO")));
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
