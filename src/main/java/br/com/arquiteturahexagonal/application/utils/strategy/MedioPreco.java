package br.com.arquiteturahexagonal.application.utils.strategy;

import br.com.arquiteturahexagonal.application.core.domain.Cotacao;

import java.util.List;

public class MedioPreco implements PrecoStrategy{
    private double p = 0.00;
    @Override
    public double calcular(List<Cotacao> precos) {
        precos.forEach(e -> {
            this.p += e.getPrecototal();
        });
        return this.p/precos.size();
    }
}
