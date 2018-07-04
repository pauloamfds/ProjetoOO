/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import javax.swing.JOptionPane;

public class Despesa{
    
	private String nome;
    
	private float valor;
    
	Categoria categoria;
    
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void setCategoria(String cat) {
    	
    	categoria = new Categoria(cat);
    	
 
    }
    
}