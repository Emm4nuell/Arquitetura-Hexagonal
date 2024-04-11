package br.com.arquiteturahexagonal.adapters.config;

import br.com.arquiteturahexagonal.adapters.inbound.entity.UsuarioEntity;
import br.com.arquiteturahexagonal.adapters.mapper.dto.UsuarioAuthDto;
import br.com.arquiteturahexagonal.adapters.outbound.repository.UsuarioRepository;
import br.com.arquiteturahexagonal.application.core.domain.Usuario;
import br.com.arquiteturahexagonal.application.port.in.UsuarioServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDetailsImp implements UserDetailsService {

//    @Autowired
//    private UsuarioServicePort usuarioServicePort;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper mapper;

    public UserDetails userDetails(Usuario usuario){

        UserDetails details = loadUserByUsername(usuario.getCpf());
        if(passwordEncoder.matches(usuario.getSenha(), details.getPassword())){
            return details;
        }
        throw new UsernameNotFoundException("Usuário ou senha inválido!");
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        UsuarioEntity usuario = usuarioRepository.findByCpf(cpf).orElseThrow(() -> new NullPointerException("Usuario ou senha não localizado na base de dados"));

        List<String> roles = usuario.getPerfilEnums().stream().map(e -> "ROLE_"+e.toString()).collect(Collectors.toList());

        System.err.println("Roles: " + roles);

        return User.builder()
                .username(usuario.getCpf())
                .password(usuario.getSenha())
                .roles(roles.toArray(new String[0]))
                .build();
    }
}
