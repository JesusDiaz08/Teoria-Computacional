package Practica14_Turing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*@author Jesús Kaimorts Díaz Medina*/

public class P14_MaquinaT {
    
    private int index=0;
    private char[] cinta;
    P14_SaveFile file;
    
    public P14_MaquinaT(){
        try {
            file = new P14_SaveFile();
        } catch (Exception e) {
        }
    }
    
    public String Q0(char symbol){
        String nextEdo="";
        if(symbol == '0'){
            cinta[index] = 'X';
            index++; /**/
            nextEdo="Q1";
        }
        else if(symbol == 'Y' ){
            cinta[index] = 'Y'; /*Se puede borrar*/
            index++;
            nextEdo="Q3";
        }
        return nextEdo;
    }
    
    public String Q1(char symbol){
        String nextEdo="";
        if(symbol=='0'){
            cinta[index]='0';
            index++;
            nextEdo="Q1";
        }
        else if(symbol == '1'){
            cinta[index]='Y';
            index--;
            nextEdo="Q2";
        }
        else if(symbol == 'Y'){
            cinta[index]='Y';
            index++;
            nextEdo="Q1";
        }
        return nextEdo;
    }
    
    public String Q2(char symbol){
        String nextEdo="";
        if(symbol=='0'){
            cinta[index]='0';
            index--;
            nextEdo="Q2";
        }
        else if(symbol == 'X'){
            cinta[index]='X';
            index++;
            nextEdo="Q0";
        }
        else if(symbol == 'Y'){
            cinta[index]='Y';
            index--;
            nextEdo="Q2";
        }
        return nextEdo;
    }
    
    public String Q3(char symbol){
        String nextEdo="";
        if(symbol=='Y'){
            cinta[index]='Y';
            index++;
            nextEdo="Q3";
        }
        else if(symbol == 'B'){
            cinta[index]='B';
            index++;
            nextEdo="Q4";
        }
        
        return nextEdo;
    }
    
    public String Q4(char symbol,String edoAct){
        String isA;
        if (symbol=='B' || edoAct.equals("Q4")) 
            isA= "String accepted";
        else
            isA= "String not accepted";
        
        return isA;
    }
    
    public void automata(String string){
        string = string+"B";
        cinta = string.toCharArray();
        String edoAct = "Q0";
        while (index < string.length()) {
            printStrip();
            System.out.print(": "+edoAct+" -> "+cinta[index]+"\n");
            file.write_sth(": "+edoAct+" -> "+cinta[index]+"\n");
            file.write_sth("\r\n");
            switch(edoAct){
                case "Q0":
                    edoAct = Q0(cinta[index]);
                    //printStrip();
                    break;
                case "Q1":
                    edoAct = Q1(cinta[index]);
                    //printStrip();
                    break;
                case "Q2":
                    edoAct = Q2(cinta[index]);
                    //printStrip();
                    break;
                case "Q3":
                    edoAct = Q3(cinta[index]);
                    //printStrip();
                    break;
                case "Q4":
                    edoAct= Q4(cinta[index],edoAct);
                    break;
                case "":
                    System.out.println("String was not accepted");
                    file.write_sth("String was not accepted");
                    index = string.length();
                    break;
            }
            if (edoAct.equals("Q4")) {
                printStrip(); 
                System.out.print(": "+edoAct);
                System.out.println("\nString accepted");
                file.write_sth(": "+edoAct);
                file.write_sth("\r\n");
                file.write_sth("\nString accepted");
            }
        }
        
        
        file.closeFile();
    }
    
    public void printStrip(){
        for (int j = 0; j < cinta.length; j++) {
            System.out.print("| "+cinta[j]+"  |");
            file.write_sth("| "+cinta[j]+"  |");
        }
    }
    
    public String generatedString(int length){
        char[] elementos = {'0', '1'};           //Universe
        char[] conjunto = new char[length]; //Group
        for (int i = 0; i < conjunto.length; i++) { //Generate string (0&1)
            int el = (int) (Math.random() * 2);
            conjunto[i] = (char) elementos[el];
        } 
        return new String(conjunto);
    }
    
    public String readFile() throws FileNotFoundException, IOException {
        String FILE = "Practica14_fromFile.txt";
        String cadena="",tmp="",bfReader;
        
        BufferedReader bf = new BufferedReader(new FileReader(FILE));   //Get FILE with string 0&1
        while((bfReader = bf.readLine())!=null) { //Until reads the whole FILE
            tmp = tmp + bfReader;
        }
        cadena = tmp;
        bf.close();
        return cadena;
    }
    
}
