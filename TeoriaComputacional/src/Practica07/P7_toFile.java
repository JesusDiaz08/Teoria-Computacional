package Practica07;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*@author Jesús Kaimorts Díaz Medina*/
public class P7_toFile {
    private String FILE = "Practica07_Web-Ebay.txt";
    private File file;
    private FileWriter fw;
    
    public P7_toFile(){
        try {
            file = new File(FILE);
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.out.println("There was an error.\n"+e.getMessage());
        }
    }
    
    public P7_toFile(String name){
         try {
            this.FILE = name;
            file = new File(this.FILE);
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.out.println("There was an error to open file."+name);
             System.out.println(e.getMessage());
        }
    }
    
    public void writeSth(String str){
        try {
            fw.write(str);
            fw.write("\r\n");
        } catch (IOException e) {
            System.out.println("There was an error to write on file:" + str);
            System.out.println(e.getMessage());
        }
    }
    
    public void closeFile(){
        try {
            fw.close();
        } catch (Exception e) {
            System.out.println("There was an error to close the file.\n");
            System.out.println(e.getMessage());
        }
    }
}
