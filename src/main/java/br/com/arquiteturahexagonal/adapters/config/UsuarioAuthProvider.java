package br.com.arquiteturahexagonal.adapters.config;

import br.com.arquiteturahexagonal.adapters.inbound.entity.UsuarioEntity;
import br.com.arquiteturahexagonal.adapters.outbound.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioAuthProvider implements AuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String usuario = authentication.getName();
        String senha = (String) authentication.getCredentials();
        UsuarioEntity usuarioEntity = usuarioRepository.findByCpf(usuario).orElseThrow(() -> new NullPointerException("Usuario ou senha não encontrado na base de dados!"));

        if (passwordEncoder.matches(senha, usuarioEntity.getSenha())){
            List<String> collect = usuarioEntity.getPerfilEnums().stream().map(x -> "ROLE_"+x.toString()).collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(usuarioEntity.getNome(), null, List.of(new SimpleGrantedAuthority("ROLE_COTACAO")));
        }
        throw new InternalAuthenticationServiceException("Erro ao se autenticar!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
