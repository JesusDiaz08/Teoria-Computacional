package Practica03;

import Practica03.AutomataING_03;
import Graficos.ING;
import java.io.*;
/*@author Díaz Medina Jesús Kaimorts */
public class Practica_03 {
    public static void main() throws IOException {
        boolean continuar = true;
        int opcion = 0;
        String FileWrite = "Practica03_Process.txt", path;
        String FileWriteAccepted = "Practica03_AcceptedWords.txt";
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Practica03_fromFILE rF = new Practica03_fromFILE();
        ING grafo;
        AutomataING_03 test = new AutomataING_03();
        
        System.out.println("Recognized words with ends ING");
        
        while(continuar){
            opcion = 0;
            showMenu();
            opcion = Integer.parseInt(teclado.readLine());
            System.out.println("|----------------|");
            switch (opcion) {
                case 1:
                    cleanFILE(FileWrite);
                    cleanFILE(FileWriteAccepted);
                    System.out.print("Cadena: ");
                    test.cadena = teclado.readLine();
                    test.entradTeclado(test.cadena);
                    break;

                case 2:
                    cleanFILE(FileWrite);
                    cleanFILE(FileWriteAccepted);
                    System.out.print("Archivo: ");
                    path = teclado.readLine();
                    rF.readText(path);
                    break;
                    
                case 3:
                    grafo = new ING();
                    grafo.graph();
                    break;
                    
                case 4: 
                    continuar = false;
                    break;
            }
        }
    }

    static void showMenu() {
        System.out.println("\n|------MENU------|");
        System.out.print(" 1. Manual\n 2. From FILE\n 3.Graph \n4. Exit\n");
        System.out.printf("-> ");
    }

    static void cleanFILE(String FileWrite) {
        File isFile = new File(FileWrite);
        if (isFile.exists()) {
            if (isFile.isFile()) {
                isFile.delete();
            }
        } else {
            isFile.delete();
        }
    }
}
