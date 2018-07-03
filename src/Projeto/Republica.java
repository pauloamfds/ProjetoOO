/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import Excessoes.DadosIncompletosException;
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
    List<Estudante>estud;

    public Republica(){
        conta = new LinkedList<Contabilidade>();
        estud = new LinkedList<Estudante>();
        this.nome = null;
        this.endereco = null;
    }

    public Republica(String nome, String endereco) {
        this.endereco = endereco;
        this.nome = nome;
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

    public boolean cadastrarEstudante() throws DadosIncompletosException {
        
    	boolean resposta = false;
        boolean f = true;
    	Estudante temp = new Estudante();
        if(estud == null)
            estud = new LinkedList<Estudante>();
        
        
        String name = (JOptionPane.showInputDialog(null," Informe o nome do estudante"));
        String email = (JOptionPane.showInputDialog(null," Informe o email do estudante"));
        Float rend = 0f;
        String rendi = "1";
        rendi = (JOptionPane.showInputDialog(null, "Informe o valor dos rendimentos"));
        if(name == null || name.trim().equals("")
           || email == null || email.trim().equals("")
            || rendi == null || rendi.trim().equals("")){
            f = false;
            throw new DadosIncompletosException();
            
        }
        if (f){
            rend = Float.parseFloat(rendi);
            temp.setNome(name);
            temp.setEmail(email);
            temp.setRendimentos(rend);
            resposta = estud.add(temp);

        }
        
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
                        JOptionPane.showMessageDialog(null, a.toString());
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
		
		FileReader arquivo = null;						// CRIA UM OBJETO PARA LER O ARQUIVO
		
		BufferedReader buffer;							// CRIA UM BUFFER PARA ARMAZENAR TEMP. O ARQUIVO
		
		boolean resposta = false;						// FLAG DE SUCESSO
		
		try {											// TENTA LER O ARQUIVO
			
			arquivo = new FileReader("alunos.txt");		// PEGA O VALOR DO ARQUIVO
			
		} catch (FileNotFoundException e) {				// CASO HAJA ALGUM ERRO
			
			e.printStackTrace();						// PRINTA O VALOR DO ERRO
		
		}
		
		buffer = new BufferedReader(arquivo);			// ARMAZENA OS ARQUIVOS NO BUFFER TEMPORARIO
		
		
		String line = "";								// INICIA A STRING AUXILIAR
		
		try {
		
			line = buffer.readLine();					// TENTA LER UMA LINHA
		
		} catch (IOException e) {						// CASO HAJA ALGUM ERRO
		
			e.printStackTrace();						// PRINTA O VALOR DO ERRO
		
		}
		
		do {
			String[] campos = line.split(";");			// SEPARA AS LINHAS DE ACORDO COM O ';'
			
			float rendimentos = Float.parseFloat(campos[2]);	// RENDIMENTO DO ESTUDANTE
			
			
			Estudante est = new Estudante(campos[0],campos[1],rendimentos);	// CRIA UM ESTUDANTE DE ACORDO COM OS VALORES LIDOS NO ARQUIVO
			
			if (estud == null) 							// CASO NÃO TENHA A LISTA DE ESTUDANTES
				estud = new LinkedList<Estudante>();	// CRIA A LISTA DE ESTUDANTES
			
			resposta = estud.add(est);					// CRIA UM OBJETO DO TIPO ESTUDANTE DE ACORDO COM OS VALORES PRESENTES NA LINHA DO ARQUIVO
			
			try {								// TENTA LER A LINHA
				
				line = buffer.readLine();		// LÊ A LINHA
			
			} catch (IOException e) {			// CASO HAJA ALGUM ERRO
			
				e.printStackTrace();			// PRINTA O VALOR
			
			}
			
		} while (line != null);					// REALIZA O LOOP ENQUANTE TIVER LINHAS
		
		return resposta;						// RETORNA A FLAG DE SUCESSO
	}
	
	// METODO DESTINADO 'A ESCRITA DE ARQUIVOS	- ESTUDANTE
	public boolean gravarArquivoEstudantes() {
			
			boolean resposta = false;							// FLAG DE SUCESSO DO METODO
			
			FileWriter arquivo = null;							// CRIA UM OBJETO PARA ARMAZENAR OS DADOS		
			
			try {												// PRIMEIRA TENTATIVA PARA REALIZAR A ESCRITA
				
				arquivo = new FileWriter("alunos.txt");			// FAZ UM LINK ENTRE O ARQUIVO E O OBJETO
			
			} catch (IOException e) {							// CASO OCORRA ALGUM ERRO, PRINTA A EXCESSï¿½O
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
        
    @Override
    public String toString(){
        return "Nome: " + getNome() + '\n' + "Endereco: " + getEndereco();
    }
    
    //funcao para informar os dados da republica
    public Republica dadosRepublica() {
        String nome = JOptionPane.showInputDialog(null, "Nome da republica");
        String end = JOptionPane.showInputDialog(null, "Endereco republica");
        Republica temp = new Republica();
        temp.setNome(nome);
        temp.setEndereco(end);
        while(temp.getNome()== null || temp.getNome().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Dados republica invalidos, informe os dados");
            nome = JOptionPane.showInputDialog(null, "Nome da republica");
            end = JOptionPane.showInputDialog(null, "Endereco republica");
            temp.setNome(nome);
            temp.setEndereco(end);
        }
        JOptionPane.showMessageDialog(null, "Republica cadastrada com sucesso!!");
        JOptionPane.showMessageDialog(null, temp.toString());
        
        return temp;
    }
    
   
}
    
