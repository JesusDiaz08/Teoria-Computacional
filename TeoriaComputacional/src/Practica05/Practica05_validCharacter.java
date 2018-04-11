package Practica05;

/*@author Home*/
public class Practica05_validCharacter{
/*------------------Vocales------------------*/
    public boolean isA(char character){
   	boolean a=false;
        if (character == 'a' || character == 'á' || 
            character == 'A' || character == 'Á') {
            a=true;
	}
            return a;
    }

    public boolean isE(char character){
    	boolean e=false;
    	if (character == 'e' || character == 'é' || 
            character == 'E' || character == 'É') {
            e=true;
	}
	return e;
    }

    public boolean isI(char character){
    	boolean i=false;
    	if (character == 'i' || character == 'í' || 
            character == 'I' || character == 'Í') {
            i=true;
        }
	return i;
    }

    public boolean isO(char character){
    	boolean o=false;
    	if (character == 'o' || character == 'ó' || 
            character == 'O' || character == 'Ó') {
            o=true;
        }
        return o;
    }

    public boolean isU(char character){
        boolean u= false;
        if (character == 'u' || character == 'ú' || 
            character == 'U' || character == 'Ú') {
            u=true;
        }
        return u;
    }
/*-------------------------------------------*/

/*----------------Consonantes----------------*/
    public boolean isB(char character){
        boolean b=false;
	if (character == 'b' || character=='B') {
            b=true;
	}
	return b;
    }

    public boolean isC(char character){
        boolean c=false;
	if (character == 'c' || character=='C') {
            c=true;
	}
	return c;
    }
    
    public boolean isD(char character){
        boolean d=false;
	if (character == 'd' || character=='D') {
            d=true;
        }
        return d;
    }

    public boolean isF(char character){
    	boolean f=false;
    	if (character == 'f' || character=='F') {
            f=true;
        }
	return f;
    }

    public boolean isG(char character){
    	boolean g=false;
    	if (character == 'g' || character=='G') {
            g=true;
        }
	return g;
    }

    public boolean isH(char character){
    	boolean h=false;
    	if (character == 'h' || character=='H') {
            h=true;
        }
        return h;
    }

    public boolean isJ(char character){
    	boolean j=false;
	if (character == 'j' || character=='J') {
            j=true;
        }
        return j;
    }

    public boolean isK(char character){
    	boolean k=false;
    	if (character == 'k' || character=='K') {
            k=true;
        }
        return k;
    }

    public boolean isL(char character){
        boolean l=false;
        if (character == 'l' || character=='L') {
            l=true;
        }
        return l;
    }
    
    public boolean isM(char character){
        boolean m=false;
        if (character == 'm' || character=='M') {
            m=true;
        }
        return m;
    }

    public boolean isN(char character){
        boolean n=false;
        if (character == 'n' || character=='N') {
            n=true;
        }
        return n;
    }
    
    public boolean isÑ(char character){
        boolean enie =false;
        if ( (Character.isLetter(character) == Character.isLetter('ñ') ) || 
             (Character.isLetter(character) == Character.isLetter('Ñ') ) ) {
              enie=true;
        }
        return enie;
    }
    
    public boolean isP(char character){
        boolean p=false;
        if (character == 'p' || character=='P') {
            p=true;
        }
        return p;
    }
    
    public boolean isQ(char character){
        boolean q=false;
        if (character == 'q' || character=='Q') {
            q=true;
        }
        return q;
    }
    
    public boolean isR(char character){
        boolean r=false;
        if (character == 'r' || character=='R') {
            r=true;
        }
        return r;
    }

    public boolean isS(char character){
        boolean s=false;
        if (character == 's' || character=='S') {
            s=true;
        }
        return s;
    }
    
    public boolean isT(char character){
        boolean t=false;
        if (character == 't' || character=='T') {
            t=true;
        }
        return t;
    }
    
    public boolean isV(char character){
        boolean v=false;
        if (character == 'v' || character=='V') {
            v=true;
        }
        return v;
    }
    
    public boolean isW(char character){
        boolean w=false;
        if (character == 'w' || character=='W') {
            w=true;
        }
        return w;
    }
    
    public boolean isX(char character){
        boolean x=false;
        if (character == 'x' || character=='X') {
            x=true;
        }
	return x;
    }
    
    public boolean isY(char character){
        boolean y=false;
        if (character == 'y' || character=='Y') {
            y=true;
        }
        return y;
    }

    public boolean isZ(char character){
        boolean z=false;
        if (character == 'z' || character=='Z') {
            z=true;
        }
        return z;
    }
/*-------------------------------------------*/
}
