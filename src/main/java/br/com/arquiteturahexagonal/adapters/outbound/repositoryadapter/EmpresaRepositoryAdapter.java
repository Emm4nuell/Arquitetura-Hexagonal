package br.com.arquiteturahexagonal.adapters.outbound.repositoryadapter;

import br.com.arquiteturahexagonal.adapters.inbound.entity.EmpresaEntity;
import br.com.arquiteturahexagonal.adapters.outbound.repository.EmpresaRepository;
import br.com.arquiteturahexagonal.application.core.domain.Empresa;
import br.com.arquiteturahexagonal.application.port.out.EmpresaRepositoryPort;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmpresaRepositoryAdapter implements EmpresaRepositoryPort {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public Empresa saveRepository(Empresa empresa) {
        EmpresaEntity entity = empresaRepository.save(mapper.map(empresa, EmpresaEntity.class));
        return mapper.map(entity, Empresa.class);
    }

    @Override
    @Transactional
    public Empresa updateRepository(Empresa empresa, Long id) {
        return findByIdRepository(id);
    }

    @Override
    public List<Empresa> findAllRepository() {
        List<Empresa> empresas = empresaRepository.findAll().stream()
                .map(e -> mapper.map(e, Empresa.class)).collect(Collectors.toList());
        return empresas;
    }

    @Override
    public Empresa findByIdRepository(Long id) {
        EmpresaEntity entity = empresaRepository.findById(id).orElseThrow(() -> new NullPointerException("Empresa não localizado na base de dados!"));
        return mapper.map(entity, Empresa.class);
    }

    @Override
    @Transactional
    public void deleteRepository(Long id) {
        empresaRepository.deleteById(id);
    }
}
