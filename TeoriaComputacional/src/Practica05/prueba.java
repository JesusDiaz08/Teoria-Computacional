/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Home
 */
public class prueba {
    public static void main(String[] args) throws IOException {
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        String eniez = "Eñe";
        char[] axs = eniez.toCharArray();
        
        char enie_m = 'ñ';
        int a = (int)enie_m;
        if (Character.isLetter(axs[1])==Character.isLetter('ñ')) {
            System.out.println("Es una ñ");
        }
        
        
        String sx = teclado.readLine(); /*minuscula*/
        char ai = sx.charAt(0);
        
        String gx = teclado.readLine(); /*mayuscula*/
        char bi = gx.charAt(0);
        int b = (int)bi;
        
        char enie_M = 'Ñ';
        
        if (enie_m == sx.charAt(0)) {
            System.out.println("Es ñ");
        }
        
        
        
        System.out.println("Ñ: "+(char)sx.charAt(0));
        System.out.println("ñ: "+(char)gx.charAt(0));
        
        
    }
}
