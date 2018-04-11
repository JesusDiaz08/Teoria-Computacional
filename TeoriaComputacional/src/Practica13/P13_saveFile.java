package Practica13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*@author Jesus Kaimorts Diaz Medina*/
public class P13_saveFile {

    private String path = "Practica13_Parentheses.txt";
    private FileWriter fw;

    public P13_saveFile() {
        try {
            File file = new File(path);
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.err.println("Error to create file: " + e.getMessage());
        }
    }

    public void isFile(File file) {
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

    public void write_sth(String data) {
        try {
            /*Write data*/
            fw.write(data);
            fw.write("\r\n");
        } catch (IOException e) {
            System.err.println("Error to create file: " + e.getMessage());
        }
    }

    public void closeFile() {
        try {
            fw.close();
        } catch (IOException e) {
            System.err.println("Error to create file: " + e.getMessage());
        }
    }
}
