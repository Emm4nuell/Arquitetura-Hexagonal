package br.com.arquiteturahexagonal.application.core.service;

import br.com.arquiteturahexagonal.application.core.domain.Empresa;
import br.com.arquiteturahexagonal.application.port.in.EmpresaServicePort;
import br.com.arquiteturahexagonal.application.port.out.EmpresaRepositoryPort;

import java.util.ArrayList;
import java.util.List;

public class EmpresaService implements EmpresaServicePort {

    private final EmpresaRepositoryPort empresaRepositoryPort;

    public EmpresaService(EmpresaRepositoryPort empresaRepositoryPort) {
        this.empresaRepositoryPort = empresaRepositoryPort;
    }

    @Override
    public Empresa saveService(Empresa empresa) {
        return empresaRepositoryPort.saveRepository(empresa);
    }

    @Override
    public Empresa updateService(Empresa empresa, Long id) {
        Empresa emp = empresaRepositoryPort.updateRepository(empresa, id);
        empresa.setId(emp.getId());
        return saveService(empresa);
    }

    @Override
    public List<Empresa> findAllService() {
        List<Empresa> empresas =  empresaRepositoryPort.findAllRepository();
        if (empresas == null){
            return new ArrayList<>();
        }
        return empresas;
    }

    @Override
    public Empresa findByIdService(Long id) {
        return empresaRepositoryPort.findByIdRepository(id);
    }

    @Override
    public void deleteService(Long id) {
        findByIdService(id);
        empresaRepositoryPort.deleteRepository(id);
    }
}
