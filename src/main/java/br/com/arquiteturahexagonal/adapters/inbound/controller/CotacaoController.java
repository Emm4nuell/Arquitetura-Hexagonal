package br.com.arquiteturahexagonal.adapters.inbound.controller;

import br.com.arquiteturahexagonal.adapters.mapper.dto.CotacaoDto;
import br.com.arquiteturahexagonal.application.core.domain.Cotacao;
import br.com.arquiteturahexagonal.application.port.in.CotacaoServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoServicePort cotacaoServicePort;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<CotacaoDto> save(@RequestBody CotacaoDto dto){
        Cotacao material = cotacaoServicePort.saveService(mapper.map(dto, Cotacao.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(material, CotacaoDto.class));
    }

    @GetMapping
    public ResponseEntity<List<CotacaoDto>> findAll(){
        List<CotacaoDto> dtos = cotacaoServicePort.findAllService().stream()
                .map(x -> mapper.map(x, CotacaoDto.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
