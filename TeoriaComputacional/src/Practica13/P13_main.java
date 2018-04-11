package Practica13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*@author Jesus Kaimorts Diaz Medina.*/
public class P13_main {
    public static void main() {
        P13_Parentheses parenthesis = new P13_Parentheses();
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String strGenerated="";
        boolean continuar = true;
        int opt = 0, length=0;
        
        while(continuar){
            try {
                menu();
                opt = Integer.parseInt(teclado.readLine());
                System.out.println("|-------------------------------|");
                switch(opt){
                    case 1: /*MANUAL*/
                        parenthesis = new P13_Parentheses();
                        System.out.print("|  String:\t");
                        parenthesis.start(teclado.readLine());
                        break;
                    case 2: /*RANDOM*/
                        parenthesis = new P13_Parentheses();
                        System.out.print("|  String's length: ");
                        length = Integer.parseInt(teclado.readLine());
                        strGenerated = parenthesis.generatedString(length);
                        System.out.println("|  String: "+strGenerated);
                        parenthesis.start(strGenerated);
                        break;
                    case 3: /*FROM FILE*/
                        parenthesis = new P13_Parentheses();
                        strGenerated = parenthesis.readFile();
                        System.out.println("|  String: "+strGenerated);
                        parenthesis.start(strGenerated);
                        break;
                    case 4:
                        continuar = false;
                        break;
                    
                    default:
                        System.out.println("This option is not.");
                        break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("There was an error.");
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void menu(){
        System.out.println("|----- Unambiguous Grammar -----|");
        System.out.println("|\t1. MANUAL               |");
        System.out.println("|\t2. RANDOM               |");
        System.out.println("|\t3. FROM FILE            |");
        System.out.println("|\t4. EXIT                 |");
        System.out.print("|\t->  ");
    }
}
