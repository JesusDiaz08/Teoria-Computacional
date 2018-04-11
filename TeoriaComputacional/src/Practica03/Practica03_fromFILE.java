package Practica03;
import java.io.File;
import java.io.*;
/*@author Jesus Kaimorts Díaz Medina*/
public class Practica03_fromFILE {
    public void readText(String PATH) {
        try {
            AutomataING_03 auto = new AutomataING_03();
            //Abrir el fichero indicado en la variable nombreFichero
            FileReader fr = new FileReader(PATH);
            //Leer el primer carácter
            //Se debe almacenar en una variable de tipo int
            int caract = fr.read();
            //Se recorre el fichero hasta encontrar el carácter -1
            //   que marca el final del fichero
            while (caract != -1) {
                //Mostrar en pantalla el carácter leído convertido a char
                System.out.print((char)caract);
                auto.verifyStates((char) caract);
                //Leer el siguiente carácter
                caract = fr.read();
            }
            //Cerrar el fichero
            fr.close();
        } catch (Exception e) {
            System.out.println("Error de lectura del fichero");
        }
    }
}
