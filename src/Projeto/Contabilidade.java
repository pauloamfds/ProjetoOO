/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class Contabilidade extends CadPesRem{
    private int mes;
    private int ano;
    List<Despesa>desp;
    public Contabilidade(int mes, int ano){
        this.mes = mes;
        this.ano = ano;
        desp = new LinkedList<Despesa>();
        
        
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

    @Override
    public void cadastrar() {

    }

  /*  @Override
    public void pesquisar() {

    }*/

    @Override
    public void remover() {

    }
    
    
}
