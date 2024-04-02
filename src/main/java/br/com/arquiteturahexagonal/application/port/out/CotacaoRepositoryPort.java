package br.com.arquiteturahexagonal.application.port.out;

import br.com.arquiteturahexagonal.application.core.domain.Cotacao;

import java.util.List;

public interface CotacaoRepositoryPort {

    Cotacao saveRepository(Cotacao cotacao);
    Cotacao updateRepository(Cotacao cotacao, Long id);
    List<Cotacao> findAllRepository();
    Cotacao findByIdRepository(Long id);
    void deleteRepository(Long id);

}
