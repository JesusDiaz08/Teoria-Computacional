package Graficos;
/*@author Díaz Medina Jesús Kaimorts*/
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;

public class Web_Ebay extends Applet //Grafico
{
    
    public void graph(){
        Web_Ebay web_ebay = new Web_Ebay();
        JFrame frame = new JFrame();
        frame.add(web_ebay);
        frame.setVisible(true);
    }
    
    public void init() {
        this.setSize(600, 350);
    }

    public void paint(Graphics g) {
        int x, y;
        setBackground(Color.ORANGE);
        g.setColor(Color.BLACK);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        g.setFont(f);
        x = 240;
        y = 15;
        g.drawString("AUTOMATA WEB - EBAY", x, y);
        
        /*COLOR DE LAS LINEAS, CONECTORES Y LETRAS*/
        Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Color.BLACK);
        
        /*----------------------------------------*/
        
        /*------------------ CONECTORES ---------------------*/
        Ellipse2D cirp1 = new Ellipse2D.Double(44, 184, 6, 6); //Start conector
        g1.fill(cirp1);
        g1.draw(cirp1);
        
        Line2D l1 = new Line2D.Double(13, 197, 49, 187); //Start
        g1.draw(l1);
        
        Line2D l2 = new Line2D.Double(110, 187, 180, 117); //q0-q1:w
        g1.draw(l2);
        
        Line2D l3 = new Line2D.Double(230, 115, 300, 115); //q1-q2:e
        g1.draw(l3);
        
        Line2D l4 = new Line2D.Double(300, 115, 450, 115);  //q2-q3: b
        g1.draw(l4);
        
        Ellipse2D cirp2 = new Ellipse2D.Double(167, 124, 6, 6); //q0-q1:conector
        g1.fill(cirp2);
        g1.draw(cirp2);
        
        Ellipse2D cirp3 = new Ellipse2D.Double(294, 112, 6, 6); //q1-q2:e conector
        g1.fill(cirp3);
        g1.draw(cirp3);
        
        Ellipse2D cirp4 = new Ellipse2D.Double(425, 112, 6, 6); //q2-q3: b conector
        g1.fill(cirp4);
        g1.draw(cirp4);
        
        Line2D l5 = new Line2D.Double(110, 187, 150, 240);
        g1.draw(l5);
        
        Ellipse2D cirp5 = new Ellipse2D.Double(146, 237, 6, 6);
        g1.fill(cirp5);
        g1.draw(cirp5);
        
        Line2D l6 = new Line2D.Double(180, 250, 500, 250);
        g1.draw(l6);
        
        Ellipse2D cirp6 = new Ellipse2D.Double(254, 247, 6, 6);
        g1.fill(cirp6);
        g1.draw(cirp6);
        
        Ellipse2D cirp7 = new Ellipse2D.Double(364, 247, 6, 6);
        g1.fill(cirp7);
        g1.draw(cirp7);
        
        Ellipse2D cirp8 = new Ellipse2D.Double(474, 247, 6, 6);
        g1.fill(cirp8);
        g1.draw(cirp8);
        
        Ellipse2D cirp9 = new Ellipse2D.Double(46, 173, 6, 6);
        g1.fill(cirp9);
        g1.draw(cirp9);
        
