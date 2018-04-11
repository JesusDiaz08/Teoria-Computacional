package SuperMain;
/*@author Jesús Kaimorts Díaz Medina*/

import Practica01.*;
import Practica02.*;
import Practica03.*;
import Practica04.*;
import Practica05.*;
import Practica06.*;
import Practica07.*;
import Practica09.*;
import Practica11.*;
import Practica12.*;
import Practica13.*;
import Practica14_Turing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Practica01 universo;                 P6_main NDFA;               P13_main parenthesis;
        Practica02 primos;                   P7_main web_ebay;           P14_main machine;
        Practica_03 ING;                     P9_main RE; 
        Practica04_main paridad;             P11_main pila;
        Practica05_main protocolo;           P12_main palindrome;
        int option;
        
        /*for(;;){
            
            option=0;
            menu();
            option = Integer.parseInt(teclado.readLine());
            System.out.println("|----------------------------|");
            switch(option){
                case 1:
                    web_ebay = new P7_main();
                    web_ebay.main();
                    break;
                case 2:
                    RE = new P9_main();
                    RE.main();
                    break;
                    
                case 3:
                    pila = new P11_main();
                    pila.main();
                    break;
                
                case 4:
                    palindrome = new P12_main();
                    palindrome.main();
                    break;
                
                case 5:
                    System.out.println("| HASTA LA VISTA, BABY.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option theres is not.");
                    System.out.println("Choosen other option.");
                    break;
            }
        }*/
        
        for(;;){
            option=0;
            menuAll();
            option = Integer.parseInt(teclado.readLine());
            System.out.println("|----------------------------|");
            switch(option){
                case 1:
                    universo = new Practica01();
                    universo.main();
                    break;
        
                case 2:
                    primos = new Practica02();
                    primos.main();
                    break;
                    
                case 3:
                    ING = new Practica_03();
                    ING.main();
                    break;
                
                case 4:
                    paridad = new Practica04_main();
                    paridad.main();
                    break;
                
                case 5:
                    protocolo = new Practica05_main();
                    protocolo.main();
                    break;
                
                case 6:
                    NDFA = new P6_main();
                    NDFA.main();
                    break;
        
                case 7:
                    web_ebay = new P7_main();
                    web_ebay.main();
                    break;
                case 8:
                    RE = new P9_main();
                    RE.main();
                    break;
                    
                case 9:
                    pila = new P11_main();
                    pila.main();
                    break;
                
                case 10:
                    palindrome = new P12_main();
                    palindrome.main();
                    break;
                
                case 11:
                    parenthesis = new P13_main();
                    parenthesis.main();
                    break;
                case 12:
                    machine = new P14_main();
                    machine.main();
                    break;
                case 13:
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option theres is not.");
                    System.out.println("Choosen other option.");
                    break;
            }
        }
    }
    
    public static void menu(){
        System.out.println("|--------- PROGRAMS ---------|");
        /*System.out.println("| 1. Universe.               |");
        System.out.println("| 2. Prime numbers.          |");
        System.out.println("| 3. Ends ING.               |");
        System.out.println("| 4. Parity String.          |");
        System.out.println("| 5. Protocol.               |");
        System.out.println("| 6. Matrix: NDFA.           |");*/
        System.out.println("| 1. Web-Ebay.               |");
        System.out.println("| 2. Regulars Expressions.   |");
        System.out.println("| 3. Pusdhown Automata.      |");
        System.out.println("| 4. Palindrome.             |");
        System.out.println("| 5. Exit                    |");
        System.out.print("| ->\t");
    }
    
    public static void menuAll(){
        System.out.println("|--------- PROGRAMS ---------|");
        System.out.println("| 1. Universe.               |");
        System.out.println("| 2. Prime numbers.          |");
        System.out.println("| 3. Ends ING.               |");
        System.out.println("| 4. Parity String.          |");
        System.out.println("| 5. Protocol.               |");
        System.out.println("| 6. Matrix: NDFA.           |");
        System.out.println("| 7. Web-Ebay.               |");
        System.out.println("| 8. Regulars Expressions.   |");
        System.out.println("| 9. Pusdhown Automata.      |");
        System.out.println("| 10. Palindrome.           |");
        System.out.println("| 11. Parenthesis. UAG      |");
        System.out.println("| 12. Turing Machine.       |");
        System.out.println("| 13. Exit.                 |");
        System.out.print("| ->\t");
    }
    
}
