package br.com.arquiteturahexagonal.adapters.outbound.repository;

import br.com.arquiteturahexagonal.adapters.inbound.entity.CotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<CotacaoEntity, Long> {
}
