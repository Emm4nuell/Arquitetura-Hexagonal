package br.com.arquiteturahexagonal.application.port.in;

import br.com.arquiteturahexagonal.application.core.domain.Empresa;

import java.util.List;

public interface EmpresaServicePort {

    Empresa saveService(Empresa empresa);
    Empresa updateService(Empresa empresa, Long id);
    List<Empresa> findAllService();
    Empresa findByIdService(Long id);
    void deleteService(Long id);

}
