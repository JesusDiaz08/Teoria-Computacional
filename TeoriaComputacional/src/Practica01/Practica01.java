package Practica01;
/*@author Jesus Kaimorts Díaz Medina*/


import java.io.*;
/*@author Diaz Medina Jesús Kaimorts */
public class Practica01 {
    public static void main() throws IOException {
        
        boolean continuar=true;
        int K, optionMenu;
        sigmaAUX p = new sigmaAUX();
        
        /*Input of data*/
        BufferedReader option = new BufferedReader(new InputStreamReader(System.in));        //Entrada de teclado
        BufferedReader alphabet = new BufferedReader(new InputStreamReader(System.in));
        
        //MENU
        System.out.println("Creater of Strings' Universe");
        
        while(continuar){
            p.modeMenu();
            optionMenu = Integer.parseInt(option.readLine());
            
            switch (optionMenu) {
                case 1:
                    System.out.println("\n");
                    System.out.println("|--------MANUAL-------|");
                    p.digitMenu();
                    K = Integer.parseInt(alphabet.readLine());
                    System.out.println("\n|-------------------|");
                    p.addElemnts(K);
                    break;
                case 2:
                    System.out.println("|------AUTOMATIC------|");
                    p.digitMenu();
                    K = p.randomNumber();
                    System.out.println("" + K + "        |");
                    System.out.println("\n|---------------------|");
                    p.addElemnts(K);
                    break;
                
                case 3:
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("This option is not.\nChoosen other.");
                    break;
            }
        }
    }    
}

