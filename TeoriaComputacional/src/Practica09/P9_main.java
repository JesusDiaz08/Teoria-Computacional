package Practica09;
/*@author Jesus Kaimorts Díaz Medina*/
import Practica10.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9_main {
    public static void main() {
        boolean continuar = true;
        int opt,opt2;
        P9_RE re_01 = new P9_RE();
        P10_RE re_02 = new P10_RE();
        ArrayList<String> expresionR = new ArrayList<>();
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        while(continuar){
            try {
                expresionR.clear();
                menu();
                opt = Integer.parseInt(teclado.readLine());
                System.out.println("|--------------------------------------------------------|\n");
                switch(opt){
                    case 1:
                        do {
                            re_01.repeat(expresionR);
                            subMenu();
                            opt2 = opt = Integer.parseInt(teclado.readLine());
                        } while (opt2==1);
                        System.out.println("|-------------------|");
                    break; 
                
                    case 2:
                        do {
                            re_02.repeat(expresionR);
                            subMenu();
                            opt2 = opt = Integer.parseInt(teclado.readLine());
                        } while (opt2==1);
                        System.out.println("|-------------------|");
                    break;
                    
                    case 3:
                    continuar = false;
                    break;
                }
            } catch (IOException e) {
                System.err.println("There was an error: "+e.getMessage());
            }  
        }
    }
    
    public static void menu(){
        System.out.println("|------------------ Regular Expression ------------------|");
        System.out.println("|   1. (0+10)*(e+1)                                      |");
        System.out.println("|   2. [(10)*0 + 1(01)*1][0(01)*(1+00) + 1(10)*(0+11)]*  |");
        System.out.println("|   3. Salir                                             |");
        System.out.print("| ->\t");
    }
    public static void subMenu(){
        System.out.println("|----- 5 more? -----|");
        System.out.println("| 1. Yes            |");
        System.out.println("| 2. No             |");
        System.out.print("| ->\t");
    }
}
