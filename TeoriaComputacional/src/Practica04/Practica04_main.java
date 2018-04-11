package Practica04;

import Graficos.Paridad;
import java.io.*;

/*@author Díaz Medina Jesús Kaimorts*/
public class Practica04_main //Paridad
{
    public static void main() throws FileNotFoundException, IOException {

        boolean continuar = true;
        Practica04_AutomataParidad paridad = new Practica04_AutomataParidad();
        Paridad grafico;
        Practica04_generateString gs = new Practica04_generateString();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int optionGeneral, digitRandomValue;
        String stringEven;
        String pathFile = "C:\\Users\\Home\\Documents\\ESCOM\\4o Semestre\\02 Teoría Computacional\\TeoriaComputacional";
        
        System.out.println("Parity of Strings");
        
        
        while(continuar){
            menuGeneral();
            optionGeneral = Integer.parseInt(leer.readLine());
            System.out.println("|---------------------------|\n\n");
            
            switch (optionGeneral) {
                case 1:
                    System.out.print("|-----MODE MANUAL------|\n|  ->\t");
                    stringEven = leer.readLine();
                    paridad.verifyParidad(stringEven);
                    break;

                case 2:
                    System.out.print("|-----MODE AUTOMATIC-----|\n");
                    cleanEdos(paridad);
                    System.out.print("|  String's length:  ");
                    digitRandomValue = Integer.parseInt(leer.readLine());
                    gs.setDigitRandom(digitRandomValue);
                    stringEven = gs.generateStringS();
                    System.out.println("|  String generated: " + stringEven);
                    paridad.verifyParidad(stringEven);
                    break;

                case 3:
                    System.out.print("|----MODE FROM FILE----|\n");
                    gs.generateStringFILE();
                    stringEven = gs.readFile(pathFile + "\\Practica04_StringGenerates.txt");
                    paridad.verifyParidad(stringEven);
                    break;

                case 4:
                    grafico = new Paridad();
                    grafico.graph();
                    break;
                case 5:
                    continuar = false;
                    break;    
            }
            if (paridad.getEdoAct() == paridad.q0) {
                System.out.println(" \tAceptado");
            } else {
                System.out.println(" \tDenegado");
            }
            
            System.out.println("|--------------------------------|");

        }
    }

    public static void menuGeneral() {
        System.out.println("|--------------MENU--------------|");
        System.out.println("|     1. MODE MANUAL             |");
        System.out.println("|     2. MODE AUTOMATIC          |");
        System.out.println("|     3. MODE FROM FILE          |");
        System.out.println("|     4. GRAPH                   |");
        System.out.println("|     5. EXIT                    |");
        System.out.print("|     -> \t");
    }

    public static void cleanEdos(Practica04_AutomataParidad q) {
        q.edoAct = 0;
        q.q0 = 0;
        q.q1 = 1;
        q.q2 = 2;
        q.q3 = 3;
    }
}
