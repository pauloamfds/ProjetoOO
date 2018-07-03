/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinaloo;

import Projeto.*;
import Excessoes.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Samsung
 */
public class ProjetoFinalOO {

    /**
     * @param args the command line arguments
     */
    //para definir as opcoes do meu inicial do programa
    static String opcoes[] = {"--Selecione a opcao desejada--",
                             "----Inserir dados republica---",
                             "---Cadastrar novo estudante---",
                             "------Pesquisar estudante-----",
                             "------Remover estudante-------",
                             "----Cadastar contabilidade----",
                             "---Pesquisar contabilidade----",
                             "----Remover contabilidade-----",
                             "-Gravar estudantes em arquivo-",
                             "-Remover estudate do arquivo--",
                             "Sair do program, Exit Program"};
    static Republica rep;
    static Republica republica = new Republica();
    static Republica temp;
    public static void main(String[] args) {
        // TODO code application logic here
        int a;
        
        rep = new Republica();
        
        //Estudante e = new Estudante("p", "sdf", 5623f);
        String p;
        Object op = JOptionPane.showInputDialog(null, "Informe a opcao desejada",
                                                "Cadastro Republica",
                                                 JOptionPane.QUESTION_MESSAGE,
                                                 null,
                                                 opcoes,
                                                 opcoes[0]);
        
        do{
            
        switch (op.toString()){
            case "----Inserir dados republica---": 
                dadosRepublica();
                break;
                
            case "---Cadastrar novo estudante---":
                cadastrarEstudante();
                break;
                
            case "------Pesquisar estudante-----":
                pesquisarEstudante();
                break;
                
            case "------Remover estudante-------":
                removerEstudante();
                break;
                
            case "----Cadastar contabilidade----":
                abrirContabilidade();
                break;
                
            case "---Pesquisar contabilidade----":
                pesquisarContabilidade();
                break;
                
            case "----Remover contabilidade-----":
                fecharContabilidade();
                break;
                
            case "-Gravar estudantes em arquivo-":
                gravarEstudanteArquivo();
                break;
            case "-Remover estudate do arquivo--":
                removerArquivo();
                break;
            }  
        op = JOptionPane.showInputDialog(null, "Informe a opcao desejada",
                                                "Cadastro Republica",
                                                 JOptionPane.QUESTION_MESSAGE,
                                                 null,
                                                 opcoes,
                                                 opcoes[0]);
        }while(!op.toString().equalsIgnoreCase(opcoes[10])); 
        
    
    }

    private static void dadosRepublica() {
        temp = new Republica();
        rep = temp.dadosRepublica();
    }

    private static void cadastrarEstudante() {
        
    	boolean resposta = false;									//FLAG DE SUCESSO
        
        // OP합ES PARA O JOPTIONPANE
        String stringOP[] = {"--Selecione a opcao desejada--",
        				"--------Inserir arquivo-------",
        				"------Inserir Manualmente----"};
        
        Object op = JOptionPane.showInputDialog(null, "Informe a opcao desejada",
                "Cadastro de Estudantes",
                 JOptionPane.QUESTION_MESSAGE,
                 null,
                 stringOP,
                 stringOP[0]);
        
        // METODOS PARA DE ACORDO COM A SELE플O ACIMA
        
        switch (op.toString()){
        case "--------Inserir arquivo-------":
            resposta = rep.lerArquivoEstudantes();
            
            if (resposta){
                JOptionPane.showMessageDialog(null, "Dados lidos com sucesso");
            }
        	break;
        
        case "------Inserir Manualmente----": 
            try{
                resposta = rep.cadastrarEstudante();
            }catch(DadosIncompletosException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                
            }
            if (resposta){
                JOptionPane.showMessageDialog(null, "Estudante cadastrado com sucesso");
                }
            break;
        }
        
    }

    private static Estudante pesquisarEstudante() {
            String pesquisa = JOptionPane.showInputDialog(null, "Informe o nome a ser pesquisado");
            Estudante tempo;
            tempo = new Estudante();
            tempo = rep.pesquisarEstudante(pesquisa);
            if(tempo == null){
                JOptionPane.showMessageDialog(null, "Estudante n찾o encontrado");
            }
            return tempo;
    }

    private static void removerEstudante() {
        boolean deletado = false;
        int confirma;
        Estudante e = pesquisarEstudante();
        if(e != null){
        confirma = JOptionPane.showConfirmDialog(null, 
                                    "Deseja mesmo remover estudante?", "Remover",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirma == JOptionPane.YES_OPTION){
            deletado = rep.removerEstudante(e);
        }
         if(deletado){
            JOptionPane.showMessageDialog(null, "Estudante removido");
        }
        else{
            JOptionPane.showMessageDialog(null, "Estudante n찾o foi removido");
        }
        }
        
        
       
    }

    private static void abrirContabilidade() {

    }

    private static void pesquisarContabilidade() {

    }

    private static void fecharContabilidade() {

    }

    // ADICIONAR ESTUDANTES NO ARQUIVO
    private static void gravarEstudanteArquivo() {
    	
    	boolean resposta = false;						// FLAG DE SUCESSO
    	
        resposta = rep.gravarArquivoEstudantes();		// CHAMA O METODO PARA ADICIONAR ESTUDANTES EM ARQUIVO
             
         if (resposta){									// TESTE DE SUCESSO
             JOptionPane.showMessageDialog(null, "Estudante(s) armazenado(s) com sucesso");	// MENSAGEM DE SUCESSO
         }
    }

    private static void removerArquivo() {

    }
}