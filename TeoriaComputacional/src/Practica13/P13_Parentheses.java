package Practica13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* @author Jesus Kaimorts Diaz Medina */
public class P13_Parentheses {
    
    private String derivation="";
    private P13_saveFile FILE;

    public P13_Parentheses() {
        FILE = new P13_saveFile();
    }
    
    public void start(String str) {
        int i = 0;
        derivation = "B";
        str = str+"\0";
        char[] string = str.toCharArray();
        System.out.println("|\tExpression: "+str);
        FILE.write_sth("|\tExpression: "+str);
        
        PARENTHESIS:
        for (i = 0; i < str.length(); i++) {
            switch (string[i]) {
                case '(':
                    if(!derivation.endsWith("RB")){
                        /*Apply B -> (RB*/
                        derivation = derivation.replaceFirst("B", "(RB");
                    }else{
                        /*Apply R -> (RR*/
                        derivation = derivation.replaceFirst("R", "(RR");
                    }
                    break;
                case ')':
                    if (derivation.contains("RB")) {
                        /*Apply R -> )*/
                        derivation = derivation.replaceFirst("R", ")");
                    } else {
                        System.out.println("Error");
                        FILE.write_sth("ERROR");
                        break PARENTHESIS;
                    }
                    break;
                 
                case '\0':
                    if (derivation.endsWith(")B")) {
                        derivation = derivation.replaceFirst("B", "e");
                    }
                    break;
                    
                default:
                    System.out.println("|\tERROR.");
                    FILE.write_sth("ERROR");
                    break;
            }
            System.out.println("|Steps of LM derivation:  "+derivation.replaceFirst("e",""));
            FILE.write_sth("|Steps of LM derivation:  "+derivation.replaceFirst("e",""));
        }
        if (derivation.contains("e")) {
            System.out.println("|\tParentheses balanced    |");
            FILE.write_sth("|\tParentheses balanced    |");
        }else{
            System.out.println("|\tParentheses is not balanced    |");
            FILE.write_sth("|\tParentheses is not balanced    |");
        }
        FILE.closeFile();
    }
    
    public String generatedString(int length){
        char[] elementos = {'(', ')'};           //Universe
        char[] conjunto = new char[length]; //Group
        for (int i = 0; i < conjunto.length; i++) { //Generate string ( & )
            int el = (int) (Math.random() * 2);
            conjunto[i] = (char) elementos[el];
        } 
        return new String(conjunto);
    }
    
    public String readFile() throws FileNotFoundException, IOException {
        String FILE = "Practica13_fromFile.txt";
        String cadena="",tmp="",bfReader;
        
        BufferedReader bf = new BufferedReader(new FileReader(FILE));   //Get FILE with string (&)
        while((bfReader = bf.readLine())!=null) { //Until reads the whole FILE
            tmp = tmp + bfReader;
        }
        cadena = tmp;
        bf.close();
        return cadena;
    }
}
