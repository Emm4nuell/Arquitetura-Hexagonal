package br.com.arquiteturahexagonal.adapters.inbound.entity;

import br.com.arquiteturahexagonal.adapters.mapper.dto.CotacaoDto;
import br.com.arquiteturahexagonal.application.core.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY)
    private List<CotacaoEntity> cotacoes;

}
