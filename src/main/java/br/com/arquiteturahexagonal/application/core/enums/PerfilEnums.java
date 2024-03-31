package br.com.arquiteturahexagonal.application.core.enums;

import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;

public enum PerfilEnums {
    ADMINISTRADOR(1, "ADMINISTRADOR"),
    SECRETARIO(2, "SECRETARIO"),
    COTACAO(3, "COTAÇÃO"),
    ORCAMENTO(4, "ORÇAMENTO"),
    DIPRO(5, "DIPRO"),
    COLABORADOR(6, "COLABORADOR");

    private Integer id;
    private String field;

    PerfilEnums(int id, String field) {
        this.id = id;
        this.field = field;
    }

    public static PerfilEnums toPerfilEnums(Integer id) {
        if(id == null){
            return PerfilEnums.COLABORADOR;
        }

        for(PerfilEnums x : PerfilEnums.values()){
            if (x.id == id){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido!");
    }
}
