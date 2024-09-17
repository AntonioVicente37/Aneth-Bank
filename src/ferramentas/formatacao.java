/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Engº António Vicente
 */
public class formatacao {
    //Criando a variavel que fara a formatacao dos valores para Kwz
    static NumberFormat formtvalor = new DecimalFormat("#,##0.00 AKZ");
   
    
    public static String doubleToString(Double valor){
        return formtvalor.format(valor);
    }
    
    //funcao para retornar data e hora atual do sistema
    /*public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }*/
    
}
