package Practica01;
/*@author Jesus Kaimorts Díaz Medina*/
import java.io.*;

public class sigmaAUX implements Serializable{

    public void addElemnts(int K) throws FileNotFoundException, IOException {
        //Variables
        int temp = K;
        int combination;
        int totalC = 0;
        String numberBinary = "";

        //----------Number of total elements-------//
        for (int i = 0; i <= K; i++) {
            totalC = totalC + (int) (Math.pow(2, i));
        }
        System.out.println("Total elements: " + totalC + "\n");
        //----------------------------------------//

        //----------DEVELOPMENT-------//
        String[] particularBinaryElements;

        try {
            //Create and read file.
            String FileWrite = "Practica01_Universe.txt";
            File isFile = new File(FileWrite);

            if (isFile.exists()) {
                if (isFile.isFile()) {
                    System.out.println("The file exists.");
                    isFile.delete();
                }
            } else {
                isFile.delete();
                System.out.println("File've been created. ");
            }

            FileWriter fw = new FileWriter(FileWrite, true);
            PrintWriter pw = new PrintWriter(fw);           //File opens.
            pw.flush();
            pw.write("{");

            if (K > 1) {
                for (int j = 0; K != 0; K--) {
                    numberBinary = "";
//                    System.out.println("|----------------------------|");
//                    System.out.println("Length of K = " + K);  //Pow/Length
                    combination = (int) (Math.pow(2, K));
                    particularBinaryElements = new String[combination];
//                    System.out.println("When K = " + K + " | Combinations = " + combination);

                    //Convert number to binary.
                    for (int i = 0; i < combination; i++) {
                        numberBinary = toBinary(i);
                        while (numberBinary.length() < K) {
                            numberBinary = 0 + numberBinary;
                        }
                        pw.write(numberBinary + ",");
                        pw.write("\n");
                        graphBinary(numberBinary, i);
                    }

                }
            } else if (K == 1) {
                pw.write("0,1,");
            }
            pw.write("E}");
            pw.close();     //The file is closed.

        } catch (IOException e) {
            System.out.println("Error: File didn't save.");
            e.getMessage();
        }
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

//    public static void saveData(String[] BE)
//            throws UnsupportedEncodingException, FileNotFoundException, IOException {
//        String data[] = new String[BE.length];
//        String FileWrite = "universe.csv";
//        OutputStream fOut = new FileOutputStream(FileWrite);
//        OutputStreamWriter out = new OutputStreamWriter(fOut, "UTF8");
//
//        out.write("{");
//        for (int i = 0; i < BE.length; i++) {
//            data[i] = BE[i];
//            out.write(data[i] + ",");
//            out.write("\n");
//        }
//        out.write("}");
//        out.close();
//        fOut.close();
//    }

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

    public static int randomNumber() {
        int random;
        random = (int) (Math.random() * 20) + 1;
        return random;
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
        System.out.println("En el "+decimalNumber_i+" binario hay: "+numberOfOne+" uno(s)");
    }
}

