package br.com.arquiteturahexagonal.application.port.out;

import br.com.arquiteturahexagonal.application.core.domain.Material;

import java.util.List;

public interface MaterialRepositoryPort {
    Material saveRepository(Material material);
    Material updateRepository(Material material, Long id);
    List<Material> findAllRepository();
    Material findByIdRepository(Long id);

    void deleteRepository(Long id);
}