        Ellipse2D cir = new Ellipse2D.Double(188, 81, 6, 6);        //w:q1
        g1.fill(cir);
        g1.draw(cir);
        Ellipse2D cir1 = new Ellipse2D.Double(173, 214, 6, 6);      //e:q4
        g1.fill(cir1);
        g1.draw(cir1);
        Ellipse2D cir2 = new Ellipse2D.Double(215, 139, 6, 6);     //q2-q1:w
        g1.fill(cir2);
        g1.draw(cir2);
        Ellipse2D cir3 = new Ellipse2D.Double(184, 279, 6, 6);     //q5-q4:e
        g1.fill(cir3);
        g1.draw(cir3);
        Ellipse2D cir4 = new Ellipse2D.Double(113, 186, 6, 6);    //q1-q0:E-e-w
        g1.fill(cir4);
        g1.draw(cir4);
        Ellipse2D cir5 = new Ellipse2D.Double(53, 203, 6, 6);   //q4-q0:E-e-b
        g1.fill(cir5);
        g1.draw(cir5);
        Ellipse2D cir6 = new Ellipse2D.Double(406, 216, 6, 6);      //q3-q6:a
        g1.fill(cir6);
        g1.draw(cir6);
        Ellipse2D cir7 = new Ellipse2D.Double(205, 232, 6, 6);   //q2-q4:e
        g1.fill(cir7);
        g1.draw(cir7);
        /*----------------------------------------------------*/
        
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 10);
        g.setFont(f1);
        
        /*------------------------------ ARCOS ------------------------------*/
        Arc2D arc0 = new Arc2D.Double(45, 149, 30, 30, 200, 360, 0); //E-w-r: q0
        g1.draw(arc0);
        
        Arc2D arc1 = new Arc2D.Double(190, 70, 30, 30, 200, 360, 0);   //w: q1
        g1.draw(arc1);
        
        Arc2D arc2 = new Arc2D.Double(175, 205, 30, 30, 200, 360, 0);  //e:q4
        g1.draw(arc2);
        
        Arc2D arc3 = new Arc2D.Double(210, 120, 110, 30, 180, 180, 0); //q2-q1:w
        g1.draw(arc3);
        
        Arc2D arc4 = new Arc2D.Double(180, 260, 110, 30, 180, 180, 0); //q5-q4:e
        g1.draw(arc4);
        
        Arc2D arc5 = new Arc2D.Double(72, 117, 140, 75, 200, 215, 0); //q1-q0:E-e-w
        g1.draw(arc5);
        
        Arc2D arc6 = new Arc2D.Double(52, 180, 140, 75, 160, 180, 0); //q4-q0:E-e-b
        g1.draw(arc6);
        
        Arc2D arc7 = new Arc2D.Double(210, 109, 230, 50, 180, 180, 0); //q3-q1:b
        g1.draw(arc7);
        
        Line2D l7 = new Line2D.Double(410, 219, 482, 100);          //q3-q6:a
        g1.draw(l7);
        
        Arc2D arc8 = new Arc2D.Double(50, 50, 450, 230, 20, 180, 0);  //q3-q0:E-a-w
        g1.draw(arc8);
        
        Line2D l8 = new Line2D.Double(350, 120, 165, 270);        //q2-q4:e
        g1.draw(l8);
        
        Line2D l9 = new Line2D.Double(190, 132, 503, 240);       //q7-q1:w
        g1.draw(l9);
        
        Arc2D arc9 = new Arc2D.Double(160, 178, 350, 140, 0, 180, 0);  //q7-q4:e
        g1.draw(arc9);
        
        Arc2D ar = new Arc2D.Double(44, 156, 360, 163, 160, 190, 0); //q6-q0:E-e
        g1.draw(ar);
        
        Arc2D ar0 = new Arc2D.Double(44, 146, 450, 183, 170, 190, 0); //q7-q0:E-e-w
        g1.draw(ar0);
        
        Arc2D ar1 = new Arc2D.Double(186, 246, 210, 70, 175, 190, 0); //q6-q4:e
        g1.draw(ar1);
        /*-------------------------------------------------------------------*/
        /*---------------------ETIQUETAS--------------------*/
        g1.drawString("Start",10,210);
        g1.drawString("w", 132, 153);
        g1.drawString("e", 260, 112);
        g1.drawString("b", 390, 112);
        g1.drawString("e", 125, 222);
        g1.drawString("b", 233, 261);
        g1.drawString("a", 340, 261);
        g1.drawString("y", 450, 261);
        g1.drawString("Not w,r", 59, 147);
        g1.drawString("e", 187, 202);
        g1.drawString("w", 202, 67);
        g1.drawString("w", 260, 145);
        g1.drawString("e", 233, 300);
        g1.drawString("Not e,w", 168, 173);
        g1.drawString("Not e,b", 90, 265);
        g1.drawString("Not a,w", 400, 65);
        g1.drawString("Not e,w", 400, 322);
        g1.drawString("a", 446, 173);
        g1.drawString("w", 454, 219);
        g1.drawString("e", 454, 193);
        g1.drawString("b", 360, 150);
        g1.drawString("e", 390, 302);
        g1.drawString("Not e", 340, 290);
        /*--------------------------------------------------*/
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        /*----------------------ESTADOS---------------------*/
        Ellipse2D cuar = new Ellipse2D.Double(50, 155, 60, 60);
        g2.draw(cuar);
        g2.fill(cuar);
        Ellipse2D cuar1 = new Ellipse2D.Double(170, 85, 60, 60);
        g2.draw(cuar1);
        g2.fill(cuar1);
        Ellipse2D cuar2 = new Ellipse2D.Double(300, 85, 60, 60);
        g2.draw(cuar2);
        g2.fill(cuar2);
        Ellipse2D cuar3 = new Ellipse2D.Double(430, 85, 60, 60);
        g2.draw(cuar3);
        g2.fill(cuar3);
        Ellipse2D cuar4 = new Ellipse2D.Double(150, 220, 60, 60);
        g2.draw(cuar4);
        g2.fill(cuar4);
        Ellipse2D cuar5 = new Ellipse2D.Double(260, 220, 60, 60);
        g2.draw(cuar5);
        g2.fill(cuar5);
        Ellipse2D cuar6 = new Ellipse2D.Double(370, 220, 60, 60);
        g2.draw(cuar6);
        g2.fill(cuar6);
        Ellipse2D cuar7 = new Ellipse2D.Double(480, 220, 60, 60);
        g2.draw(cuar7);
        g2.fill(cuar7);
        g2.setColor(Color.BLACK);
        Ellipse2D rr4 = new Ellipse2D.Double(487, 228, 45, 45);
        g2.draw(rr4);
        Ellipse2D rr5 = new Ellipse2D.Double(438, 92, 45, 45);
        g2.draw(rr5);
        
        Font h = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        g.setFont(h);
        /*--------------------------------------------------*/
        
        /*------------ETIQUETAS ESTADOS-------------*/
        g.drawString("q0", 70, 190);
        g.drawString("q1", 190, 120);
        g.drawString("q2", 320, 120);
        g.drawString("q3", 450, 120);
        g.drawString("q4", 170, 255);
        g.drawString("q5", 280, 255);
        g.drawString("q6", 390, 255);
        g.drawString("q7", 500, 255);
        /*------------------------------------------*/
    }
}
