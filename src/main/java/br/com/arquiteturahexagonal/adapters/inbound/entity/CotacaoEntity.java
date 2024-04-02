package br.com.arquiteturahexagonal.adapters.inbound.entity;

import br.com.arquiteturahexagonal.application.core.domain.Empresa;
import br.com.arquiteturahexagonal.application.core.domain.Material;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cotacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_material")
    private MaterialEntity material;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

}
