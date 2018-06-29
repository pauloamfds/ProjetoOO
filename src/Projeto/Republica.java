/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Samsung
 */
public class Republica{
    
    private String nome;
    private String endereco;
    List<Contabilidade>conta;
    List<Estudante>estud = new LinkedList<Estudante>();

    public Republica(){
        conta = new LinkedList<Contabilidade>();
    }

    public Republica(String oo, String i7) {
        this.endereco = i7;
        this.nome = oo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    public boolean cadastrarEstudante() {
        
    	boolean resposta = false;
    	Estudante temp = new Estudante();

        temp.setNome(JOptionPane.showInputDialog(null," Informe o nome do estudante"));
        temp.setEmail(JOptionPane.showInputDialog(null," Informe o email do estudante"));
        temp.setRendimentos(Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor dos rendimentos")));
        
        resposta = estud.add(temp);
        
        return resposta;
    }

    
    public Estudante pesquisarEstudante(String title) {
        
    	Estudante resposta = null;
    	
    	Iterator<Estudante> it = estud.iterator();
        
    	System.out.println("Antes do while");
        
    	int i = 0;
    	
    	while(it.hasNext()){     
    		
    		Estudante a = it.next();
    		System.out.println("Dentro do while");
    		
    		if(a.getNome().equalsIgnoreCase(title)){
    			JOptionPane.showMessageDialog(null, "Nome encontrado, posicao: " + i);
    			resposta = a;
    		}
    		i++;
    		}
    	// implementar toString dentro de estudante
		return resposta;
    	
    }

    
    public boolean removerEstudante(Estudante e) {
    	
    	boolean resposta = false;
    	
    	if (estud.contains(e)) {
    		resposta = estud.remove(e);
    	}
    	    	
    	return resposta;
    }
    
    //metodos usados para mudar contabilidade
    public boolean abrirContabilidade(Contabilidade a){
    	boolean resposta = false;
    	resposta = conta.add(a);
        return resposta;
    }
    
    public boolean fecharContabilidade(Contabilidade a){
    	boolean resposta =false;
    	resposta = conta.remove(a);
        return resposta;
        
    }
    
    public Contabilidade pesquisarContabilidade(int mes, int ano) {
    	
    	Contabilidade resposta = null;
    	
    	
    	
    	return resposta;
    }

	public boolean lerArquivoEstudantes() {
		
		FileReader arquivo = null;
		
		BufferedReader buffer;
		
		boolean resposta = false;
		
		try {
			
			arquivo = new FileReader("alunos.txt");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		}
		
		buffer = new BufferedReader(arquivo);
		
		
		String line = "";
		
		try {
		
			line = buffer.readLine();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
		
		do {
			String[] campos = line.split(";");
			
			float rendimentos = Integer.parseInt(campos[2]);
			
			
			Estudante est = new Estudante(campos[0],campos[1],rendimentos);
			
			if (estud == null) 
				estud = new LinkedList<Estudante>();
			
			resposta = estud.add(est);
			
			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} while (line != null);
		
		return resposta;
	}
	
	// METODO DESTINADO À ESCRITA DE ARQUIVOS	- ESTUDANTE
	public boolean gravarArquivoEstudantes() {
			
			boolean resposta = false;							// FLAG DE SUCESSO DO METODO
			
			FileWriter arquivo = null;							// CRIA UM OBJETO PARA ARMAZENAR OS DADOS		
			
			try {												// PRIMEIRA TENTATIVA PARA REALIZAR A ESCRITA
				
				arquivo = new FileWriter("alunos.txt");			// FAZ UM LINK ENTRE O ARQUIVO E O OBJETO
			
			} catch (IOException e) {							// CASO OCORRA ALGUM ERRO, PRINTA A EXCESSÃO
				e.printStackTrace();
			}
			BufferedWriter buffer = new BufferedWriter(arquivo);	// CRIA UM OBJETO PARA ARMAZENAR TEMPORARIAMENTE OS DADOS
			
			Iterator<Estudante> it = estud.iterator();			// CRIA UM ITERADOR
			
			while (it.hasNext()) {									// REALIZA O LOOP ENQUANTO TIVER ELEMENTO NA LISTA
				
				Estudante est = it.next();							// EST RECEBE O PROXIMO OBJETO DA LISTA
				
				String str = "";									// INICIA A STRING
				
				str += est.getNome() + ";";							// ADICIONA O 'NOME' NA STRING
				
				str += est.getEmail() + ";";						// ADICIONA O 'EMAIL' NA STRING
				
				str += est.getRendimentos() + ";";					// ADICIONA O 'RENDIMENTO' NA STRING
						
				try {											// REALIZA A PRIMEIRA TENTATIVA DE ESCRITA
					
					buffer.write(str);							// REALIZA A ESCRITA
					
					buffer.newLine();							// CRIA UMA NOVA LINHA
					
				} catch (IOException e) {						// CASO OCORRA ALGUM ERRO
					
					e.printStackTrace();						// PRINTA O ERRO OCORRIDO 
				}
				
			}
			
			try {								// REALIZA A PRIMEIRA TENTATIVA DE FECHAR O ARQUIVO					
				
				buffer.close();					// FECHA O ARQUIVO
				
				resposta = true;				// FLAG DE SUCESSO
					
			} catch (IOException e) {			// CASO OCORRA ALGUM ERRO
				
				e.printStackTrace();			// PRINTA O ERRO 
			}
			
			return resposta;					// RETORNA A FLAG DE SUCESSO|ERRO
		}
}
