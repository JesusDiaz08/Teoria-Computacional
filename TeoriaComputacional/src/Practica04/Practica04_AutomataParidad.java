package Practica04;

import java.io.*;

/*@author Díaz Medina Jesús Kaimorts*/
public class Practica04_AutomataParidad {

    int q0 = 0, q1 = 1, q2 = 2, q3 = 3;
    int edoAct = 0;

    public void verifyParidad(String cadena) throws IOException {
        Practica04_generateString eF = new Practica04_generateString();
        String nameFile = "Practica04_AutomatonPath.txt";   //PATH's FILE
        File isFile = new File(nameFile);
        
        if (eF.existFile(isFile)) {
            FileWriter fw = new FileWriter(nameFile, true);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < cadena.length(); i++) {
                switch (cadena.charAt(i)) {
                    case '0':
                        if (edoAct == q0) {
                            edoAct = q1;
                            pw.write("\r\n");
                            pw.write("\tq0->q1");
                            pw.write("\r\n");
                        } else if (edoAct == q1) {
                            edoAct = q0;
                            pw.write("\tq1->q0");
                            pw.write("\r\n");
                        } else if (edoAct == q2) {
                            edoAct = q3;
                            pw.write("\tq2->q3");
                            pw.write("\r\n");
                        } else if (edoAct == q3) {
                            edoAct = q2;
                            pw.write("\tq3->q2");
                            pw.write("\r\n");
                        }
                        break;

                    case '1':
                        if (edoAct == q0) {
                            edoAct = q2;
                            pw.write("\r\n");
                            pw.write("\tq0->q2");
                            pw.write("\r\n");
                        } else if (edoAct == q2) {
                            edoAct = q0;
                            pw.write("\tq2->q0");
                            pw.write("\r\n");
                        } else if (edoAct == q1) {
                            edoAct = q3;
                            pw.write("\tq1->q3");
                            pw.write("\r\n");
                        } else if (edoAct == q3) {
                            edoAct = q1;
                            pw.write("\tq3->q1");
                            pw.write("\r\n");
                        }
                        break;
                }
            }
            pw.close();
        }else
            System.err.println("ERROR. FILE NOT FOUND");

    }

    public int getEdoAct() {
        return edoAct;
    }

    public void setEdoAct(int edoAct) {
        this.edoAct = edoAct;
    }

    public int q0() {
        return q0;
    }

    public void setq0(int q0) {
        this.q0 = q0;
    }
}
