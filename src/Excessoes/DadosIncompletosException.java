/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excessoes;

/**
 *
 * @author Samsung
 */
public class DadosIncompletosException extends Exception{
    public DadosIncompletosException(){
        super("Dados do estudante estão incompletos");
    }
    
}
