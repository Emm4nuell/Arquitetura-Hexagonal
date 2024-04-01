package br.com.arquiteturahexagonal.adapters.outbound.repositoryadapter;

import br.com.arquiteturahexagonal.adapters.inbound.entity.MaterialEntity;
import br.com.arquiteturahexagonal.adapters.outbound.repository.MaterialRepository;
import br.com.arquiteturahexagonal.application.core.domain.Material;
import br.com.arquiteturahexagonal.application.port.out.MaterialRepositoryPort;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MaterialRepositoryAdapter implements MaterialRepositoryPort {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public Material saveRepository(Material material) {
        materialRepository.save(mapper.map(material, MaterialEntity.class));
        return material;
    }

    @Override
    @Transactional
    public Material updateRepository(Material material, Long id) {
        MaterialEntity entity = materialRepository.findById(id).orElseThrow(() -> new NullPointerException("Material não localizado na base de dados!"));
        return mapper.map(entity, Material.class);
    }

    @Override
    public List<Material> findAllRepository() {
        List<Material> materiais = materialRepository.findAll().stream()
                .map(x -> mapper.map(x, Material.class)).collect(Collectors.toList());
        return materiais;
    }

    @Override
    public Material findByIdRepository(Long id) {
        MaterialEntity entity = materialRepository.findById(id).orElseThrow(() -> new NullPointerException("Material não localizado na base de dados!"));
        return mapper.map(entity, Material.class);
    }

    @Override
    @Transactional
    public void deleteRepository(Long id) {
        MaterialEntity entity = materialRepository.findById(id).orElseThrow(() -> new NullPointerException("Material não localizado na base de dados!"));
        materialRepository.deleteById(id);
    }
}
