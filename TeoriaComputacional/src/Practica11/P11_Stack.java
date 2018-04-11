package Practica11;

import java.util.ArrayList;

/*@author Jesus Kaimorts Díaz Medina */
public class P11_Stack {
    private ArrayList<P11_Elemento> pila;
    private int top=0;
    private char z = 'Z';
    
    public P11_Stack(){
        pila = new ArrayList<>();
        initStack();
    }
    
    public void initStack(){
        pila.add(new P11_Elemento(z));
    }
    
    public void push(char caracter) {        
        pila.add(new P11_Elemento(caracter));
    }
    
    public char pop() {
        char aux = ' ';
        if (pila.isEmpty()) {
            System.out.println("There's nothing");
            System.exit(0);
        }else{
            aux = pila.get(pila.size()-1).getElement();
            pila.remove(pila.size()-1); /*Clean the last element of stack*/
        }
        return aux;
    }
    
    public char top(){
        return pila.get(pila.size()-1).getElement();
    }
    
    public boolean isEmpty() {
        return (pila.get(pila.size()-1).getElement()=='Z');
    }
    
    public void setTop(char character){
        this.z = character;
    }
}
