/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;


public class Contabilidade {
    
	private int mes;
    
	private int ano;
    
	List<Despesa> despesas;
    
    public Contabilidade(){
        
    }
    
    public Contabilidade(int mes, int ano){
        
    	this.mes = mes;
        
        this.ano = ano;
        
        despesas = new LinkedList<Despesa>();
         
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

   
    public boolean cadastrarDespesa() {
    
    	boolean resposta = false;
        
    	Despesa temp_despesa = new Despesa();
    	
    	if (despesas == null) {
    		
    		despesas = new LinkedList<>();
    	}
    	
    	int sair;
    	
    	int subCategoria;
    	
		temp_despesa.setNome(JOptionPane.showInputDialog(null,"Informe o nome da despesa:"));
    	
		temp_despesa.setValor(Float.parseFloat(JOptionPane.showInputDialog(null,"Informe o valor da despesa:")));
		
		temp_despesa.setCategoria();
		    		
		resposta = despesas.add(temp_despesa);
    			            
    	return resposta;
    }

  
    public Despesa pesquisarDespesa(String nomeProcurado) {

    	Despesa resposta = null;
    	
    	Iterator<Despesa> it = despesas.iterator();
        
    	int i = 0;
    	
    	while(it.hasNext()){     
    		
    		Despesa desp = it.next();
    		
    		if(desp.getNome().equalsIgnoreCase(nomeProcurado)){
    			
    			JOptionPane.showMessageDialog(null, "Nome encontrado, posicao: " + i);
                
    			JOptionPane.showMessageDialog(null, desp.toString());
    			
    			resposta = desp;
    		}
    		
    		i++;
    		
    	}
    	// implementar toString dentro de estudante
		return resposta;
    	
    }

    
    //public void remover() {

    //}
    
    // SOMATORIO DA CONTABILIDADE
    public float valorTotalContabilidade() {
    	
    	float valorDespesa = 0f;
    	
    	Iterator<Despesa> it = despesas.iterator();
        
    	int i = 0;
    	
    	while(it.hasNext()){     
    		
    		Despesa desp = it.next();
    		
    		valorDespesa +=desp.getValor();
    		
    		i++;
    		
    	}
    	
    	return valorDespesa;
    }

    @Override
    public String toString() {
        return "Mes: " + mes + "\nAno=" + ano;
    }
    
    
    
}
