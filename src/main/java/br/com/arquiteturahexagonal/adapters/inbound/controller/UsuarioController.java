package br.com.arquiteturahexagonal.adapters.inbound.controller;

import br.com.arquiteturahexagonal.adapters.mapper.usuario.UsuarioDto;
import br.com.arquiteturahexagonal.application.core.domain.Usuario;
import br.com.arquiteturahexagonal.application.port.in.UsuarioServicePort;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("hexagonal")
public class UsuarioController {

    @Autowired
    private UsuarioServicePort usuarioServicePort;

    @Autowired
    private ModelMapper mapper;


    @PostMapping
    public ResponseEntity<UsuarioDto> save(@RequestBody @Valid UsuarioDto dto){
        Usuario usuario = usuarioServicePort.saveService(mapper.map(dto, Usuario.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(usuario, UsuarioDto.class));

    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> findAll(){
        List<UsuarioDto> dtos = usuarioServicePort.findAllService().stream().map(x -> mapper.map(x , UsuarioDto.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(usuarioServicePort.findByIdService(id), UsuarioDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto dto, @PathVariable Long id){
        Usuario usuario = usuarioServicePort.updateService(mapper.map(dto, Usuario.class), id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(usuario, UsuarioDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioServicePort.deleteService(id);
        return ResponseEntity.ok().build();
    }

}
