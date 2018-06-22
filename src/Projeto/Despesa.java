/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

/**
 *
 * @author Samsung
 */
public class Despesa extends CadPesRem {
    private String nome;
    private float valor;
    Categoria cat = new Categoria();
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

    @Override
    public void cadastrar() {

    }
/*
    @Override
    public void pesquisar() {

    }
*/
    @Override
    public void remover() {

    }
    
    
    
}
