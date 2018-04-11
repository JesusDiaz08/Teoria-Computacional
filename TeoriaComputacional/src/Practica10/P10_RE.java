package Practica10;

import java.util.ArrayList;

/*@author Jesus Kaimorts Díaz Medina*/

public class P10_RE {
    private final int MAX=10;
    private int digitRandom = randomNumber(MAX);
    private P10_saveFile file;
    
    public int randomNumber() {
        return ((int) (Math.random() * 2));
    }
    
    public int randomNumber(int number) {
        return ((int) (Math.random() * number));
    }
    
    public String[] KleeneClosure_10(){
        String[] RE = new String[digitRandom+1];
        String symbol="10";
        String KleenClause_10 = "";
        RE[0]="e";
        for (int i = 1; i < RE.length; i++) {
            KleenClause_10 = KleenClause_10+symbol;
            RE[i]=KleenClause_10;
        }
        
        /*for (int i = 0; i < RE.length; i++) 
            System.out.println("RE["+(i+1)+"]: "+RE[i]);*/
        
        return RE;
    }
    
    public String[] KleeneClosure_01(){
        String[] RE = new String[digitRandom+1];
        String symbol="01";
        String KleenClause_10 = "";
        RE[0]="e";
        for (int i = 1; i < RE.length; i++) {
            KleenClause_10 = KleenClause_10+symbol;
            RE[i]=KleenClause_10;
        }
        
        /*for (int i = 0; i < RE.length; i++) 
            System.out.println("RE["+(i+1)+"]: "+RE[i]);*/
        
        return RE;
    }
    
    public String firstOR_m(){ //(1+00): W
        String symbol="";
        String[] alphabet={"1","00"};
        int j = randomNumber();
        if (j==1)  //alphabet[1]=1
            symbol = alphabet[j];
        else       //alphabet[0]=00
            symbol = alphabet[j];
        
        return symbol;        
    }
    
    public String secondOR_m(){ //(0+11): X
        String symbol="";
        String[] alphabet={"0","11"};
        int j = randomNumber();
        if (j==1)  //alphabet[1]=1
            symbol = alphabet[j];
        else       //alphabet[0]=00
            symbol = alphabet[j];
        
        return symbol;        
    }
    
    public String superior(){/*EN PROCESO: AQUI*/
        int random,k;
        String symbol="";
        String[] RE_total = new String[digitRandom];
        String[] RE_01 = new String[KleeneClosure_01().length];
        String[] RE_10 = new String[KleeneClosure_10().length];
        
        RE_01[0]="e";
        RE_10[0]="e";
        
        for (int i = 1; i <KleeneClosure_01().length; i++) /* 1(01)*1 */
            RE_01[i] = 1+KleeneClosure_01()[i] + 1;
        
        for (int i = 1; i <KleeneClosure_10().length; i++) /* (10)*0 */
            RE_10[i] = KleeneClosure_10()[i] + 0;
        
        random = randomNumber();
        
        if (random==1) {
            //System.out.println("--- 1(01)*1 ---");
            /*for (int i = 0; i < RE_01.length; i++) 
                /*System.out.println("RE_01["+(i+1)+"]: "+RE_01[i]);*/
            
            RE_total = RE_01;
        }else{
            //System.out.println("--- (10)*0 ---");
            /*for (int i = 0; i < RE_10.length; i++) 
                /*System.out.println("RE_10["+(i+1)+"]: "+RE_10[i]);*/
            RE_total = RE_10;
        }
        
        k = randomNumber(RE_total.length);
        //System.out.println("K de Superior: "+k);
        symbol = RE_total[k];
        
        return symbol;
    }
    
    public String[] inferior(){
        int random;
        String symbol_firstOR,symbol_secondOR;
        String[] RE_total;
        String[] RE_01 = new String[KleeneClosure_01().length];
        String[] RE_10 = new String[KleeneClosure_10().length];
        
        RE_01[0]="e";
        RE_10[0]="e";
        
        symbol_firstOR = firstOR_m();
        symbol_secondOR = secondOR_m();
        
        for (int i = 1; i <KleeneClosure_01().length; i++) /* 0(01)*(1+00) */
            RE_01[i] = 0+KleeneClosure_01()[i] + symbol_firstOR;
        
        for (int i = 1; i <KleeneClosure_10().length; i++) /* 1(10)*(0+11) */
            RE_10[i] = 1 + KleeneClosure_10()[i] + symbol_secondOR;
        
        random = randomNumber();
        
        if (random==1) {
            //System.out.println("--- 0(01)*(1+00) ---");
            /*for (int i = 0; i < RE_01.length; i++) 
                System.out.println("RE_01["+(i+1)+"]: "+RE_01[i]);*/
            RE_total = RE_01;
            
        }else{
            //System.out.println("--- 1(10)*(0+11) ---");
            /*for (int i = 0; i < RE_10.length; i++) 
                System.out.println("RE_10["+(i+1)+"]: "+RE_10[i]);*/
            
            RE_total = RE_10;
        }
        return RE_total;
    }
    
    public String RegularExpression(){
        String expresion;
        String[] inferior = inferior();
        String superior = superior();
                
        /*for (int i = 0; i < inferior.length; i++) 
            System.out.println(inferior[i]);*/
        
        if (!superior.equals("e")) {
            inferior[0]=superior;
            for (int i = 1; i < inferior.length; i++)
                inferior[i]=superior+inferior[i];            
        }
        
        /*for (int i = 0; i < inferior.length; i++) 
            System.out.println("["+i+"]: "+inferior[i]);*/
        
        int k = randomNumber(inferior.length);
        expresion =inferior[k];
                
        return expresion;
    }
    
    public void repeat(ArrayList<String> expresion){
        file = new P10_saveFile();
        for (int i = 0; i < 5; i++) 
            expresion.add(RegularExpression());
        
        for (int i = 0; i < expresion.size(); i++) 
            file.write_sth("RE["+(i+1)+"]: "+expresion.get(i));
        
        file.closeFile();
    }
}    