package br.com.arquiteturahexagonal.application.port.in;

import br.com.arquiteturahexagonal.application.core.domain.Cotacao;

import java.util.List;

public interface CotacaoServicePort {

    Cotacao saveService(Cotacao cotacao);
    Cotacao updateService(Cotacao cotacao, Long id);
    List<Cotacao> findAllService();
    Cotacao findByIdService(Long id);
    void deleteService(Long id);

}
