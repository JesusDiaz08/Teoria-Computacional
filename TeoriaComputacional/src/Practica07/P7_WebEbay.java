package Practica07;

import java.io.File;

/*@author Jesus Kaimorts Díaz Medina*/

public class P7_WebEbay {
    private String words = "Practica07_WordsFound.txt";
    private String process = "Practica07_Proccess.txt";
   
    private String start = "start";
    
    private String Q1="Q1",Q2="Q2",Q3="Q3"; /*WEB*/
    private String Q4="Q4",Q5="Q5",Q6="Q6",Q7="Q7"; /*EBAY*/
    
    private P7_toFile WordsF, ProcessF;
    private P7_Alphabet verify;
    
    private String wordAccepted = "", StateG = start;
    
    public P7_WebEbay(){
        verify = new P7_Alphabet();
        WordsF = new P7_toFile(words);
        ProcessF = new P7_toFile(process);
    }
    
    public void search(String str){
        for (int j = 0; j < str.length(); j++) {
            StateG = automatonWEB(StateG, str.charAt(j));
            if (StateG.equals(Q3) || StateG.equals(Q7)) {
                System.out.println("Word Found: "+wordAccepted);
                WordsF.writeSth(wordAccepted);
            }
        }
    }
    
    public String automatonWEB(String actualState,char character){
        String ebay="";
        String stateNow ="";
        if (verify.isW(character) && ( actualState.equals(start) || 
            actualState.equals(Q1) || actualState.equals(Q2) ||
            actualState.equals(Q3) || actualState.equals(Q4) || 
            actualState.equals(Q5) || actualState.equals(Q6) || 
            actualState.equals(Q7)) ) { //W
            clearWA();
            stateNow = Q1;
            wordAccepted += character;
        }else if(verify.isE(character) && actualState.equals(Q1)){ //E
            stateNow = Q2;
            wordAccepted += character;
        }else if(verify.isB(character) && actualState.equals(Q2)){ //B
            stateNow = Q3;
            wordAccepted += character;
        }else {
            stateNow = automatonEBAY(actualState,character);
        }
        ProcessF.writeSth(actualState+" --- "+character+" -> "+stateNow);
        return stateNow;
    }
    
    public String automatonEBAY(String actualState,char character){
        String stateNow = "";
        if (verify.isE(character) && (actualState.equals(start) || 
            actualState.equals(Q2) || actualState.equals(Q3) || 
            actualState.equals(Q4) || actualState.equals(Q5) ||
            actualState.equals(Q6) || actualState.equals(Q7) ) ) { //E
            clearWA();
            stateNow = Q4;
            wordAccepted += character;
        }else if(verify.isB(character) && actualState.equals(Q4)){ //B
            stateNow = Q5;
            wordAccepted += character;
        }else if(verify.isA(character) && (actualState.equals(Q5) ||
                 actualState.equals(Q3)) ){ //A
            stateNow = Q6;
            wordAccepted += character;
        }else if(verify.isY(character) && actualState.equals(Q6)){ //Y
            stateNow = Q7;
            wordAccepted += character;
        }else{
            stateNow = start;
            wordAccepted = "";
        }
        return stateNow;
    }
    
    public void clearWA() {
        if (!wordAccepted.isEmpty()) {
            wordAccepted = "";
        }
    }
    
    public P7_toFile getWords(){
        return WordsF;
    }
    
    public P7_toFile getProcess(){
        return ProcessF;
    }
    
    
}
