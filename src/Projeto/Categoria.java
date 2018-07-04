/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import java.util.LinkedList;
import java.util.List;


public class Categoria {
    
	private String descricao;
	
	List<Categoria> subCat;
    
    public Categoria(String descricao){
        this.descricao = descricao;
       
    }
   
    public void inserirSubcategoria(){
    	
    	subCat = new LinkedList<Categoria>();
    	
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
