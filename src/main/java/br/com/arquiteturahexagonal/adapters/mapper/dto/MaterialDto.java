package br.com.arquiteturahexagonal.adapters.mapper.dto;

import br.com.arquiteturahexagonal.adapters.inbound.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto {

    private Long id;
    private LocalDateTime datacriacao;
    private Date dataconclusao;
    private String prioridade;
    private String descricao;
    private Long quantidade;
    private boolean status;
    private String andamento;
    private double mediavalor;
    private double minvalor;
    private double maxvalor;
    private String observacao;
    private String arquivo;
//    private UsuarioDto usuarioDto;
    private List<CotacaoDto> cotacaoDtos;
}
