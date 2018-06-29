/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinaloo;

import Projeto.*;
import Excessoes.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Samsung
 */
public class ProjetoFinalOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a;
        Republica rep = new Republica("OO", "I7");
        //Estudante e = new Estudante("p", "sdf", 5623f);
        String p;
        

        do{ 
            rep.cadastrar();
            a = JOptionPane.showConfirmDialog(null, "Deseja entrar com a contabilidade?");
        }while(a == JOptionPane.YES_OPTION);
        //JOptionPane.showMessageDialog(null, "Deseja entrar com uma nova contabilidade", "Contabilidade", JOptionPane.CANCEL_OPTION);    
        do{
            p = JOptionPane.showInputDialog(null, "Informe o nome a ser pesquisado");
            rep.pesquisar(p);
            a = JOptionPane.showConfirmDialog(null, "Desja pesquisar outro nome");
           
        }while(a == JOptionPane.YES_OPTION);
    }
    
}
