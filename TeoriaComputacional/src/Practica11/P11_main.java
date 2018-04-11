package Practica11;

import Practica10.P10_RE;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*@author Jesus Kaimorts Díaz Medina*/

public class P11_main {
    public static void main() {
        
        P11_Automaton automata; 
        P11_Stack pila;
        P10_RE randomString;
        String ToRead = "Practica11_fromFile.txt";
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int option=0,length;
        boolean continuar = true;
        System.out.println("|----- AUTOMATA DE PILA -----|");
        
        while(continuar){
            option=0;
            menu();
            try {
                option = Integer.parseInt(teclado.readLine());
                System.out.println("|----------------------|");
                switch(option){
                    case 1:
                        pila = new P11_Stack();
                        automata = new P11_Automaton();
                        System.out.print("| String:   ");
                        automata.readExpresion(teclado.readLine());
                        break;
                    case 2: 
                        pila = new P11_Stack();
                        automata = new P11_Automaton();
                        /*System.out.print("| Path:   ");
                        automata.readByFile(teclado.readLine());*/
                        automata.readByFile(ToRead);
                        break;
                    case 3: 
                        String random="";
                        pila = new P11_Stack();
                        automata = new P11_Automaton();
                        randomString = new P10_RE();
                        random = randomString.RegularExpression();
                        System.out.println("| String: "+random);
                        automata.readExpresion(random);
                        break;    
                        
                    case 4: 
                        continuar = false;
                        break;
                        
                    default:
                        System.out.println("Choosen other option, please.\n");
                        break;
                }
            } catch (IOException e) {
                System.out.println("There was an error.");
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void menu(){
        System.out.println("|-------- MENU --------|");
        System.out.println("| 1. MANUAL            |");
        System.out.println("| 2. FROM FILE         |");
        System.out.println("| 3. AUTOMATIC         |");
        System.out.println("| 4. EXIT              |");
        System.out.print("|  ->\t");
    }
}
