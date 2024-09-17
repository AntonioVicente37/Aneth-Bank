/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage.bank;

import ferramentas.formatacao;


/**
 *
 * @author Engº António Vicente
 */
public class ContaPoupanca{
    private static int contadorP = 1;    
    private static int contadorIban = 2022014;
    //Classe responsavel pela a criacao da conta poupanca
    private Cliente cliente;
    private int iban = 0;
    private double saldo = 0.0;
    private double variacao = 0.0;
    private double limite = 0.0;
    private int numConta = 0;
 
    public ContaPoupanca(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.iban = contadorIban;
        this.saldo = saldo;
        this.numConta = contadorP;
        contadorP +=1;
        contadorIban += 3;
    }
    
    public int getIban() {
          return iban;
     }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
  
    
    public double getVariacao() {
        return variacao;
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    // funcao responsavel pelo levantamento de valores
     public void debitar(double valor){ 
         //aplicando o limite ue o cliente podera levantar da conta poupanca
         //O nosso limite e o valor que o cliente levantar na primeira operacao com o saldo igual a zero
           setLimite(-10000);         
          if(getSaldo() <= getLimite()){
              System.out.println("Erro ao fazer o levantamento, valor insuficiente ou limite ultrapassado");            
              System.out.println("Saldo: "+formatacao.doubleToString(this.getSaldo())); 
          }else{                 
               if(getLimite() <= valor){
                    setSaldo(getSaldo() - valor);                  
                    System.out.println("O valor retirado da sua conta: "+formatacao.doubleToString(valor));
                    if(this.getSaldo() >= 0){                       
                        System.out.println("O seu saldo atual: "+formatacao.doubleToString(this.getSaldo()));
                    }else if(getSaldo() < 0 && getSaldo() <= getLimite()){     
                        System.out.println("O seu saldo atual e negativo de: "+formatacao.doubleToString(getSaldo()));      
                    }                   
               }else{
                   System.out.println("Erro ao fazer o levantamento, voce ultrapassado o seu limite");   
               }
        }
    }
    // funcao responsavel pelo deposito
      public void creditar(double valor){
        if(valor !=0 ){
            System.out.println("O valor depositado: "+formatacao.doubleToString(valor));
            setSaldo(getSaldo() + valor);
            setVariacao(4);
            //aplicando a variacao de 4% na conta poupanca
            setSaldo(getSaldo() + ((getSaldo() * getVariacao()) / 100));
            System.out.println("O seu saldo atual: "+formatacao.doubleToString(this.getSaldo()));           
            //System.out.println("Deposito realizado com sucesso");
            //setExtrato(getSaldo());  
        }else{
            System.out.println("Errro ao efectuar o deposito, valor igual a zero");            
            System.out.println("O valor a depositar: "+formatacao.doubleToString(valor));
        }
    } 
    /// funcao para consultar o saldo da conta
     public void consulSaldoP(ContaPoupanca conta){
        System.out.println("Sr: "+cliente.getNome());
        System.out.println("O seu saldo atual: "+formatacao.doubleToString(this.getSaldo()));
    }
    //funcao toString para fazer a impressao dos dados das contas na tela    @Override
    public String toString() { 
        return "Numero de conta: " +this.getNumConta()+ " "+
               "Nome: " + cliente.getNome() +" "+
               "Iban: " + this.getIban() +" "+
               "Saldo: " + formatacao.doubleToString(this.getSaldo())+" ";
                
                
    }  
    
}
