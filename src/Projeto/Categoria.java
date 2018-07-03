/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class Categoria {
    private String descricao;
    Despesa desp;//uma categoria contem uma despesa
    List<Categoria> subCat; //uma categoria pode contar varias sub
    
    public Categoria(String descricao){
        this.descricao = descricao;
       
    }

    public Categoria() {
        desp = new Despesa();
        subCat = new LinkedList<Categoria>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
