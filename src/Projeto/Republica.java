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

/**
 *
 * @author Samsung
 */
public class Republica extends CadPesRem{
    
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

    public void setEndereco(String endereço) {
        this.endereco = endereço;
    }

    @Override
    public void cadastrar() {
        Estudante temp = new Estudante();

        temp.setNome(JOptionPane.showInputDialog(null," Informe o nome do estudante"));
        temp.setEmail(JOptionPane.showInputDialog(null," Informe o email do estudante"));
        temp.setRendimentos(Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor dos rendimentos")));
        boolean resposta = estud.add(temp);

    }

    //@Override
    public void pesquisar(String title) {
        Iterator<Estudante> it = estud.iterator();
        System.out.println("Antes do while");
        int i = 0;
  while(it.hasNext())
  {     Estudante a = it.next();
        System.out.println("Dentro do while");
     if(a.getNome().equalsIgnoreCase(title))
     {
         JOptionPane.showMessageDialog(null, "Nome encontrado, posicao: " + i);
     }
     i++;
  }
    }

    @Override
    public void remover() {

    }
    //metodos usados para mudar contabilidade
    public boolean abrirContabilidade(Contabilidade a){
        boolean resposta = conta.add(a);
        return resposta;
    }
    public boolean fecharContabilidade(Contabilidade a){
        boolean resposta = conta.remove(a);
        return resposta;
        
    }
    
    
}
