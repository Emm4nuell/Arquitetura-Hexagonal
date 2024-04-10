package br.com.arquiteturahexagonal.adapters.config;

import br.com.arquiteturahexagonal.application.core.service.CotacaoService;
import br.com.arquiteturahexagonal.application.core.service.EmpresaService;
import br.com.arquiteturahexagonal.application.core.service.MaterialService;
import br.com.arquiteturahexagonal.application.core.service.UsuarioService;
import br.com.arquiteturahexagonal.application.port.out.CotacaoRepositoryPort;
import br.com.arquiteturahexagonal.application.port.out.EmpresaRepositoryPort;
import br.com.arquiteturahexagonal.application.port.out.MaterialRepositoryPort;
import br.com.arquiteturahexagonal.application.port.out.UsuarioRepositoryPort;
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
    public MaterialService materialService(MaterialRepositoryPort materialRepositoryPort){
        return new MaterialService(materialRepositoryPort);
    }

    @Bean
    public CotacaoService cotacaoService(CotacaoRepositoryPort cotacaoRepositoryPort){
        return  new CotacaoService(cotacaoRepositoryPort);
    }

    @Bean
    public EmpresaService empresaService(EmpresaRepositoryPort empresaRepositoryPort){
        return new EmpresaService(empresaRepositoryPort);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
