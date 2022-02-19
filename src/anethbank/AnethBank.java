
package anethbank;
import java.util.ArrayList;
import java.util.Scanner;
import modelpackage.bank.Cliente;
import modelpackage.bank.Conta;

/**
 *
 * @author Engº António Vicente
 */
public class AnethBank {
    //Variavei para receber as informacoes vindas do teclado  
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasB;
    
    static ArrayList<Cliente> clienteAd;
    public static void main(String[] args) {
        //arrays para aramazenar as contas
        contasB = new ArrayList<Conta>();
        clienteAd = new ArrayList<Cliente>();
        System.out.println("-----------------------------------------------------");
        System.out.println("----------Seja bem vindo a nossa agencia-------------");        
        System.out.println("-----------------------------------------------------");
        System.out.println("***************      ANETH BANK       ***************");
        System.out.println("-----------------------------------------------------");
        operacao();
        
    }
    // funcao responsavel por mostrar o menu com as opcoes do sistema
     private static void operacao() {  
        // Menu de opcoes do sistema bancario
        int oc = 0;
        System.out.println("|   opcao 1 - Criar conta           |");
        System.out.println("|   opcao 2 - Listar contas         |");
        System.out.println("|   opcao 3 - Conta poupanca        |");
        System.out.println("|   opcao 4 - Consultar saldo       |");
        System.out.println("|   opcao 5 - Deposito              |");
        System.out.println("|   opcao 6 - Levantamento          |");
        System.out.println("|   opcao 7 - Transferencia         |");
        System.out.println("|   opcao 8 - Extrato               |");
        System.out.println("|   opcao 9 - Pagamento de servico  |");
        System.out.println("|   opcao 0 - Sair                  |");        
        System.out.print("Escolha uma opcao:");        
        int op = input.nextInt();
        
        switch(op){
            case 1:
            //Chamada do funcao Criar Conta
                criarCont();
                break;
            case 2:
            //Chamada do funcao Listar Conta
                listrCont();
                break;
            case 3:
            //Chamada da funcao Criar Conta Poupanca
               criarContPou();
               break;
            case 4:
            //Chamada da funcao Consulta Saldo
               consultSaldo();
               break;
            case 5:
            //Chamada da funcao para fazer o depositar
                creditar();
                break;
            case 6:
             //Chamada da funcao para fazer o levantamento 
                debitar();
                break;        
            case 7:
             //Chamada da funcao para fazer a transferencia
                trnsfer();
                break;
            case 8:
             //Chamada da funcao para mostrar o extrato
                extract();
                break;
            case 9:
             //Chamada da funcao para mostrar o extrato
                PagamentoServic();
                break;
            case 0:
               System.out.println("Obrigada por usar os nossos servicos!");
               System.exit(0); 
             default:   
                System.out.println("Opcao invalida! Tente novamente");
                operacao();
                break;
        }
     }
    ///funcao para criar a conta
     public static void criarCont() {
         //informando os dados para criar um cliente
        System.out.print("Digite o seu nome: ");
        String nome = input.next();
        System.out.print("Digite o seu NIF: ");
        int nif = input.nextInt();
        //Passando os dados necessarios para criar uma conta
        System.out.print("Digite o seu IBAN: ");
        int iban = input.nextInt();
        System.out.print("Informe o seu deposito inicial: ");  
        double saldo = input.nextDouble();
        //adicionando os clientes a classe cliente
        Cliente cliente = new Cliente(nome,nif);
        clienteAd.add(cliente);
           if(saldo >= 5000){
                //adicionando a conta do cliente a classe Conta
                Conta conta = new Conta(cliente, iban, saldo);
                contasB.add(conta);
                if(nif == iban || nome == nome){
                    ///Por fazer
                     System.out.println("Cliente ou NIF ja estao registrados");
                }
                     System.out.println("Conta e cliente cadastrados");
                }else{
                    System.out.println("Valor insuficiente para fazer a abertura da sua conta Sr: "+nome);
            }
        
        //chamando a funcao operacao novamente
        operacao();
     }
     
