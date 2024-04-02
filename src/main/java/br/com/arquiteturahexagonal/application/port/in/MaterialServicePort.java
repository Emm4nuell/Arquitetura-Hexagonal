package br.com.arquiteturahexagonal.application.port.in;

import br.com.arquiteturahexagonal.application.core.domain.Material;

import java.util.List;

public interface MaterialServicePort {

    Material saveService(Material material);
    Material updateService(Material material, Long id);
    List<Material> findAllService();
    Material findByIdService(Long id);
    void deleteService(Long id);

}
