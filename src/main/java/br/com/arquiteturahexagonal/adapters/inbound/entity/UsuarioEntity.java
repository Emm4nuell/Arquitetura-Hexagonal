package br.com.arquiteturahexagonal.adapters.inbound.entity;

import br.com.arquiteturahexagonal.application.core.enums.PerfilEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String cpf;
    private String rg;
    private String sexo;

    @Column(unique = true)
    private String email;
    private String contato;
    private Date datanascimento;
    private LocalDateTime datacadastro;
    private String senha;
    private String foto;
    private boolean status;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "PERFIL")
    @Enumerated(EnumType.ORDINAL)
    private Set<PerfilEnums> perfilEnums = new HashSet<>();

}

