package Practica09;

import java.util.ArrayList;
import Practica09.*;
/*@author Jesus Kaimorts Díaz Medina*/
public class P9_RE {
    private final int MAX=10;
    private int digitRandom = randomNumber(MAX) ;
    private P9_saveFile file;
    
    public String RegularExpresion(){
        int k=0;
        String[] RegularE = First_RE();
        String symbol = Second_RE();
        RegularE[0]="e";
        
        if(!symbol.equals("e")){
            for (int i = 1; i < RegularE.length; i++) 
            RegularE[i]=RegularE[i]+symbol;
        }
        k = randomNumber(RegularE.length);
        return RegularE[k];
    }
    
    public String[] First_RE(){
        String[] alphabet ={"0","10"};
        int i = randomNumber();
        String[] RegularExpresion = new String[digitRandom+1];
        
        if (i==1) { //alphabet[1]=10
            KleenClause(RegularExpresion, alphabet[i]);            
        }else{ //alphabet[0]=0;
            KleenClause(RegularExpresion, alphabet[i]);
        }
        return RegularExpresion;
    }
    
    public String Second_RE(){
        String[] alphabet ={"e","1"};
        int i = randomNumber();
        String symbol;
        if (i==1)   //alphabet[1]=1
            symbol = alphabet[i];
        else        //alphabet[0]=e;
            symbol = alphabet[i];
        
        return symbol;
    }
    
    public void KleenClause(String[] RegularExpresion,String symbol){
        String KleenClause="";
        RegularExpresion[0]="e";
        for (int j = 1; j < RegularExpresion.length; j++) {
            KleenClause = KleenClause+symbol;
            RegularExpresion[j]=KleenClause;
        }
    }
    
    public int randomNumber() {
        return ((int) (Math.random() * 2));
    }
    
    public int randomNumber(int number) {
        return ((int) (Math.random() * number));
    }
    
    public void repeat(ArrayList<String> expresion){
        file = new P9_saveFile();
        for (int i = 0; i < 5; i++) 
            expresion.add(RegularExpresion());
        
        for (int i = 0; i < expresion.size(); i++)
            file.write_sth("RE["+(i+1)+"]: "+expresion.get(i));
        file.closeFile();
    }    
}