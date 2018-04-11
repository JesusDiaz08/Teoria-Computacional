package Practica05;

public class Practica05_Ack01 {
    private static String words_ACK="Practica05_wordsACK.txt";
    private static String historial_ACK ="Practica05_historialACK.txt";
    
    private static final String start = "start";
    private static final String A0="A0", A1="A1", A2="A2", A3="A3", A4="A4",
                                A5="A5", A6="A6", A7="A7", A8="A8";
    private static final String B0="B0", B1="B1", B2="B2", B3="B3", B4="B4";
    private static final String C0="C0", C1="C1", C2="C2", C3="C3", C4="C4",
                                C5="C5", C6="C6", C7="C7", C8="C8", C9="C9", 
                                C10="C10", C11="C11", C12="C12", C13="C13";
    private static final String D0="D0", D1="D1", D2="D2", D3="D3", D4="D4",
                                D5="D5", D6="D6", D7="D7";
    private static final String E0="E0", E1="E1", E2="E2", E3="E3", E4="E4",
                                E5="E5";
    private static final String F0="F0", F1="F1", F2="F2", F3="F3", F4="F4",
                                F5="F5", F6="F6", F7="F7", F8="F8", F9="F9",
                                F10="F10";
    private static final String G0="G0", G1="G1", G2="G2", G3="G3", G4="G4",
                                G5="G5", G6="G6", G7="G7";

    private Practica05_validCharacter verifyCharacter;
    private Practica05_saveFile wordsACK,historialACK;
    private String wordAccepted = "", ACK_state = start;

    public Practica05_Ack01() {
        verifyCharacter = new Practica05_validCharacter();
        wordsACK = new Practica05_saveFile(words_ACK);
        historialACK = new Practica05_saveFile(historial_ACK);
    }

    public void searchAWord(String paquete) {
        for (int i = 0; i < paquete.length(); i++) {
            ACK_state = States_A(ACK_state, paquete.charAt(i));
            //System.out.println("ACK_State: "+ACK_state);
            if (ACK_state.equals(A8) || ACK_state.equals(B4) || ACK_state.equals(C5) ||
                ACK_state.equals(C13)|| ACK_state.equals(D7) || ACK_state.equals(D5) || 
                ACK_state.equals(E5) || ACK_state.equals(F4) || ACK_state.equals(F10)||
                ACK_state.equals(G7)) {
                System.out.println("Word found: " + wordAccepted);
                wordsACK.writeOnFile(wordAccepted);
            }
        }
    }

    /*Violencia's Automaton*/
    public String States_A(String actualState, char character) {
        String stateNow = "";
        if (verifyCharacter.isV(character)) {//V
            clearWA();
            stateNow = A0;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(A0)) {//I
            stateNow = A1;
            wordAccepted += character;
        } else if (verifyCharacter.isO(character) && actualState.equals(A1)) {//O
            stateNow = A2;
            wordAccepted += character;
        } else if (verifyCharacter.isL(character) && actualState.equals(A2)) {//L
            stateNow = A3;
            wordAccepted += character;
        } else if (verifyCharacter.isE(character) && actualState.equals(A3)) {//E
            stateNow = A4;
            wordAccepted += character;
        } else if (verifyCharacter.isN(character) && actualState.equals(A4)) {//N
            stateNow = A5;
            wordAccepted += character;
        } else if (verifyCharacter.isC(character) && actualState.equals(A5)) {//C
            stateNow = A6;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(A6)) {//I
            stateNow = A7;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(A7)) {//A
            stateNow = A8;
            wordAccepted += character;
        } else {
            stateNow = States_B(actualState, character);
        }
        historialACK.writeOnFile(actualState+"~~~"+character+" -> "+stateNow);
        return stateNow;
    }

    /*Robar's Automaton*/
    public String States_B(String actualState, char character) {
        String stateNow = "";
        if (verifyCharacter.isR(character) && !actualState.equals(F9) && !actualState.equals(E4)
                && !actualState.equals(C1) && !actualState.equals(C6) && !actualState.equals(D6)
                && !actualState.equals(C4) && !actualState.equals(B3) && !actualState.equals(G0)
                && !actualState.equals(G6)) {//R
            clearWA();
            stateNow = B0;
            wordAccepted += character;
        } else if (verifyCharacter.isO(character) && actualState.equals(B0)) {//O
            stateNow = B1;
            wordAccepted += character;
        } else if (verifyCharacter.isB(character) && actualState.equals(B1)) {//B
            stateNow = B2;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(B2)) {//A
            stateNow = B3;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(B3)) {//R
            stateNow = B4;
            wordAccepted += character;
        } else {
            stateNow = States_C(actualState, character);
        }
        return stateNow;
    }

