package br.com.arquiteturahexagonal.adapters.inbound.controller;

import br.com.arquiteturahexagonal.adapters.mapper.dto.EmpresaDto;
import br.com.arquiteturahexagonal.application.core.domain.Empresa;
import br.com.arquiteturahexagonal.application.core.domain.Material;
import br.com.arquiteturahexagonal.application.port.in.EmpresaServicePort;
import br.com.arquiteturahexagonal.application.port.in.MaterialServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaServicePort empresaServicePort;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<EmpresaDto> save(@RequestBody EmpresaDto dto){
        Empresa empresa = empresaServicePort.saveService(mapper.map(dto, Empresa.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(empresa, EmpresaDto.class));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDto>> findAll(){
        List<EmpresaDto> dtos = empresaServicePort.findAllService().stream()
                .map(x -> mapper.map(x, EmpresaDto.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
