package Graficos;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*@author Díaz Medina Jesús Kaimorts*/
public class Paridad extends Applet{
   
    public void graph(){
        Paridad paridad = new Paridad();
        JFrame frame = new JFrame();
        frame.add(paridad);
        frame.setVisible(true);
    }
    
    public void paint(Graphics g) {
        int x, y, z;
        int alto, ancho;
        setBackground(Color.ORANGE);
        g.setColor(Color.WHITE);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        g.setFont(f);
        x = 90;
        y = 15;
        g.drawString("AUTOMATA DE PARIDAD", x, y);
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.BLACK);
        
        Line2D l1 = new Line2D.Double(65, 60, 99, 60);
        g3.draw(l1);
        Arc2D arc = new Arc2D.Double(120, 40, 90, 60, 1, 180, 0);  //qo->sup
        g3.draw(arc);
        Arc2D arc1 = new Arc2D.Double(120, 130, 90, 60, 1, 180, 0); //q3-q2 sup
        g3.draw(arc1);
        Arc2D arc2 = new Arc2D.Double(120, 110, 90, 60, 180, 180, 0);//q3-q2 inf
        g3.draw(arc2);
        Arc2D arc3 = new Arc2D.Double(120, 20, 90, 60, 180, 180, 0);
        g3.draw(arc3);
        Arc2D arc4 = new Arc2D.Double(100, 65, 50, 80, 90, 180, 0);
        g3.draw(arc4);
        Arc2D arc5 = new Arc2D.Double(190, 65, 50, 80, 90, 180, 0);
        g3.draw(arc5);
        Arc2D arc6 = new Arc2D.Double(175, 65, 50, 80, 270, 180, 0);
        g3.draw(arc6);
        Arc2D arc7 = new Arc2D.Double(90, 65, 50, 80, 270, 180, 0);
        g3.draw(arc7);
        
        //Conectores
        Ellipse2D cirp1 = new Ellipse2D.Double(135, 70, 8, 8);
        g3.fill(cirp1);
        g3.draw(cirp1);
        Ellipse2D cirp2 = new Ellipse2D.Double(128, 77, 8, 8);
        g3.fill(cirp2);
        g3.draw(cirp2);
        Ellipse2D cirp3 = new Ellipse2D.Double(101, 128, 8, 8);
        g3.fill(cirp3);
        g3.draw(cirp3);
        Ellipse2D cirp4 = new Ellipse2D.Double(185, 132, 8, 8);
        g3.fill(cirp4);
        g3.draw(cirp4);
        Ellipse2D cirp5 = new Ellipse2D.Double(136, 159, 8, 8);
        g3.fill(cirp5);
        g3.draw(cirp5);
        Ellipse2D cirp6 = new Ellipse2D.Double(186, 42, 8, 8);
        g3.fill(cirp6);
        g3.draw(cirp6);
        Ellipse2D cirp7 = new Ellipse2D.Double(192, 125, 8, 8);
        g3.fill(cirp7);
        g3.draw(cirp7);
        Ellipse2D cirp8 = new Ellipse2D.Double(215, 79, 8, 8);
        g3.fill(cirp8);
        g3.draw(cirp8);
        Ellipse2D cirp9 = new Ellipse2D.Double(92, 56, 8, 8);
        g3.fill(cirp9);
        g3.draw(cirp9);
        
        
        Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Color.WHITE);
        Ellipse2D prim1 = new Ellipse2D.Double(100, 40, 40, 40);
        g1.draw(prim1);
        g1.fill(prim1);
        Ellipse2D prim2 = new Ellipse2D.Double(100, 130, 40, 40);
        g1.draw(prim2);
        g1.fill(prim2);
        Ellipse2D prim3 = new Ellipse2D.Double(190, 40, 40, 40);
        g1.draw(prim3);
        g1.fill(prim3);
        Ellipse2D prim4 = new Ellipse2D.Double(190, 130, 40, 40);
        g1.draw(prim4);
        g1.fill(prim4);
        g3.setColor(Color.BLACK);
        Ellipse2D rr1 = new Ellipse2D.Double(105, 45, 30, 30);
        g3.draw(rr1);
        Ellipse2D rr2 = new Ellipse2D.Double(105, 135, 30, 30);
        //g3.draw(rr2);
        Ellipse2D rr3 = new Ellipse2D.Double(195, 45, 30, 30);
        //g3.draw(rr3);
        Ellipse2D rr4 = new Ellipse2D.Double(195, 135, 30, 30);
        //g3.draw(rr4);
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 9);
        g.setFont(f1);
        g.drawString("q0", 115, 64);
        g.drawString("q1", 205, 64);
        g.drawString("q3", 115, 154);
        g.drawString("q2", 205, 154);
        g.drawString("0", 162, 35);
        g.drawString("0", 162, 75);
        g.drawString("0", 162, 125);
        g.drawString("0", 162, 165);
        g.drawString("1", 148, 110);
        g.drawString("1", 108, 110);
        g.drawString("1", 198, 110);
        g.drawString("1", 230, 110);
    }
    
}
