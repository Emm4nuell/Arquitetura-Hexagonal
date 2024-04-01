package br.com.arquiteturahexagonal.application.core.domain;

import java.time.LocalDateTime;

public class Cotacao {

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

    public Cotacao() {
    }

    public Cotacao(Long id, LocalDateTime datacriacao, boolean status, String descricao, String vendedor, String arquivo, double preco, double frete, double precototal, String quantidade, String url, String observacao, Material material, Empresa empresa) {
        this.id = id;
        this.datacriacao = datacriacao;
        this.status = status;
        this.descricao = descricao;
        this.vendedor = vendedor;
        this.arquivo = arquivo;
        this.preco = preco;
        this.frete = frete;
        this.precototal = precototal;
        this.quantidade = quantidade;
        this.url = url;
        this.observacao = observacao;
        this.material = material;
        this.empresa = empresa;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getPrecototal() {
        return precototal;
    }

    public void setPrecototal(double precototal) {
        this.precototal = precototal;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