    /*Copiar y Corrupción Automatons*/
    public String States_C(String actualState, char character) {
        String stateNow = "";
        if (verifyCharacter.isC(character) && !actualState.equals(C9) && 
            !actualState.equals(F7) && !actualState.equals(G4)) {//C
            clearWA();
            stateNow = C0;
            wordAccepted += character;
        } else if (verifyCharacter.isO(character) && actualState.equals(C0)) {//O
            stateNow = C1;
            wordAccepted += character;
        } else if (verifyCharacter.isP(character) && actualState.equals(C1)) {//P
            stateNow = C2;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(C2)) {//I
            stateNow = C3;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(C3)) {//A
            stateNow = C4;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(C4)) {//R
            stateNow = C5;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(C1)) { //R: Corrupción
            stateNow = C6;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(C6)) {//R
            stateNow = C7;
            wordAccepted += character;
        } else if (verifyCharacter.isU(character) && actualState.equals(C7)) {//U
            stateNow = C8;
            wordAccepted += character;
        } else if (verifyCharacter.isP(character) && actualState.equals(C8)) {//P
            stateNow = C9;
            wordAccepted += character;
        } else if (verifyCharacter.isC(character) && actualState.equals(C9)) {//C
            stateNow = C10;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(C10)) {//I
            stateNow = C11;
            wordAccepted += character;
        } else if (verifyCharacter.isO(character) && actualState.equals(C11)) {//O
            stateNow = C12;
            wordAccepted += character;
        } else if (verifyCharacter.isN(character) && actualState.equals(C12)) {//N
            stateNow = C13;
            wordAccepted += character;
        } else {
            stateNow = States_D(actualState, character);
        }
        return stateNow;
    }

    /*Engaño y Engañar Automatons*/ 
    public String States_D(String actualState, char character) {
        String stateNow = "";
        if (verifyCharacter.isE(character) && !actualState.equals(E0)) { //E
            clearWA();
            stateNow = D0;
            wordAccepted += character;
        } else if (verifyCharacter.isN(character) && actualState.equals(D0)) {//N
            stateNow = D1;
            wordAccepted += character;
        } else if (verifyCharacter.isG(character) && actualState.equals(D1)) {//G
            stateNow = D2;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(D2)) {//A
            stateNow = D3;
            wordAccepted += character;
        } else if (verifyCharacter.isÑ(character) && actualState.equals(D3)) {//Ñ
            stateNow = D4;
            wordAccepted += character;
        } else if (verifyCharacter.isO(character) && actualState.equals(D4)) {//O
            stateNow = D5;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(D4)) { //A: Engañar
            stateNow = D6;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(D6)) {//R
            stateNow = D7;
            wordAccepted += character;
        } else {
            stateNow = States_E(actualState, character);
        }
        return stateNow;
    }

    /*Mentir's Automaton*/
    public String States_E(String actualState, char character) {
        String stateNow = "";
        if (verifyCharacter.isM(character)) {//M
            clearWA();
            stateNow = E0;
            wordAccepted += character;
        } else if (verifyCharacter.isE(character) && actualState.equals(E0)) {//E
            stateNow = E1;
            wordAccepted += character;
        } else if (verifyCharacter.isN(character) && actualState.equals(E1)) {//N
            stateNow = E2;
            wordAccepted += character;
        } else if (verifyCharacter.isT(character) && actualState.equals(E2)) {//T
            stateNow = E3;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(E3)) {//I
            stateNow = E4;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(E4)) {//R
            stateNow = E5;
            wordAccepted += character;
        } else {
            stateNow = States_F(actualState, character);
        }
        return stateNow;
    }

    /*Falso y Falsificar Automatons*/
    public String States_F(String actualState, char character) {
        String stateNow = "";
        if (verifyCharacter.isF(character) && !actualState.equals(F5) &&
                                              !actualState.equals(G2)) {//F
            clearWA();
            stateNow = F0;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(F0)) {//A
            stateNow = F1;
            wordAccepted += character;
        } else if (verifyCharacter.isL(character) && actualState.equals(F1)) {//L
            stateNow = F2;
            wordAccepted += character;
        } else if (verifyCharacter.isS(character) && actualState.equals(F2)) {//S
            stateNow = F3;
            wordAccepted += character;
        } else if (verifyCharacter.isO(character) && actualState.equals(F3)) {//O
            stateNow = F4;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(F3)) { //I: Falsificar
            stateNow = F5;
            wordAccepted += character;
        } else if (verifyCharacter.isF(character) && actualState.equals(F5)) {//F
            stateNow = F6;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(F6)) {//I
            stateNow = F7;
            wordAccepted += character;
        } else if (verifyCharacter.isC(character) && actualState.equals(F7)) {//C
            stateNow = F8;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(F8)) {//A
            stateNow = F9;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(F9)) {//R
            stateNow = F10;
            wordAccepted += character;
        } else {
            stateNow = States_G(actualState, character);
        }
        return stateNow;
    }

    /*Traficar Automaton*/
    public String States_G(String actualState, char character) {
        String stateNow = "";
        if (verifyCharacter.isT(character)) {//T
            clearWA();
            stateNow = G0;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(G0)) {//R
            stateNow = G1;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(G1)) {//A
            stateNow = G2;
            wordAccepted += character;
        } else if (verifyCharacter.isF(character) && actualState.equals(G2)) {//F
            stateNow = G3;
            wordAccepted += character;
        } else if (verifyCharacter.isI(character) && actualState.equals(G3)) {//I
            stateNow = G4;
            wordAccepted += character;
        } else if (verifyCharacter.isC(character) && actualState.equals(G4)) {//C
            stateNow = G5;
            wordAccepted += character;
        } else if (verifyCharacter.isA(character) && actualState.equals(G5)) {//A
            stateNow = G6;
            wordAccepted += character;
        } else if (verifyCharacter.isR(character) && actualState.equals(G6)) {//R
            stateNow = G7;
            wordAccepted += character;
        } else {
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
    
    public Practica05_saveFile getHistorial(){
        return historialACK;
    }
    
    public Practica05_saveFile getWords(){
        return wordsACK;
    }
}
