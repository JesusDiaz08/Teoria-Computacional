package Practica05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*@author Jesus Kaimorts Díaz Medina
 */
public class Practica05_main 
{
    public static void main() throws IOException {
        boolean continuar = true;
        int opcion=0;
        String FILE = "Practica05_fromFile.txt";
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Practica05_automatonProtocol protocolo;
        System.out.println("Simulating of Protocol");
        
        while(continuar){
            opcion = 0;
            showMenu();
            opcion = Integer.parseInt(teclado.readLine());
            System.out.println("|----------------|");
            switch(opcion){
                case 1:
                    protocolo = new Practica05_automatonProtocol();
                    System.out.print("String: ");
                    protocolo.readBuffer(teclado.readLine());
                    protocolo.getProcessProtocol().closeFile();
                break;
                        
                case 2:
                    protocolo = new Practica05_automatonProtocol();
                    /*System.out.println("Path: ");
                    FILE = teclado.readLine();*/
                    System.out.println("FILE: "+FILE);
                    protocolo.readFile(FILE);
                    protocolo.getProcessProtocol().closeFile();
                break;
                
                case 3:
                    continuar = false;
                    break;
                
                default:
                    System.out.println("Error. Choosen other option.\n");
                    break;
            }
        }
    }
    
    public static void showMenu() {
        System.out.println("\n|------MENU------|");
        System.out.print(" 1. Manual\n 2. From FILE\n 3. Exit\n");
        System.out.printf("-> ");
    }
}
