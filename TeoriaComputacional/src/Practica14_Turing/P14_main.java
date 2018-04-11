package Practica14_Turing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*@author Jesús Kaimorts Díaz Medina*/
public class P14_main {
    public static void main() {
        P14_MaquinaT machine;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String strGenerated="";
        boolean continuar = true;
        int opt = 0, length=0;
        
        while(continuar){
            try {
                menu();
                opt = Integer.parseInt(teclado.readLine());
                System.out.println("|----------------------------|");
                switch(opt){
                    case 1: /*MANUAL*/
                        machine = new P14_MaquinaT();
                        System.out.print("|  String:");
                        machine.automata(teclado.readLine());
                        break;
                    case 2: /*RANDOM*/
                        machine = new P14_MaquinaT();
                        System.out.print("|  String's length: ");
                        length = Integer.parseInt(teclado.readLine());
                        strGenerated = machine.generatedString(length);
                        System.out.println("|  String: "+strGenerated);
                        machine.automata(strGenerated);
                        break;
                    case 3: /*FROM FILE*/
                        machine = new P14_MaquinaT();
                        strGenerated = machine.readFile();
                        System.out.println("|  String: "+strGenerated);
                        machine.automata(strGenerated);
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
        System.out.println("|------ Turing Machine ------|");
        System.out.println("|\t1. MANUAL            |");
        System.out.println("|\t2. RANDOM            |");
        System.out.println("|\t3. FROM FILE         |");
        System.out.println("|\t4. EXIT              |");
        System.out.print("|\t->  ");
    }
}
