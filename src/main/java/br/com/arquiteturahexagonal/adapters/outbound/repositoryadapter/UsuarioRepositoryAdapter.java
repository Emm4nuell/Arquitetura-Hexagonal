package br.com.arquiteturahexagonal.adapters.outbound.repositoryadapter;

import br.com.arquiteturahexagonal.adapters.inbound.entity.UsuarioEntity;
import br.com.arquiteturahexagonal.adapters.outbound.repository.UsuarioRepository;
import br.com.arquiteturahexagonal.application.core.domain.Usuario;
import br.com.arquiteturahexagonal.application.port.out.UsuarioRepositoryPort;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public Usuario saveRepository(Usuario usuario) {
        usuarioRepository.save(mapper.map(usuario, UsuarioEntity.class));
        return usuario;
    }

    @Override
    public Usuario updateRepository(Usuario usuario, Long id) {
        return null;
    }

    @Override
    public List<Usuario> findAllRepository() {
        List<Usuario> usuarios = usuarioRepository.findAll().stream().map(e -> mapper.map(e, Usuario.class)).collect(Collectors.toList());
        return usuarios;
    }

    @Override
    public Usuario findByIdService(Long id) {
        Optional<UsuarioEntity> entity = usuarioRepository.findById(id);
        if (entity.isPresent()){
            return mapper.map(entity.get(), Usuario.class);
        }
        return new Usuario();
    }

    @Override
    public void deleteRepository(Long id) {

    }
}
