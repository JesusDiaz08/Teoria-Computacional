package Practica02;
/*@author Jesus Kaimorts Díaz Medina*/
import static Practica01.sigmaAUX.graphBinary;
import java.io.*;

public class CribaE {

    public void testPrimalidad(int rangoK){
        boolean Arreglo[] = new boolean[rangoK + 1];
        for (int i = 1; i < rangoK; i++) {
            Arreglo[i] = true;              //Se llena la criba
        }
        for (int j = 2; j <= rangoK; j++) {
            if (true == Arreglo[j]) {
                //Eliminar multiplos de los primos encontrados
                for (int k = 2; k <= (rangoK) / j; k++) {
                    Arreglo[k * j] = false;
                }
            }
        }
        try {
            imprime_guarda(Arreglo, rangoK);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void imprime_guarda(boolean arrayP[], int rango)
            throws UnsupportedEncodingException, FileNotFoundException, IOException {
        int counter = 0;
        int salto = 1;
        String primeBinary = "";

        for (int m = 2; m <= rango; m++) {
            if (true == arrayP[m]) {
                counter++;
            }
        }
        /*System.out.printf("\n\nHay %d numeros primos", counter);
        System.out.printf("entre 1 y %d\n\n", rango);*/
        //Create and read file.
        String FileWritePrime = "Practica02_Primos.txt";

        try {
            if (existFile(FileWritePrime)) {
                FileWriter fw = new FileWriter(FileWritePrime, true);
                PrintWriter pw = new PrintWriter(fw);           //File opens.
                pw.flush();
                if (rango < 2) {
                    pw.write("Ninguno");
                }
                if (rango == 2) {
                    pw.write("{2}");
                    pw.write("{010}");
                }
                if (rango > 2) {
                    pw.write("{");      //Conjunto decimal inicia
                    for (int n = 2; n <= rango; n++) {
                        if (true == arrayP[n]) {
                            //System.out.printf("%4d\t", n);
                            pw.write(n + ",");
                            pw.write("\n");
                            salto++;
                        }
                        if (10 == salto) {
//                            System.out.println();
                            salto = 1;
                        }
                    }
                    pw.write("}");      //Conjunto Decimal termina
                    pw.write("\r\n");
                    pw.flush();
                    pw.write("{");      //Conjunto binario inicia
                    for (int m = 2; m <= rango; m++) {
                        if (true == arrayP[m]) {
                            primeBinary = toBinary(m);
                            
                            pw.write(primeBinary + ",");
                            pw.write("\n");
                            salto++;
                        }
                        if (10 == salto) {
//                            System.out.println();
                            salto = 1;
                        }
                        graphBinary(primeBinary, m);
                    }

                    pw.write("}");  //Conjunto binario termina
                }
                pw.close();
            }
//            System.out.println("\n");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public boolean existFile(String FileWritePrime) {
        File isFile = new File(FileWritePrime);
        boolean ready = true;
        if (isFile.exists()) {
            if (isFile.isFile()) {
//                System.out.println("|-------------------|");
                System.out.println("The file exists.");
                isFile.delete();
//                System.out.println("File deleted: " + (!isFile.delete()));
                ready = true;
            }
        } else {
//           System.out.println("|-------------------|");
            isFile.delete();
            System.out.println("File've been created. ");
            ready = true;
        }
        return ready;
    }

    public static String toBinary(int number) {
        int exp, binary, digit;
        String stringBinary;

        exp = 0;
        binary = 0;
        while (number != 0) {
            digit = number % 2;
            binary = (int) (binary + digit * Math.pow(10, exp));
            exp++;
            number = number / 2;
        }
        stringBinary = binary + "";
        char[] arrayBinary = stringBinary.toCharArray();

        return stringBinary;
    }

    public static int randomNumber() {
        int random;
        int limit=100000;
        random = (int) (Math.random() * limit) + 1;
        return random;
    }
    
    public static void modeMenu() {
        System.out.println("|------MENU------|");
        System.out.println("| 1.- Manual     |");
        System.out.println("| 2.- Automatic  |");
        System.out.println("| 3.- Exit       |");
        System.out.println("|----------------|");
        System.out.print("    Option: ");
    }

    public static void digitMenu() {
        System.out.println("|--------DIGIT--------|");
        System.out.printf("        K = ");
    }
    
    public static void graphBinary(String numberBinary,int decimalNumber_i){
        //Graficar comportamiento.
        char[] numbBinChar = numberBinary.toCharArray();
        int numberOfOne = 0;
        for (int m = 0; m < numbBinChar.length; m++) {
            if (numbBinChar[m] == '1') {
                numberOfOne++;                
            }   
        }
    }
}

