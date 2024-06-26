package br.com.arquiteturahexagonal.application.core.service;

import br.com.arquiteturahexagonal.application.core.domain.Usuario;
import br.com.arquiteturahexagonal.application.port.in.UsuarioServicePort;
import br.com.arquiteturahexagonal.application.port.out.UsuarioRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }


    @Override
    public Usuario saveService(Usuario usuario) {
        return usuarioRepositoryPort.saveRepository(usuario);
    }

    @Override
    public Usuario updateService(Usuario usuario, Long id) {
        Usuario user = usuarioRepositoryPort.updateRepository(usuario, id);
        usuario.setId(user.getId());
        saveService(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> findAllService() {
        List<Usuario> usuarios = usuarioRepositoryPort.findAllRepository();
        if (usuarios != null){
            return usuarios;
        }
        return new ArrayList<>();
    }

    @Override
    public Usuario findByIdService(Long id) {
        return usuarioRepositoryPort.findByIdRepository(id);
    }

    @Override
    public void deleteService(Long id) {
        usuarioRepositoryPort.deleteRepository(id);
    }

    @Override
    public void authUser(Usuario usuario) {
        usuarioRepositoryPort.authRepository(usuario);
    }

    @Override
    public Usuario findByCpfService(String cpf) {
        return usuarioRepositoryPort.findByCpfRepository(cpf);
    }
}
