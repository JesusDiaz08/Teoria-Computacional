package Practica07;

import Graficos.Web_Ebay;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*@author Jesus Kaimorts Díaz Medina*/

public class P7_main {
    public static void main() {
        boolean continuar = true;
        int option=0; String aux="";
        String FILE = "Practica07_fromFile.txt";
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        P7_automaton automata;
        Web_Ebay graph;
        System.out.println("|---- WEB/EBAY ----|");
        
        while(continuar){
            option = 0;
            menu();
            try {
                option = Integer.parseInt(teclado.readLine());
                System.out.println("|----------------------|");
                switch(option){
                    case 1:
                        automata = new P7_automaton();
                        System.out.print("String: ");
                        automata.start(teclado.readLine());
                        break;
                        
                    case 2:
                        automata = new P7_automaton();
                        System.out.println("FILE: "+FILE);
                        automata.readByFile(FILE);
                        break;
                    
                    case 3:
                        graph = new Web_Ebay();
                        graph.graph();
                        break;
                        
                    case 4:
                        continuar = false;
                        break;
                    
                    default:
                        System.err.println("Choosen other option, please.\n");
                        break;
                }
            } catch (IOException e) {
                System.err.println("There was an error to read your option.\n");
            }
        }
    }
    
    public static void menu(){
        System.out.println("|-------- MENU --------|");
        System.out.println("| 1. MANUAL            |");
        System.out.println("| 2. FROM FILE         |");
        System.out.println("| 3. GRAPH             |");
        System.out.println("| 4. EXIT              |");
        System.out.print("|  ->\t");
    }
}
