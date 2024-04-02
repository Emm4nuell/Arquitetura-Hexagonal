package br.com.arquiteturahexagonal.adapters.inbound.controller;

import br.com.arquiteturahexagonal.adapters.mapper.dto.MaterialDto;
import br.com.arquiteturahexagonal.application.core.domain.Material;
import br.com.arquiteturahexagonal.application.port.in.MaterialServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialServicePort materialServicePort;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<MaterialDto> save(@RequestBody MaterialDto dto){
        Material material = materialServicePort.saveService(mapper.map(dto, Material.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(material, MaterialDto.class));
    }

    @GetMapping
    public ResponseEntity<List<MaterialDto>> findAll(){
        List<MaterialDto> dtos = materialServicePort.findAllService().stream()
                .map(x -> mapper.map(x, MaterialDto.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
