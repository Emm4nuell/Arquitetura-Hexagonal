package br.com.arquiteturahexagonal.adapters.mapper.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioAuthDto {

    @NotBlank(message = "Campo usuario é obrigatório!")
    private String cpf;
    @NotBlank(message = "Campo senha é obrigatório!")
    private String senha;
    private List<String> roles;
    private String token;
}
