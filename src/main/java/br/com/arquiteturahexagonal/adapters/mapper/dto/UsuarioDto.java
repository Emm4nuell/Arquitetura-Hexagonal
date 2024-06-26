package br.com.arquiteturahexagonal.adapters.mapper.dto;

import br.com.arquiteturahexagonal.application.core.enums.PerfilEnums;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id;

    @NotBlank(message = "Campo nome é obrigatório!")
    private String nome;
    @NotBlank(message = "Campo cpf é obrigatório!")
    private String cpf;
    private String rg;
    private String sexo;
    @NotBlank(message = "Campo email é obrigatório!")
    private String email;
    private String contato;
    private Date datanascimento;
    private LocalDateTime datacadastro;
    @NotBlank(message = "Campo senha é obrigatório!")
    private String senha;
    private String foto;
    private boolean status;
    private Set<PerfilEnums> perfilEnums;

    private List<MaterialDto> materialDtos;
    
}
