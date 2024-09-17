
package anethbank;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelpackage.bank.Cliente;
import modelpackage.bank.Conta;
import modelpackage.bank.ContaPoupanca;

/**
 *
 * @author Engº António Vicente
 */
public class AnethBank {
    //Variavei para receber as informacoes vindas do teclado  
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasB;    
    static ArrayList<Cliente> clienteAd;
    static ArrayList<ContaPoupanca> contaP;
    public static void main(String[] args) {
        //arrays para aramazenar as contas
        contasB = new ArrayList<>();
        clienteAd = new ArrayList<>();
        contaP = new ArrayList<>();
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
        System.out.println("|   opcao 1  - Criar conta           |");
        System.out.println("|   opcao 2  - Listar contas         |");
        System.out.println("|   opcao 3  - Conta poupanca        |");
        System.out.println("|   opcao 4  - Consultar saldo       |");
        System.out.println("|   opcao 5  - Deposito              |");
        System.out.println("|   opcao 6  - Levantamento          |");
        System.out.println("|   opcao 7  - Transferencia         |");
        System.out.println("|   opcao 8  - Extrato               |");
        System.out.println("|   opcao 9  - Pagamento de servico  |");
        System.out.println("|   opcao 10 - Listar clientes       |");
        System.out.println("|   opcao 0  - Sair                  |");        
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
            case 10:
             //Chamada da funcao para mostrar o extrato
                ListarCli();
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
        String nif = input.next();
        //Passando os dados necessarios para criar uma conta
        System.out.print("Informe o seu deposito inicial: ");  
        double saldo = input.nextDouble();
        //adicionando os clientes a classe cliente
        Cliente cliente = new Cliente(nome,nif);
        clienteAd.add(cliente);
           if(saldo >= 5000){
                //adicionando a conta do cliente a classe Conta
                Conta conta = new Conta(cliente, saldo);
                contasB.add(conta);
                /*if(nif == iban || nome == nome){
                    ///Por fazer
                     //System.out.println("Cliente ou NIF ja estao registrados");
                }*/
                 //JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO ");
                 System.out.println("-----------------------------------------------------");
                 System.out.println("********     CADASTRO FEITO COM SUCESSO     *********");
                 System.out.println("-----------------------------------------------------");
                }else{
                    System.out.println("Valor insuficiente para fazer a abertura da sua conta Sr  a/o: "+nome);
            }
        
        //chamando a funcao operacao novamente
        operacao();
     }
     
