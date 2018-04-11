package Practica09;
/*@author Jesus Kaimorts Díaz Medina*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class P9_saveFile {
    private String path = "Practica09_RegularExpresion01.txt";
    private FileWriter fw;
    
    public P9_saveFile(){
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
