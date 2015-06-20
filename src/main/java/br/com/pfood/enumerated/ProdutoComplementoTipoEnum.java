/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.enumerated;

/**
 *
 * @author palazzio
 */
public enum ProdutoComplementoTipoEnum {
    
    PADRAO(1 , "Padrao"),
    ADICIONAL (2 , "Adicionais"),
    OPCIONAL (3 , "Opcionais");
    
    private int tipo;
    private String descricao;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private ProdutoComplementoTipoEnum(int tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }
    
    
    
}