     //funcao para enontrar contas
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
    //funcao para enontrar contas poupanca, 
    public static ContaPoupanca encoContaP(int numConta){
         //colocando a conta como nul
         ContaPoupanca conta = null;
         //verificando se tem contas bancarias na nossa agencia
         if(contaP.size() > 0){
             //percorrendo toas as contas que tem na nossa lista de ccontas
             for(ContaPoupanca c: contaP){
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
        System.out.println("--------------------------------------------------------------");
        System.out.println("** Selecione o tipo de conta, que deseja fazer o deposito **");
        System.out.println("--------------------------------------------------------------");
        System.out.println("                   1) Conta Corrente                          ");
        System.out.println("                   2) Conta Poupanca                          ");
        System.out.print("Opcao: ");
        int num  = input.nextInt();
        switch (num) {
            case 1:
                //pedindo o numero da conta ao usuario
                System.out.print("Numero da conta: ");
                int numConta = input.nextInt();
                //armazenando o numero da conta
                Conta conta = encoConta(numConta);
                //verificando se a conta existe
                if(conta != null){
                    //recebendo o valor a depositar
                    System.out.print("Qual e o valor que deseja depositar: ");
                    Double valDepo = input.nextDouble();
                    //fazendo o deposito                    
                    System.out.println("-----------------------------------------------------");
                    System.out.println("*******   DEPOSITO REALIZADO COM SUCESSO      ********");
                    System.out.println("------------------------------------------------------");
                    conta.creditar(valDepo);
                }else{
                    System.out.println("-----------------------------------------------------");
                    System.out.println("**********      CONTA NAO ENCONTRADA     ************");
                    System.out.println("-----------------------------------------------------");
                }
                break;
            case 2:
                //pedindo o numero da conta ao usuario
                System.out.print("Numero da conta: ");
                int numContaP = input.nextInt();
                //armazenando o numero da conta
                ContaPoupanca contaPo = encoContaP(numContaP);
                //verificando se a conta existe
                if(contaPo != null){
                    //recebendo o valor a depositar
                    System.out.print("Qual e o valor que deseja depositar: ");
                    Double valDepo = input.nextDouble();
                    //fazendo o deposito                   
                    System.out.println("-----------------------------------------------------");
                    System.out.println("*******   DEPOSITO REALIZADO COM SUCESSO      ********");
                    System.out.println("------------------------------------------------------");
                     contaPo.creditar(valDepo);
                }else{
                    System.out.println("-----------------------------------------------------");
                    System.out.println("**********      CONTA NAO ENCONTRADA     ************");
                    System.out.println("-----------------------------------------------------");
                }    
                break;
            default:
                 System.out.println("-----------------------------------------------------");
                 System.out.println("********   OPCAO INVALIDA TENTE OUTRA VEZ   *********");
                 System.out.println("-----------------------------------------------------");
                break;
        }
        operacao();
    }
    //Funcao para fazer levantamento
    public static void debitar() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("** Selecione o tipo de conta, que deseja fazer o Leantamento **");
        System.out.println("--------------------------------------------------------------");
        System.out.println("                   1) Conta Corrente                          ");
        System.out.println("                   2) Conta Poupanca                          ");
        System.out.print("Opcao: ");
        int num  = input.nextInt();
        switch (num) {
            case 1:
                 //pedindo o numero da conta ao usuario
                System.out.print("Numero da conta: ");
                int numConta = input.nextInt();
                //armazenando o numero da conta
                Conta conta = encoConta(numConta);
                //verificando se a conta existe
                if(conta != null){
                    //recebendo o valor a levantar
                    System.out.print("Qual e o valor que deseja levantar: ");
                    Double valLev = input.nextDouble();
                    //fazendo o deposito
                    System.out.println("-----------------------------------------------------");
                    System.out.println("******     OPERACAO REALIZADO COM SUCESSO      *******");
                    System.out.println("------------------------------------------------------");
                    conta.debitar(valLev);
                }else{                    
                    System.out.println("-----------------------------------------------------");
                    System.out.println("**********      CONTA NAO ENCONTRADA     ************");
                    System.out.println("-----------------------------------------------------");
                }
                break;
            case 2:
                 //pedindo o numero da conta ao usuario
                System.out.print("Numero da conta: ");
                int numContaP = input.nextInt();
                //armazenando o numero da conta
                ContaPoupanca contaPo = encoContaP(numContaP);
                //verificando se a conta existe
                if(contaP != null){
                    //recebendo o valor a levantar
                    System.out.print("Qual e o valor que deseja levantar: ");
                    Double valLev = input.nextDouble();
                    //fazendo o deposito
                    System.out.println("-----------------------------------------------------");
                    System.out.println("******     OPERACAO REALIZADO COM SUCESSO      *******");
                    System.out.println("------------------------------------------------------");
                    contaPo.debitar(valLev);
                }else{
                    System.out.println("-----------------------------------------------------");
                    System.out.println("**********      CONTA NAO ENCONTRADA     ************");
                    System.out.println("-----------------------------------------------------");
                }          
                break;
            default:
                System.out.println("-----------------------------------------------------");
                System.out.println("********   OPCAO INVALIDA TENTE OUTRA VEZ   *********");
                System.out.println("-----------------------------------------------------");
                break;
        }
        operacao();
    }
    ///funcao para fazer a transferencia dos valores
    public static void trnsfer() {
        //pedindo e armazenado a conta rementente
        System.out.print("Digite o numero da conta a debitar: ");
        int numContR = input.nextInt(); 
        
        //verificando se a conta remetente existe
        Conta contaRement = encoConta(numContR);
        //Verificando se a conta Remetente existe
        if(contaRement != null){            
        //pedindo e armazenado a conta destinatario
            System.out.print("Digite o numero da conta a creditar: ");
            int numContDest = input.nextInt();
           //verificando se a conta dESTINATARIO existe
            Conta contaDestin = encoConta(numContDest);
            //Verificando se a conta destinatario existe
            if(contaDestin != null){
                System.out.print("Digite o valor a transferir: ");
                Double valor = input.nextDouble();                
                contaRement.transferir(contaDestin, valor);
                System.out.println("-----------------------------------------------------");
                System.out.println("*******  TRANSFERENCIA REALIZADA COM SUCESSO  *******");
                System.out.println("-----------------------------------------------------");
            }            
        }
        operacao();
    }
    // funcao responsavel por listar as contas
    public static void listrCont() {
       //verificando se tem contas no nosso sistema
       if(contasB.size() > 0){
           //percorrendo e listando todas as contas      
        System.out.println("-----------------------------------------------------");
        System.out.println("************   LISSTA DE CONTA CORRENTES  ***********");
        System.out.println("-----------------------------------------------------");
           for(Conta conta : contasB){
               System.out.println(conta);
           }
       }else{
            System.out.println("-----------------------------------------------------");
            System.out.println("******   NAO A CONTAS CORRENTES CADASTRADAS   *********");
            System.out.println("-----------------------------------------------------");
       }       
       
       if(contaP.size() > 0){
        //percorrendo e listando todas as contas poupanca     
        System.out.println("-----------------------------------------------------");
        System.out.println("********     LISTA DE CONTAS POUPANCA      ***********");
        System.out.println("-----------------------------------------------------");
           for(ContaPoupanca conta : contaP){
               System.out.println(conta);
           }
       }else{
            System.out.println("-----------------------------------------------------");
            System.out.println("******   NAO A CONTAS POUPANCAS CADASTRADAS   *********");
            System.out.println("-----------------------------------------------------");
       }
       operacao();
    }
    //Funcao para criar a conta poupanca
    public static void criarContPou() {
        //informando os dados para criar um cliente
        System.out.print("Digite o seu nome: ");
        String nome = input.next();
        System.out.print("Digite o seu NIF: ");
        String nif = input.next();
        //Passando os dados necessarios para criar uma conta
        System.out.print("Informe o seu deposito inicial: ");  
        double saldo = input.nextDouble();
        //adicionando os clientes a classe cliente
        Cliente cliente = new Cliente(nome,nif);
        clienteAd.add(cliente);
           if(saldo >= 10000){
                //adicionando a conta do cliente a classe Conta
                ContaPoupanca conta = new ContaPoupanca(cliente, saldo);
                contaP.add(conta);
                /*if(nif == iban || nome == nome){
                    ///Por fazer
                     //System.out.println("Cliente ou NIF ja estao registrados");
                }*/
                 System.out.println("-----------------------------------------------------");
                 System.out.println("********      CONTA CRIADA COM SUCESSO       *********");
                 System.out.println("-----------------------------------------------------");
                }else{
                    System.out.println("Valor insuficiente para fazer a abertura da sua conta Sr a/o: "+nome);
                    System.out.println("Necessita de pelo menos 10.000.00 AKz para fazer a abertura da conta Poupança");
            }
        
        //chamando a funcao operacao novamente
        operacao();
    }    
    /// funcao responsavel por listar o saldo
    public static void consultSaldo() {        
        System.out.println("--------------------------------------------------------------");
        System.out.println("** Selecione o tipo de conta, que deseja consultar o saldo  **");
        System.out.println("--------------------------------------------------------------");
        System.out.println("                   1) Conta Corrente                          ");
        System.out.println("                   2) Conta Poupanca                          ");
        System.out.print("opcao: ");
        int num  = input.nextInt();
        switch (num) {
            case 1:
                    //pedindo o numero da conta ao usuario
                    System.out.print("Informe o numero da Conta Corrente: ");
                    int numConta = input.nextInt();
                    //armazenando o numero da conta
                    Conta conta = encoConta(numConta);
                    //verificando se a conta existe
                    if(conta != null){
                        conta.consulSaldo(conta);
                    }else{
                        System.out.println("-----------------------------------------------------");
                        System.out.println("********       CONTA NAO ENCONTRADA         *********");
                        System.out.println("-----------------------------------------------------");
                    }
                    break;
            case 2:
                    //pedindo o numero da conta ao usuario
                    System.out.print("Informe o numero da sua Conta Poupanca: ");
                    int numContaP = input.nextInt();
                    //armazenando o numero da conta
                    ContaPoupanca contap = encoContaP(numContaP);
                    //verificando se a conta existe
                    if(contap != null){
                        contap.consulSaldoP(contap);
                    }else{
                        System.out.println("-----------------------------------------------------");
                        System.out.println("********       CONTA NAO ENCONTRADA         *********");
                        System.out.println("-----------------------------------------------------");
                    }       
                    break;
            default:
                        System.out.println("-----------------------------------------------------");
                        System.out.println("*******    OPCAO INVALIDA TENTE NOVAMENTE    ********");
                        System.out.println("-----------------------------------------------------");
                    break;
        }
        operacao();
    }
    public static void extract() {
         //pedindo o numero da conta ao usuario
            System.out.print("Informe o numero de Conta Corrente: ");
            int numConta = input.nextInt();
            //armazenando o numero da conta
            Conta conta = encoConta(numConta);
            //verificando se a conta existe
            if(conta != null){
                conta.consultaExtrato(conta);
            }else{
                System.out.println("-----------------------------------------------------");
                System.out.println("********       CONTA NAO ENCONTRADA         *********");
                System.out.println("-----------------------------------------------------");
            }
            operacao();
    }
    //funcao responsavel por fazer o pagamentos dos servicos
    private static void PagamentoServic() {
        double valLev = 0;
       //pedindo o numero da conta ao usuario
        System.out.print("Numero da conta: ");
        int numConta = input.nextInt();
        //armazenando o numero da conta
        Conta conta = encoConta(numConta);
        //verificando se a conta existe
        if(conta != null){
            System.out.println("--------------------------------------------------------------");
            System.out.println("**********   Qual e o servico que deseja solicitar  **********");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1) Pagamento de BI, custa 2.000.00 AKZ");
            System.out.println("2) Pagamento do Registo Criminal, custa 1.500.00 AKZ");
            System.out.println("3) Pagamento de Atestado Medico, custa 4.000.00 AKZ");
            System.out.println("4) Pagamento da Zap Fibra, custa 32.000.00 AKZ");
            System.out.println("5) Compra de Saldo de internet na Unitel, custa 15.000.00 AKZ");
            //recebendo o valor a levantar
            System.out.print("Servico: ");
            int serv = input.nextInt();
            switch (serv) {
                case 1:
                    valLev = 2000;
                    System.out.println("Voce solicitou o um novo BI");                    
                    conta.pagaServico(conta, valLev);
                    System.out.println("Obrigada por usar os nossos servicos");
                    break;
                case 2:
                    valLev = 1500;
                    System.out.println("Voce solicitou um Registro Criminal");                    
                    conta.pagaServico(conta, valLev);
                    System.out.println("Obrigada por usar os nossos servicos");
                    break;
                case 3:
                    valLev = 4000;
                    System.out.println("Voce solicitou um Atestado Medico");                   
                    conta.pagaServico(conta, valLev);
                    System.out.println("Obrigada por usar os nossos servicos");
                    break;
                case 4:
                    valLev = 32000;
                    System.out.println("Voce solicitou o servico da Zap Fibra");                   
                    conta.pagaServico(conta, valLev);
                    System.out.println("Obrigada por usar os nossos servicos");
                    break;
                case 5:
                    valLev = 15000;
                    System.out.println("Voce solicitou a compra do pacote de dados da UNITEL");                   
                    conta.pagaServico(conta, valLev);
                    System.out.println("Obrigada por usar os nossos servicos");
                    break;
                default:   
                System.out.println("Opcao invalida! Servico nao existente tente novamente!");
                break;
            }
        }
        operacao();
    }    
    //funcao responsavel por listar os clientes
    private static void ListarCli() {
        //verificando se tem clientes no nosso sistema
       if(clienteAd.size() > 0){
           //percorrendo e listando todas os clientes           
        System.out.println("------------------------------------------------------");
        System.out.println("***************   Lista de Clientes    ***************");
        System.out.println("------------------------------------------------------");
           for(Cliente cliente : clienteAd){
               System.out.println(cliente);
           }
       }else{
           System.out.println("Nao a clientes cadastradas! ");
       }
       operacao();
    }
   
 }
