/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import Excessoes.CategoriaNaoInformadaException;
import Excessoes.DescricaoNaoInformadaException;
import Excessoes.ValorNaoInformadoException;
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

   
    public boolean cadastrarDespesa() throws CategoriaNaoInformadaException, ValorNaoInformadoException, DescricaoNaoInformadaException {
    
    	boolean resposta = false;
        String cat, no, val;
    	Despesa temp_despesa = new Despesa();
    	
    	if (despesas == null) {
    		
    		despesas = new LinkedList<>();
    	}
    	
    	int sair;
    	
    	int subCategoria;
    	
		no = JOptionPane.showInputDialog(null,"Informe o nome da despesa:");
    	
		val = JOptionPane.showInputDialog(null,"Informe o valor da despesa:");
		
		cat = JOptionPane.showInputDialog("Informe a categoria da despesa");
		    		
		resposta = despesas.add(temp_despesa);
                if(no == null || no.trim().equals(""))
                    throw new DescricaoNaoInformadaException();
                else
                    temp_despesa.setNome(no);
                if(val == null || val.trim().equals(""))
                    throw new ValorNaoInformadoException();
                else
                    temp_despesa.setValor(Float.parseFloat(val));
                if (cat == null || cat.trim().equals(""))
                    throw new CategoriaNaoInformadaException();
                else
                    temp_despesa.setCategoria(cat);
    			            
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
