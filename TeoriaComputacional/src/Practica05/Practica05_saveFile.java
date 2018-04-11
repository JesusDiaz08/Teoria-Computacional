package Practica05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*@author Home*/

public class Practica05_saveFile {
    private String nameFile;
    private File file;
    private FileWriter fw;

    public Practica05_saveFile(String nameFile) {
        this.nameFile = nameFile;
        try {
            file = new File(this.nameFile);
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.err.println("There was an error to create the file.\n"+e.getMessage());
        }
    }
    
    public void writeOnFile(String string){
        try {
            fw.write(string);
            fw.write("\r\n");
        } catch (IOException e) {
            System.err.println("There was an error to write on file.\n"+e.getMessage());
        }
    }
    
    public void closeFile(){
        try {
            fw.close();
        } catch (IOException e) {
            System.err.println("There was an error"+e.getMessage());
        }
    }
    
}
