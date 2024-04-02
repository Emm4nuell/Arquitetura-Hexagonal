package br.com.arquiteturahexagonal.adapters.outbound.repositoryadapter;

import br.com.arquiteturahexagonal.adapters.inbound.entity.CotacaoEntity;
import br.com.arquiteturahexagonal.adapters.outbound.repository.CotacaoRepository;
import br.com.arquiteturahexagonal.application.core.domain.Cotacao;
import br.com.arquiteturahexagonal.application.port.out.CotacaoRepositoryPort;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CotaçãoRepositoryAdapter implements CotacaoRepositoryPort {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public Cotacao saveRepository(Cotacao cotacao) {
        CotacaoEntity entity = cotacaoRepository.save(mapper.map(cotacao, CotacaoEntity.class));
        return mapper.map(entity, Cotacao.class);
    }

    @Override
    @Transactional
    public Cotacao updateRepository(Cotacao cotacao, Long id) {
        return findByIdRepository(id);
    }

    @Override
    public List<Cotacao> findAllRepository() {
        List<Cotacao> cotacoes = cotacaoRepository.findAll().stream()
                .map(e -> mapper.map(e, Cotacao.class)).collect(Collectors.toList());
        return cotacoes;
    }

    @Override
    public Cotacao findByIdRepository(Long id) {
        CotacaoEntity entity = cotacaoRepository.findById(id).orElseThrow(() -> new NullPointerException("Cotação não localizado na base de dados!"));
        return mapper.map(entity, Cotacao.class);
    }

    @Override
    @Transactional
    public void deleteRepository(Long id) {
        findByIdRepository(id);
        cotacaoRepository.deleteById(id);
    }
}
