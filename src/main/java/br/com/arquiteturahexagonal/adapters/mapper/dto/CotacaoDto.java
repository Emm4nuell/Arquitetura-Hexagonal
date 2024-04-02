package br.com.arquiteturahexagonal.adapters.mapper.dto;

import br.com.arquiteturahexagonal.application.core.domain.Empresa;
import br.com.arquiteturahexagonal.application.core.domain.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoDto {

    private Long id;
    private LocalDateTime datacriacao;
    private boolean status;
    private String descricao;
    private String vendedor;
    private String arquivo;
    private double preco;
    private double frete;
    private double precototal;
    private String quantidade;
    private String url;
    private String observacao;
    private Material material;
    private Empresa empresa;

}
