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
public class Estudante {
    private String nome;
    private String email;
    private float rendimentos;

    Estudante(String nome, String email, float rendimentos){
        this.nome = nome;
        this.email = email;
        this.rendimentos = rendimentos;
    }

    Estudante() {
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(float rendimentos) {
        this.rendimentos = rendimentos;
    }
    
    
    
}
