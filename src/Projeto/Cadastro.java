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


/* CLASSE DESTINA A LEITURA|ESCRITA, EM ARQUIVOS.TXT, DO PROJETO DE ORIENTAÇÃO A OBJETOS 
 * 
 */

public class Cadastro {

	// ATRIBUTOS:
	List <Estudante> estudante;						// CRIA UMA LISTA DE ESTUDANTES

	// METODOS:
	
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
		
		Iterator<Estudante> it = estudante.iterator();			// CRIA UM ITERADOR
		
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
	
	// METODO DESTINADO À LEITURA DE ARQUIVOS - ESTUDANTE
	public boolean lerArquivoEstudantes() {
		
		FileReader arquivo = null;
		
		BufferedReader buffer;
		
		boolean resposta; 
		
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
			
			if (estudante == null) 
				estudante = new LinkedList<Estudante>();
			
			resposta = estudante.add(est);
			
			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} while (line != null);
		
		return resposta;
	}

}
