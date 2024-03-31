package br.com.arquiteturahexagonal.application.core.service;

import br.com.arquiteturahexagonal.application.core.domain.Usuario;
import br.com.arquiteturahexagonal.application.port.in.UsuarioServicePort;
import br.com.arquiteturahexagonal.application.port.out.UsuarioRepositoryPort;

import java.util.ArrayList;
import java.util.List;

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
        return null;
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
        return usuarioRepositoryPort.findByIdService(id);
    }

    @Override
    public void deleteService(Long id) {

    }
}
