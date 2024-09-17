/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage.bank;

/**
 *
 * @author Engº António Vicente
 */
public class Cliente {
    //Variavel contador para contar o numero de clientes
    private static int contador = 1;
    // iniciando a criacao da classe clinete 
    private String nome = "";
    private String nif = "";
    private int numClie = 0;
 
    //construtor da classe Cliente
    public Cliente(String nome, String nif) {
        this.nome = nome;
        this.nif = nif;
        this.numClie = contador;
        contador += 1;
    }
    //Gerando os nosso getter e setres 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumClie() {
        return numClie;
    }

    public void setNumClie(int numClie) {
        this.numClie = numClie;
    }
    
    
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    } 
    
    //Metodo toString para fazer a impressao dos dados dos nossos clientes na tela
    @Override
    public String toString() { 
        return  "Numero de cliente: " + getNumClie()+ " " +
                "Nome: " + getNome() + " "+
                 "Nif: " + getNif()+" ";
    }            
    
}
