
package Practica11;

import java.io.FileReader;
import java.io.IOException;

/*@author Jesús Kaimorts Díaz Medina*/
public class P11_Automaton {
    private String secuencia = "Practica11_Sequence.txt";
    
    P11_toFile file;
    P11_Stack pila;
    
    
    public P11_Automaton(){
        pila = new P11_Stack();
        file = new P11_toFile(secuencia);
        file.writeSth("|------ Sequences of moves ------|");
    }
           
    public void readExpresion(String str){
        String z = "Z";
        System.out.println("(q, "+str+", "+pila.top()+")|-");
        file.writeSth("(q, "+str+", "+pila.top()+")|-");
        char[] expresion = str.toCharArray();
        
        try {
            for (int i = 0; i < expresion.length; i++){
                automaton(expresion[i]); 
            }
            proceso(str, ""+pila.top());
            if (pila.top()=='Z'){
                //System.out.println("(p,e,Z)ñ|-");
                System.out.println("(f,e,Z)");
                System.out.println("Stack is balanced");
                file.writeSth("(p,e,Z)|-");
                file.writeSth("(f,e,Z)");
                file.writeSth("Stack is balanced");
                file.writeSth("Thus: (q,"+str+",Z)|-*(f,e,Z)");
                file.closeFile();
            }else{
                System.out.println("Stack is not balanced");
            }
        } catch (Exception e) {
            System.out.println("It is not balanced.\n");
            System.exit(0);
        }
    }
    
    public void automaton(char element){
        if (element == '0'){
            pila.push('X');
        }else if(element == '1'){
            pila.pop();
        }
    }
    
   public void proceso(String str, String tope){
       String proccess="", stringNew="",x = "", aux="",xz="";
       char[] cadena = str.toCharArray();
       try {
           for (int i = 0; i < str.length(); i++) {
                stringNew = str.substring(i+1);
                aux= x;
                if (cadena[i]=='0') {
                    x = x+"X";
                    proccess = "(q,"+stringNew+","+x+"Z)|-";
                    System.out.println(proccess);
                    file.writeSth(proccess);
                   
                }
                if (cadena[i]=='1' && i>=1) {
                    xz = aux.substring(0,str.length()-i-1);
                    proccess = "(p,"+stringNew+","+xz+"Z)|-";
                    if (stringNew.equals("")) {
                        proccess = "(p,e,"+xz+"Z)|-";
                    }else
                        file.writeSth(proccess);
                        System.out.println(proccess);
                }
            }
       }catch (Exception e) {
           System.out.println("It is not balanced.\n");
           System.exit(0);
       }
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
            /*caracter = fR.read();
            aux += (char)caracter;*/
            fR.close();
        } catch (IOException e) {
            System.out.println("There was a error to read the file: \n"+path);
            System.out.println(e.getMessage());
        }
        System.out.println("Exp: "+aux);
        System.out.println("Expresion: "+aux.substring(0,aux.length()-1));
        readExpresion(aux.substring(0,aux.length()-1));
   }
   
}
