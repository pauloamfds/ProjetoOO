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
    List<Despesa>desp;
    
    
    public Categoria(String descricao){
        this.descricao = descricao;
        desp = new LinkedList<Despesa>();
    }

    Categoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
