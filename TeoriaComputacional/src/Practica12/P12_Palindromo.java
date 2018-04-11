package Practica12;

import java.util.ArrayList;
import java.util.Arrays;

/*@author Home*/
public class P12_Palindromo {
    
    private final String construction = "Practica12_Construction.txt";
    private P12_toFile Construction;
    
    public P12_Palindromo() {
        Construction = new P12_toFile(construction);
        Construction.writeSth("|--- Construction of Palindrome ---|");
    }
    
    public void single(){
        int i = randomNumber(3);
        if (i==2){ 
            Construction.writeSth("P -> e");
            System.out.println("| Palindrome: e.\n");
            Construction.writeSth("Palindrome: e");
        }else{
            Construction.writeSth("P -> "+i);
            System.out.printf("| Palindrome: %d\n",i);
            Construction.writeSth("Palindrome: "+i);
        }
    }
    public int Palindrome_even(int length){ /*Par*/
        int random, i, j, k, mitad=0,x;
        String cadena;
        char p[] = new char[length+2];
        char string[] = new char[length+2];
        ArrayList<String> reglas = new ArrayList<>();
        
        for (i = 0; i < string.length; i++) /*Init aux*/
            string[i]=' ';
        
        mitad = length/2;  
	random = randomNumber();
        
	if(random==0){  /*Put 0's*/
            for (i=0; i<2; i++){ /*Regla 4: 0P0*/
                p[i]='0';
            }
	}
	if(random==1){ /*Puts 1's*/
            for (i=0; i<2; i++){
            	p[i]='1';       /*Regla 5: 1P1*/
            }
	}
	if (length==2){
                System.out.println("| P -> "+p[0]+"P"+p[0]);
                System.out.println("| P -> e");
                cadena = String.valueOf(p);
                System.out.println("| Palindrome generated: "+cadena);
                Construction.writeSth("P -> "+p[0]+"P"+p[0]);
                Construction.writeSth("P -> e");
                Construction.writeSth("\nPalindrome generated: "+cadena);
                Construction.closeFile();
		return 0;
	}
        reglas.add(""+p[0]);
        
	for (i=1; i<mitad; i++){
            random = randomNumber();
                        
            if (random==0){
                string[0]='0'; /*P -> 0*/
                reglas.add(""+string[0]);
                for (j=1; j<string.length; j++){ 
                    string[j]=p[j-1];  /*Generate P*/
                }
                for (k=0; k<string.length; k++){ /*Recorre*/
                    if (string[k]=='\0'){
                        string[k]='0';
                        string[k+1]='\0';
                        break;
                    }
                }
                j=0;
                k=0;
            }
            if (random==1){
                string[0]='1'; /*P -> 1*/
                reglas.add(""+string[0]);
                for (j=1; j<string.length; j++){
                    string[j]=p[j-1];                    
                }
                for (k=0; k<string.length; k++){
                    if (string[k]=='\0'){
                        string[k]='1';
                        string[k+1]='\0';
                        break;  
                    }
                }
                j=0;
                k=0;
            }
            for (k=0; k<string.length; k++){
                p[k]=string[k]; /* New pseudo-palindrome/Palindrome Final */
            }
	}
        cadena = new String(string); /*Palindrome final*/
        x = reglas.size()-1;
        
        System.out.println("| P -> "+reglas.get(x)+"P"+reglas.get(x));
        Construction.writeSth("P -> "+reglas.get(x)+"P"+reglas.get(x));
        
        for (int l = (x-1); l>=0 ; l--) {
            System.out.println("| P -> "+reglas.get(l));
            Construction.writeSth("P -> "+reglas.get(l));
        }
        
        System.out.println("| P -> e");
        Construction.writeSth("P -> e");
        
        System.out.println("| Palindrome generated: "+cadena);
        Construction.writeSth("\nPalindrome generated: "+cadena);
        Construction.closeFile();
        return 0;
    }
    public int Palindrome_odd(int length){ /*impar*/
        int random, i, j, k, mitad=0,x;
        String cadena;
        char p[] = new char[length+2];
        char string[] = new char[length+2];
        ArrayList<String> reglas = new ArrayList<>();
        
        for (i = 0; i < string.length; i++) /*Init aux*/
            string[i]=' ';
        
        mitad= (length-1)/2;
	random=randomNumber();
        
	if(random==0){
            p[0]='0'; /* P -> 0P0 */
	}
	if(random==1){
            p[0]='1'; /* P -> 1P1 */
	}
        
        reglas.add(""+p[0]);
        
	if(length>1){
            for (i=0; i<mitad; i++){
            random=randomNumber();
            
            if (random==0){
                string[0]='0';  /* P -> 0*/
                reglas.add(""+string[0]);
                
		for (j=1; j<string.length; j++){
                    string[j]=p[j-1];
		}
		for (k=0; k<string.length; k++){
                    if (string[k]=='\0'){
                        string[k]='0';
			string[k+1]='\0';
			break;
                    }
		}
		j=0;
		k=0;
            }
            
            if (random==1){
                string[0]='1';  /* P -> 1*/
                reglas.add(""+string[0]);
                
		for (j=1; j<string.length; j++){
                    string[j]=p[j-1];
		}
		for (k=0; k<string.length; k++){
                    if (string[k]=='\0'){
                        string[k]='1';
                        string[k+1]='\0';
			break;
                    }
                }
		j=0;
		k=0;
            }
            for (k=0; k<string.length; k++){
                p[k]=string[k]; /* New pseudo-palindrome/Palindrome Final */
            }
	}
        
        cadena = new String(string); /*Palindrome final*/
        x = reglas.size()-1;
        
        System.out.println("| P -> "+reglas.get(x)+"P"+reglas.get(x));
        Construction.writeSth("P -> "+reglas.get(x)+"P"+reglas.get(x));
        
        for (int l = (x-1); l>=0 ; l--) {
            System.out.println("| P -> "+reglas.get(l));
            Construction.writeSth("P -> "+reglas.get(l));
        }
        
        System.out.println("| Palindrome generated: "+cadena);
        Construction.writeSth("\nPalindrome generated: "+cadena);
        Construction.closeFile();
        }
        return 0;
    }
    
    public void verifyType(int length){
        if (length<=0) 
            System.out.printf("Can't create a palindrome of length %d.\n",length);
        
        if (length==1) 
            single();
        
        if (length >0 && length%2==0)
            Palindrome_even(length);
            
        else if(length>0 && length%2==1)
            Palindrome_odd(length);
        
    }
    
    public void automatic(int dimension){
        int length = randomNumber(dimension);
        
        if (length==0){ 
            System.out.println("| Random: 1");
            verifyType(1);
        }else{
            System.out.println("| Random: "+length);
            verifyType(length);
        }
    }
    
    
    
    public int randomNumber() {
        return ((int) (Math.random() * 2));
    }
    
    public int randomNumber(int length){
        return ((int) (Math.random()*length));
    }
    
    public boolean isPalindrome(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
