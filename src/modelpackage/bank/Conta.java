/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage.bank;


import com.sun.org.apache.xerces.internal.xs.PSVIProvider;
import ferramentas.formatacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Engº António Vicente
 */
public class Conta{
    //Variavel contador para contar o numero de clientes
    private static int contadorContas = 1;
    private static int contadorIban = 1203199;
    // Atributos da classe conta
    private int numConta = 0;
    private int iban = 0;
    private double saldo = 0.0;
    private Cliente cliente;
    //atributos para o metodo extrato    
    private int extrato = 0;
    
    public Conta(Cliente cliente, double saldo) {
          this.numConta = contadorContas;
          this.cliente = cliente;
          this.iban = contadorIban;
          this.saldo = saldo;
          //cada ves que uma conta for criada o nosso contador vai ser incremento
          contadorContas += 1;         
          contadorIban += 2;
          extrato = 0;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
     // funcao responsavel pelo levantamento do valores da classse conta
    public void debitar(double valor){        
        if(this.getSaldo() >= valor && valor != 0 ){
            System.out.println("O valor retirado da sua conta: "+formatacao.doubleToString(valor));
            setSaldo(getSaldo() - valor);
            System.out.println("O seu saldo atual: "+formatacao.doubleToString(this.getSaldo()));
            //System.out.println("Levantamento realizado com sucesso");
            //setExtrato(getSaldo());
            this.extrato ++;
        }else{
            System.out.println("Erro ao fazer o levantamento, valor insuficiente ou igual a zero");            
            System.out.println("Saldo: "+formatacao.doubleToString(this.getSaldo())); 
        }
    }
    // funcao responsavel pelo deposito da classse conta
   public void creditar(double valor){
        if(valor !=0 ){
            System.out.println("O valor depositado: "+formatacao.doubleToString(valor));
            setSaldo(getSaldo() + valor);
            System.out.println("O seu saldo atual: "+formatacao.doubleToString(this.getSaldo()));           
            //System.out.println("Deposito realizado com sucesso");
            //setExtrato(getSaldo());              
            this.extrato ++;
        }else{
            System.out.println("Errro ao efectuar o deposito, valor igual a zero");            
            System.out.println("O valor a depositar: "+formatacao.doubleToString(valor));
        }
    } 
     // funcao responsavel pela transferencia dos valor de uma conta a outra
    public void transferir(Conta contaD, Double valor) {
         if(this.getSaldo() >= valor && valor != 0 ){             
             System.out.println("Valor a transferir: "+formatacao.doubleToString(valor));
             setSaldo(getSaldo() - valor);             
             //contaD esta a se referir a conta que vai ser feita a transferencia
             contaD.saldo = contaD.getSaldo() + valor;             
            this.extrato ++;
         }else{             
            System.out.println("Erro ao realizar a transferencia! Valor insuficiente");
         }
    }
    //funcao para consultar a saldo da conta de um cliente
    public void consulSaldo(Conta conta){
        System.out.println("Sr: "+cliente.getNome());
        System.out.println("O seu saldo atual: "+formatacao.doubleToString(this.getSaldo()));        
        this.extrato ++;
    }
    //funcao responsavel por fazer o pagamento dos servicos
    public void pagaServico(Conta conta, double valor ){
        if(this.getSaldo() >= valor){
            System.out.println("O valor do pagamendo foi de: "+formatacao.doubleToString(valor));
            setSaldo(getSaldo() - valor);
            System.out.println("Foi debitado da sua conta: "+formatacao.doubleToString(valor));
            consulSaldo(conta);
            System.out.println("Pagamento realizado com sucesso");
            //setExtrato(getSaldo());            
            this.extrato ++;
        }else{
            System.out.println("Erro ao fazer o Pagamento, valor insuficiente");            
            System.out.println("Saldo: "+formatacao.doubleToString(this.getSaldo())); 
        }
    } 
    
           
    //funcao para mostrar o extrato da conta
    public void consultaExtrato(Conta conta){
         System.out.println("\tEXTRATO BANCARIO");         
         System.out.println("Numero de Conta: " + getNumConta());
         System.out.println("Nome do Cliente: " + cliente.getNome());
         System.out.println("Saldo: "+ formatacao.doubleToString(this.getSaldo()));
         System.out.println("Descricao: "+ "Consuta do extrato da conta");
         System.out.println("Tipo 1: "+ "Extrato da conta corrente");
         System.out.println("Data: "+getDateTime());
         System.out.println("Operacoes Realizadas: " + this.extrato + "\n");
    }
    public String getDateTime() {
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         Date date = new Date();
         return dateFormat.format(date);
     }
     //Metodo toString para fazer a impressao dos dados da  nossas contas
    @Override
    public String toString() { 
        return "Numero de conta: " +this.getNumConta()+ " "+
               "Nome: " + cliente.getNome() +" "+
               "Iban: " + this.getIban()+" "+
               "Saldo: " + formatacao.doubleToString(this.getSaldo())+" ";
                
                
    }      
    
}
