package br.com.arquiteturahexagonal.application.utils.strategy;

import br.com.arquiteturahexagonal.application.core.domain.Cotacao;

import java.util.List;

public interface PrecoStrategy {
    double calcular(List<Cotacao> precos);
}
