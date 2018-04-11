package Practica04;

import java.io.*;
/*@author Díaz Medina Jesús Kaimorts*/
public class Practica04_generateString {

    private final int digit = 10_000;   //String's length
    private int digitRandom;

    public void generateStringFILE() throws IOException {
        String nameFile = "Practica04_StringGenerates.txt";
        File isFile = new File(nameFile);

        if (existFile(isFile)) {
            FileWriter fw = new FileWriter(nameFile, true);
            PrintWriter pw = new PrintWriter(fw);

            char[] elementos = {'0', '1'};          //Universe
            char[] conjunto = new char[digit];      //Group
            for (int i = 0; i < conjunto.length; i++) { //Generate string (0&1)
                int el = (int) (Math.random() * 2);
                conjunto[i] = (char) elementos[el];
            } 
            pw.write(new String(conjunto));
            pw.close();
        }else
            System.err.println("ERROR.\nFILE NOT CREATED");
    }
    
    public String generateStringS(){
            char[] elementos = {'0', '1'};           //Universe
            char[] conjunto = new char[digitRandom]; //Group
            for (int i = 0; i < conjunto.length; i++) { //Generate string (0&1)
                int el = (int) (Math.random() * 2);
                conjunto[i] = (char) elementos[el];
            } 
            return new String(conjunto);
    }

    public boolean existFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                System.out.println("| \tFile exists.");
            }
        } else {
            file.delete();
            System.out.println("| \tFile've been created.");
        }
        return true;
    }

    public int getDigitRandom() {
        return digitRandom;
    }

    public void setDigitRandom(int digitRandom) {
        this.digitRandom = digitRandom;
    }
    
    public String readFile(String path) throws FileNotFoundException, IOException {
        String cadena="",tmp="",bfReader;
        
        BufferedReader bf = new BufferedReader(new FileReader(path));   //Get FILE with string 0&1
        while((bfReader = bf.readLine())!=null) { //Until reads the whole FILE
            tmp = tmp + bfReader;
        }
        cadena = tmp;
        bf.close();
        return cadena;
    }
}
