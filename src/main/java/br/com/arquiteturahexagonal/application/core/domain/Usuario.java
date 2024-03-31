package br.com.arquiteturahexagonal.application.core.domain;

import br.com.arquiteturahexagonal.application.core.enums.PerfilEnums;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class Usuario {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private String email;
    private String contato;
    private Date datanascimento;
    private LocalDateTime datacadastro;
    private String senha;
    private String foto;
    private boolean status;

    private Set<PerfilEnums> perfilEnums;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, String rg, String sexo, String email, String contato, Date datanascimento, LocalDateTime datacadastro, String senha, String foto, boolean status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.email = email;
        this.contato = contato;
        this.datanascimento = datanascimento;
        this.datacadastro = datacadastro;
        this.senha = senha;
        this.foto = foto;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public LocalDateTime getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(LocalDateTime datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<PerfilEnums> getPerfilEnums() {
        return perfilEnums;
    }

    public void setPerfilEnums(Set<PerfilEnums> perfilEnums) {
        this.perfilEnums = perfilEnums;
    }
}

