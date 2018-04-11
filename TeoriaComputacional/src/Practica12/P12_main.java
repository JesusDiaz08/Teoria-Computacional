package Practica12;
/*@author Jesus Kaimorts Díaz Medina*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12_main {
    public static void main() {
        P12_Palindromo palindrome;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int option=0,length;
        boolean continuar = true;
        System.out.println("|----- PALINDROME -----|");
        
        while(continuar){
            option=0;
            menu();
            try {
                option = Integer.parseInt(teclado.readLine());
                System.out.println("|----------------------|");
                switch(option){
                    case 1:
                        palindrome = new P12_Palindromo();
                        System.out.print("| Length:   ");
                        length = Integer.parseInt(teclado.readLine());
                        palindrome.verifyType(length);
                        break;
                    case 2: 
                        palindrome = new P12_Palindromo();
                        System.out.print("| Dimension:   ");
                        length = Integer.parseInt(teclado.readLine());
                        palindrome.automatic(length);
                        break;
                    case 3:
                        palindrome = new P12_Palindromo();
                        System.out.print("| String:   ");
                        if (palindrome.isPalindrome(teclado.readLine()))
                            System.out.println("| It is a Palindrome   |");
                        else
                            System.out.println("| It is not a Palindrome  |");
                        
                        break;
                    case 4: 
                        continuar = false;
                        break;
                    default:
                        System.out.println("Choosen other option, please.\n");
                        break;
                }
            } catch (IOException e) {
                System.out.println("There was an error.");
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void menu(){
        System.out.println("|-------- MENU --------|");
        System.out.println("| 1. MANUAL            |");
        System.out.println("| 2. AUTOMATIC         |");
        System.out.println("| 3. VERIFY IF IS      |");
        System.out.println("| 4. EXIT              |");
        System.out.print("|  ->\t");
    }
}
