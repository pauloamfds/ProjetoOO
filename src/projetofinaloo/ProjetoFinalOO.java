/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinaloo;

import Projeto.*;
import Excessoes.*;
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
                gravarArquivo();
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
        String nome = JOptionPane.showInputDialog(null, "Nome da republica");
        String end = JOptionPane.showInputDialog(null, "Endereco republica");
        Republica temp = new Republica();
        temp.setNome(nome);
        temp.setEndereco(end);
        
        republica = temp;
        
        if (republica.getNome()!= null){
            JOptionPane.showMessageDialog(null, "Republica cadastrada com sucesso");
            JOptionPane.showMessageDialog(null, republica.toString());
        }
        else
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar");
    }

    private static void cadastrarEstudante() {

    }

    private static void pesquisarEstudante() {

    }

    private static void removerEstudante() {

    }

    private static void abrirContabilidade() {

    }

    private static void pesquisarContabilidade() {

    }

    private static void fecharContabilidade() {

    }

    private static void gravarArquivo() {

    }

    private static void removerArquivo() {

    }
}