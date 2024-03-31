package br.com.arquiteturahexagonal.application.port.in;

import br.com.arquiteturahexagonal.application.core.domain.Usuario;

import java.util.List;

public interface UsuarioServicePort {

    Usuario saveService(Usuario usuario);
    Usuario updateService(Usuario usuario, Long id);
    List<Usuario> findAllService();
    Usuario findByIdService(Long id);

    void deleteService(Long id);

}
