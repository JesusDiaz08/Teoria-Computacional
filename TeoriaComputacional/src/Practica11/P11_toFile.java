package Practica11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*@author Jesús Kaimorts Díaz Medina*/
public class P11_toFile {
    private String nameFile;
    File file;
    FileWriter fw;

    public P11_toFile(String name) {
        try {
            this.nameFile = name;
            file = new File(this.nameFile);
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.err.println("There was an error to create file.\n");
            System.err.println(e.getMessage());
        }
    }
    
    public void writeSth(String str){
        try {
            fw.write(str);
            fw.write("\r\n");
        } catch (Exception e) {
            System.err.println("There was an error to write on file.\n");
            System.err.println(e.getMessage());
        }
    }
    
    public void closeFile(){
        try {
            fw.close();
        } catch (Exception e) {
            System.err.println("There was an error to close the file.\n");
            System.err.println(e.getMessage());
        }
    }
}
