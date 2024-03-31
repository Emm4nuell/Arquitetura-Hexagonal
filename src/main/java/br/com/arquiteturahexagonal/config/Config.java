package br.com.arquiteturahexagonal.config;

import br.com.arquiteturahexagonal.application.core.service.UsuarioService;
import br.com.arquiteturahexagonal.application.port.out.UsuarioRepositoryPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Bean
    public UsuarioService service(UsuarioRepositoryPort usuarioRepositoryPort) {
        return new UsuarioService(usuarioRepositoryPort);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
