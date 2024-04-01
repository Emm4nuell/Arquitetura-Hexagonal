package br.com.arquiteturahexagonal.application.core.service;

import br.com.arquiteturahexagonal.application.core.domain.Material;
import br.com.arquiteturahexagonal.application.port.in.MaterialServicePort;
import br.com.arquiteturahexagonal.application.port.out.MaterialRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;

public class MaterialService implements MaterialServicePort {

    private final MaterialRepositoryPort materialRepositoryPort;

    public MaterialService(MaterialRepositoryPort materialRepositoryPort) {
        this.materialRepositoryPort = materialRepositoryPort;
    }

    @Override
    public Material saveService(Material material) {
        material.setDatacriacao(LocalDateTime.now());
        return materialRepositoryPort.saveRepository(material);
    }

    @Override
    public Material updateService(Material material, Long id) {
        Material m = materialRepositoryPort.updateRepository(material, id);
        material.setId(m.getId());
        return saveService(material);
    }

    @Override
    public List<Material> findAllService() {
        return materialRepositoryPort.findAllRepository();
    }

    @Override
    public Material findByIdService(Long id) {
        return materialRepositoryPort.findByIdRepository(id);
    }

    @Override
    public void deleteService(Long id) {
        materialRepositoryPort.deleteRepository(id);
    }
}
