package Practica02;
/*@author Jesus Kaimorts Díaz Medina*/

import java.io.*;
public class Practica02 {

    public static void main() throws IOException {
        boolean continuar = true;
        //Variable
        int K;int optionMode, optionDigit;
        CribaE ob = new CribaE();
        /*Input of data*/
        BufferedReader option = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader alphabet = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Searching 'n' Primes Number ");
        
        while(continuar){
            ob.modeMenu();
            optionMode = Integer.parseInt(option.readLine());
            
            System.out.println("");
            switch (optionMode) {
                case 1:         //MANUAL
                    System.out.println("|--------MANUAL-------|");
                    ob.digitMenu();
                    K = Integer.parseInt(alphabet.readLine());
                    System.out.println("\n|-------------------|");
                    ob.testPrimalidad(K);
                    break;

                case 2:         //AUTOMATIC
                    System.out.println("|------AUTOMATIC------|");
                    ob.digitMenu();
                    K = ob.randomNumber();
                    System.out.println("" + K + "        |");
                    System.out.println("\n|---------------------|");
                    ob.testPrimalidad(K);
                    break;
                
                case 3:
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("This option is not.");
                    System.out.println("Choosen other option.");
                    break;
            }
        }
    }
}
