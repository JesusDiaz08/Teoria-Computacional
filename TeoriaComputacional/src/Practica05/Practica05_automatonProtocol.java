package Practica05;
/*@author Díaz Medina Jesús Kaimorts*/

import java.io.*;
import java.util.ArrayList;


public class Practica05_automatonProtocol 
{   
    private String processProtocolo = "Practica05_ProcessOfProtocol.txt";
    private ArrayList<String> paquetes;
    private Practica05_Ack01 myACK;
    private Practica05_saveFile protocolo;
    
    /*States of Protocol*/
    private static final String start = "start", 
                                ready = "ready", 
                                sending = "sending";
    
    public Practica05_automatonProtocol(){
        myACK = new Practica05_Ack01();
        protocolo = new Practica05_saveFile(processProtocolo);
    }
    
    public void readBuffer(String string){
        dividePackages(string);
        for (int k = 0; k < paquetes.size(); k++) {
            if (protocolState(paquetes.get(k))==0) {
                k--;
            }
        }
        myACK.getWords().closeFile();
        myACK.getHistorial().closeFile();
    }
    
    public void readFile(String path){
        String auxiliarFile="";
        try {
            FileReader fR = new FileReader(path);
            int caracter = fR.read();
            while(caracter!=-1){ //Read all File
                caracter = fR.read();
                auxiliarFile += (char)caracter; //Join the pieces
            }
            //Read last character
            caracter = fR.read(); 
            auxiliarFile += (char)caracter;
            fR.close();
        } catch (IOException e) {
            e.getMessage();
        }
        readBuffer(auxiliarFile);
    }

    public void dividePackages(String pack){
        String hundredPackage="";
        paquetes = new ArrayList<>();
        
        if(pack.length()<100){
            paquetes.add(pack);
        }else if (pack.length() >= 100){
            for (int j = 0; j < pack.length(); j++) {
                hundredPackage += pack.charAt(j);
                if (j!=0 && (j%99==0)) {
                    System.out.println("Protocolo's package: "+hundredPackage);
                    paquetes.add(hundredPackage);
                    hundredPackage="";
                }
            }
            System.out.println("Protocolo's package: "+hundredPackage);
            if (!(hundredPackage.isEmpty())) {
                paquetes.add(hundredPackage);
            }
        }
    }

    public double protocolState(String paquete){ //Protocolo: ON_OFF
        String stateNow = start;
        double on_off = (int) (Math.random() * 2);
        
        if (on_off == 1) { //Protocol: On
            System.out.println("Protocolo: On");
            protocolo.writeOnFile(stateNow+"-- ON --->"+ready);
            stateNow = ready;
            stateNow = automataProtocol(paquete,stateNow);
        }else{
            System.out.println("Protocol: Off");
            protocolo.writeOnFile(stateNow+"-- OFF --->"+start);
        }
        return on_off;
    }
    
    public String automataProtocol(String paquete, String actualState){
        String UpdateState ="";
        if (actualState.equals(ready)){
            UpdateState = sending;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        protocolo.writeOnFile(actualState+"--->"+UpdateState);
        myACK.searchAWord(paquete);
        return UpdateState;
    }
    
    public Practica05_saveFile getProcessProtocol(){
        return protocolo;
    }
}

