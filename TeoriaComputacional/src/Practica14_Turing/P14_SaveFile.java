package Practica14_Turing;

/*@author Jesus Kaimorts Díaz Medina*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class P14_SaveFile {
    private String path = "Practica14_TuringMachine.txt";
    private FileWriter fw;
    
    public P14_SaveFile(){
        try {
            File file = new File(path);
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.err.println("Error to create file: "+e.getMessage());
        }
    }
    
    public void isFile(File file){
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("The file exists.");
                file.delete();
            }
        } else {
            file.delete();
            System.out.println("File've been created. ");
        }
    }
    
    public void write_sth(String data){
        try {
            fw.write(data);   /*Write data*/
        } catch (IOException e) {
            System.err.println("Error to create file: "+e.getMessage());
        }
    }
    
    public void closeFile(){
        try {
            fw.close();
        } catch (IOException e) {
            System.err.println("Error to create file: "+e.getMessage());
        }
    }
}
