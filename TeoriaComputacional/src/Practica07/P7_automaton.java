package Practica07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*@author Jesús Kaimorts Díaz Medina*/
public class P7_automaton {
    private P7_WebEbay automaton;
    
    
    public P7_automaton() {
        cleanALL();
        automaton = new P7_WebEbay();
    }   
    
    public void start(String str){
        automaton.search(str);
        automaton.getWords().closeFile();
        automaton.getProcess().closeFile();
    }
        
    public void readByFile(String path){
        
        String aux="";
        try {
            FileReader fR = new FileReader(path);
            int caracter = fR.read();
            while(caracter != -1){ //Read all file
                caracter = fR.read();
                aux += (char)caracter; //Join the pieces
            }
            /*Read the last character*/
            caracter = fR.read();
            aux += (char)caracter;
            fR.close();
        } catch (IOException e) {
            System.out.println("There was a error to read the file: \n"+path);
            System.out.println(e.getMessage());
        }
        start(aux);
        /*automaton.search(aux);
        automaton.getWords().closeFile();
        automaton.getProcess().closeFile();     */   
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
    
    static void cleanALL(){
        String words = "Practica07_WordsFound.txt";
        String process = "Practica07_Proccess.txt";
        cleanFILE(words);
        cleanFILE(process);
    }
}
