package br.com.arquiteturahexagonal.application.port.out;

import br.com.arquiteturahexagonal.application.core.domain.Usuario;

import java.util.List;

public interface UsuarioRepositoryPort {
    Usuario saveRepository(Usuario usuario);
    Usuario updateRepository(Usuario usuario, Long id);
    List<Usuario> findAllRepository();
    Usuario findByIdRepository(Long id);

    void deleteRepository(Long id);
}