     //funcao para enontrar contas, atraves dos nosso contadores presentes na classe conta
    public static Conta encoConta(int numConta){
         //colocando a conta como nul
         Conta conta = null;
         //verificando se tem contas bancarias na nossa agencia
         if(contasB.size() > 0){
             //percorrendo toas as contas que tem na nossa lista de ccontas
             for(Conta c: contasB){
                 //verificando se tem uma conta que o usuario digitou
                 if(c.getNumConta() == numConta){
                     conta = c; // conta em vez de ser null agora recebe a conta selecionad
                 }
             }
         }
         return conta;
     }
    //Funcao para fazer o deposito
    public static void creditar() {
        //pedindo o numero da conta ao usuario
        System.out.println("Numero da conta: ");
        int numConta = input.nextInt();
        //armazenando o numero da conta
        Conta conta = encoConta(numConta);
        //verificando se a conta existe
        if(conta != null){
            //recebendo o valor a depositar
            System.out.println("Qual e o valor que deseja depositar: ");
            Double valDepo = input.nextDouble();
            //fazendo o deposito
            conta.creditar(valDepo);
        }else{
            System.out.println("Conta nao encontrada! ");
        }
        operacao();
    }
    //Funcao para fazer levantamento
    public static void debitar() {
         //pedindo o numero da conta ao usuario
        System.out.println("Numero da conta: ");
        int numConta = input.nextInt();
        //armazenando o numero da conta
        Conta conta = encoConta(numConta);
        //verificando se a conta existe
        if(conta != null){
            //recebendo o valor a levantar
            System.out.println("Qual e o valor que deseja levantar: ");
            Double valLev = input.nextDouble();
            //fazendo o deposito
            conta.debitar(valLev);
        }else{
            System.out.println("Conta nao encontrada! ");
        }
        operacao();
    }

    public static void trnsfer() {
        //pedindo e armazenado a conta rementente
        System.out.println("Digite o numero da conta a transferir: ");
        int numContR = input.nextInt(); 
        
        //verificando se a conta remetente existe
        Conta contaRement = encoConta(numContR);
        //Verificando se a conta Remetente existe
        if(contaRement != null){            
        //pedindo e armazenado a conta destinatario
            System.out.println("Digite o numero da conta Destinatario: ");
            int numContDest = input.nextInt();
           //verificando se a conta dESTINATARIO existe
            Conta contaDestin = encoConta(numContDest);
            //Verificando se a conta destinatario existe
            if(contaDestin != null){
                System.out.println("Digite o valor a transferir: ");
                Double valor = input.nextDouble();
                
                contaRement.transferir(contaDestin, valor);
            }            
        }
        operacao();
    }
    
    public static void listrCont() {
       //verificando se tem contas no nosso sistema
       if(contasB.size() > 0){
           //percorrendo e listando todas as contas
           for(Conta conta : contasB){
               System.out.println(conta);
           }
       }else{
           System.out.println("Nao a contas cadastradas! ");
       }
       operacao();
    }

    public static void criarContPou() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void consultSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void extract() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static void PagamentoServic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   //funcao para o cadastro de clientes 
  /*public static void ClienteCad(){
       Scanner input = new Scanner(System.in);
        String nome, nif, iban, tipo= "";
        double saldo = 0;
    
        System.out.print("Digite o teu primeiro nome: ");
        nome = input.nextLine();
        System.out.print("Digite o seu NIf: ");
        nif = input.nextLine();
        System.out.print("Digite o seu Iban: ");
        iban = input.nextLine();
        System.out.print("Informe o seu deposito inicial: ");  
        saldo = Double.parseDouble(input.nextLine());
           
        /// agora estamos a criar um nova conta
        
        //comecand a instanciar a classe cliente
         Cliente cliente = new Cliente(nome,nif,iban,saldo);
        //adicionando o cliente ao banco
        Conta conta = new Conta();
        conta.addClinte(cliente);
     
  }*/
  //Funcao responsavel por listar os clientes
  /*public static void deposito(){      
    Scanner input = new Scanner(System.in);
     int cont = selecConta();     
     System.out.print("Qual e o valor que deseja depositar: ");
     double valor = 0;
     try{
         valor = Double.parseDouble(input.nextLine());
     }catch(NumberFormatException e){
         valor =0;
     }
     
     Conta conta = new Conta();
     conta.getCliente(cont).depositar();
      
  }
  //fazer levantamento
   public static void levant(){
     int conta = selecConta();
      
  }*/
  //Selecionar uma conta para fazer o depoisito
   /* private static int selecConta() {
        return 0;
    }*/
  /*public static void ContaCC(){
       // ArrayList<ContaCorrente> cl = new ArrayList<ContaCorrente>();
       char ct = 's';
       do{
        Scanner input = new Scanner(System.in);
        System.out.print("Nome do cliente: ");
        String n = input.next();
        System.out.print("Digite o numero da conta: ");
        int nun = input.nextInt();
        System.out.print("Digite o IBAN: ");
        int ib = input.nextInt();
        System.out.print("Digite o valor inicial: ");
        double val = input.nextDouble();
        Cliente cliente = new Cliente(n,nun,ib,val);
        conta.addCliente(cliente);
        //cl.add(cc); 
        System.out.println("Deseja cadastrar uma outra Conta? s ou S para sim.");
        ct = input.next().charAt(0);       
       }while (ct == 's' || ct == 'S');
       
      /* System.out.println("Lista de Contas:");
       for (ContaCorrente i: cl){
          System.out.println(i);            
       }
    }*/

    
   
 }
