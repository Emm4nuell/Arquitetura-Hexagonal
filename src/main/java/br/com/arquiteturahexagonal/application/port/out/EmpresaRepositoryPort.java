package br.com.arquiteturahexagonal.application.port.out;

import br.com.arquiteturahexagonal.application.core.domain.Empresa;

import java.util.List;

public interface EmpresaRepositoryPort {

    Empresa saveRepository(Empresa empresa);
    Empresa updateRepository(Empresa empresa, Long id);
    List<Empresa> findAllRepository();
    Empresa findByIdRepository(Long id);
    void deleteRepository(Long id);

}
