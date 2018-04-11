package Practica03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*@author Jesus Kaimorts Díaz Medina*/
public class AutomataING_03 {

    String cadena; /*CADENA*/
    int edoPast = -1;  /*CONTROLADOR*/
    static int q0 = 0, q1 = 1, q2 = 2; /*ESTADOS*/

    String validString="";   
    void verifyStates(char caracter) throws IOException {

        String FileWrite = "Practica03_Process.txt";
        String FileWriteA = "Practica03_AcceptedWords.txt";             
        
        FileWriter fw = new FileWriter(FileWrite, true);
        PrintWriter pw = new PrintWriter(fw);           //File to read opens.
        
        FileWriter fwA = new FileWriter(FileWriteA,true);
        PrintWriter pwA = new PrintWriter(fwA);         //File to words accepted.
        
        pw.flush();
        if ((caracter >= (char)(65) && caracter <= (char)(90)) || 
            (caracter >= (char)(97) && caracter <= (char)(122))) {//Dentro del ASCII
            if (caracter == 'i' || caracter == 'I') {
                edoPast = q0;
                pw.write("" + caracter + " -> q1\n");
                //pw.write("\r\n");
            } else if ((caracter == 'n' || caracter == 'N') && edoPast == q0) {
                edoPast = q1;
                pw.write("" + caracter + " -> q2\n");
                //pw.write("\r\n");
            } else if ((caracter == 'g' || caracter == 'G') && edoPast == q1) {
                edoPast = q2;
                pw.write("" + caracter + " -> q3");
                //pw.write("\r\n");
            } else {
                edoPast = -1;
                pw.write("" + caracter + " -> q0");
                //pw.write("\r\n");
            }
            validString = validString + caracter;
        }else{
            if (edoPast == q2) {
                pwA.write(validString);
                pwA.write("\r\n");
            }
            //pw.write("\r\n");
            validString = "";
            pw.flush();
        }
        pw.write("\r\n");
        pw.close();
        pwA.close();
        //System.out.println((edoPast == q2) ? "Aceptado\n\n" : "Denegado\n\n");
    }
    
    public void entradTeclado(String cadenaP) throws IOException {
        cadenaP = cadenaP+" ";
        for (int i = 0; i < cadenaP.length(); i++) {
            verifyStates(cadenaP.charAt(i));
        }
    }
}
