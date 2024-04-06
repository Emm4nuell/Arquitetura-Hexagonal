package br.com.arquiteturahexagonal.application.core.service;

import br.com.arquiteturahexagonal.application.core.domain.Cotacao;
import br.com.arquiteturahexagonal.application.core.domain.Material;
import br.com.arquiteturahexagonal.application.port.in.CotacaoServicePort;
import br.com.arquiteturahexagonal.application.port.in.MaterialServicePort;
import br.com.arquiteturahexagonal.application.port.out.CotacaoRepositoryPort;
import br.com.arquiteturahexagonal.application.utils.strategy.MaiorPreco;
import br.com.arquiteturahexagonal.application.utils.strategy.MedioPreco;
import br.com.arquiteturahexagonal.application.utils.strategy.MenorPreco;
import br.com.arquiteturahexagonal.application.utils.strategy.PrecoStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CotacaoService implements CotacaoServicePort {

    private final CotacaoRepositoryPort cotacaoRepositoryPort;

    private MaterialService materialService;

    public CotacaoService(CotacaoRepositoryPort cotacaoRepositoryPort) {
        this.cotacaoRepositoryPort = cotacaoRepositoryPort;
    }

    @Override
    public Cotacao saveService(Cotacao cotacao) {
        cotacaoRepositoryPort.saveRepository(cotacao);

        Map<String, PrecoStrategy> map = Map.of(
                "maiorpreco", new MaiorPreco(),
                "mediopreco", new MedioPreco(),
                "menorpreco", new MenorPreco());


        return cotacao;
    }

    @Override
    public Cotacao updateService(Cotacao cotacao, Long id) {
        Cotacao cot = cotacaoRepositoryPort.updateRepository(cotacao, id);
        cotacao.setId(cot.getId());
        saveService(cotacao);
        return cotacao;
    }

    @Override
    public List<Cotacao> findAllService() {
        List<Cotacao> cotacoes = cotacaoRepositoryPort.findAllRepository();
        if (cotacoes == null){
            return new ArrayList<>();
        }
        return cotacoes;
    }

    @Override
    public Cotacao findByIdService(Long id) {
        return cotacaoRepositoryPort.findByIdRepository(id);
    }

    @Override
    public void deleteService(Long id) {
        cotacaoRepositoryPort.deleteRepository(id);
    }
}
