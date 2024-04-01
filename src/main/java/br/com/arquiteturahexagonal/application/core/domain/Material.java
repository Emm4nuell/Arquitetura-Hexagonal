package br.com.arquiteturahexagonal.application.core.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Material {

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
    private Usuario usuario;

    public Material() {
    }

    public Material(Long id, LocalDateTime datacriacao, Date dataconclusao, String prioridade, String descricao, Long quantidade, boolean status, String andamento, double mediavalor, double minvalor, double maxvalor, String observacao, String arquivo, Usuario usuario) {
        this.id = id;
        this.datacriacao = datacriacao;
        this.dataconclusao = dataconclusao;
        this.prioridade = prioridade;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.status = status;
        this.andamento = andamento;
        this.mediavalor = mediavalor;
        this.minvalor = minvalor;
        this.maxvalor = maxvalor;
        this.observacao = observacao;
        this.arquivo = arquivo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(Date dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAndamento() {
        return andamento;
    }

    public void setAndamento(String andamento) {
        this.andamento = andamento;
    }

    public double getMediavalor() {
        return mediavalor;
    }

    public void setMediavalor(double mediavalor) {
        this.mediavalor = mediavalor;
    }

    public double getMinvalor() {
        return minvalor;
    }

    public void setMinvalor(double minvalor) {
        this.minvalor = minvalor;
    }

    public double getMaxvalor() {
        return maxvalor;
    }

    public void setMaxvalor(double maxvalor) {
        this.maxvalor = maxvalor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
