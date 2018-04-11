package Practica10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*@author Jesús Kaimorts Díaz Medina*/
public class P10_saveFile {
    private String path = "Practica10_RegularExpresion02.txt";
    private FileWriter fw;
    
    public P10_saveFile(){
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
            fw.write(data); /*Write data*/
            fw.write("\r\n"); /*Enter*/
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
