package br.com.arquiteturahexagonal.adapters.outbound.repository;

import br.com.arquiteturahexagonal.adapters.inbound.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
