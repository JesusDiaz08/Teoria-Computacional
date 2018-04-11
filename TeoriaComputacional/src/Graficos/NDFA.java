package Graficos;
/*@author Diaz Medina Jesus Kaimorts */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;

public class NDFA extends Applet
{
    public void graph(){
        NDFA ndfa = new NDFA();
        JFrame frame = new JFrame();
        frame.add(ndfa);
        frame.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        int x,y,z;
        int alto, ancho;
        
        setSize(600,250);
        setBackground(Color.WHITE);
        g.setColor(Color.GREEN);
        
        Font f = new Font(Font.DIALOG,Font.BOLD,15);
        g.setFont(f);
        x = 200;
        y = 15;
        g.drawString("Nondeterministic Finit Automaton", x, y);
        
        /*--------------------------LINEAS HORIZONTALES (start,i,n,g)--------------------------*/                       
        Graphics2D graph = (Graphics2D)g;
        graph.setColor(Color.BLACK); 
                                         //anchoFromPantalla,alturaFromPantalla,longitud(70-99),alturaFromPantalla(final)
        Line2D L2_i = new Line2D.Double(140,100,230,100);       /*START */
        graph.draw(L2_i);
        Line2D L3_n = new Line2D.Double(270,100,360,100);       /*q0-q1: n*/
        graph.draw(L3_n);
        Line2D L4_g = new Line2D.Double(400,100,490,100);       /*q1-q2: g*/
        graph.draw(L4_g);
        /*-------------------------------------------------------------------------------------*/
        
        /*------------------------------- ESTADOS ----------------------------*/
        Graphics2D graph02 = (Graphics2D)g;
        graph02.setColor(Color.BLACK);
        
        Ellipse2D q0 = new Ellipse2D.Double(230,80,40,40);      //q0
        graph02.draw(q0);
        Ellipse2D q1 = new Ellipse2D.Double(360,80,40,40);      //q1
        graph02.draw(q1);
        Ellipse2D q3 = new Ellipse2D.Double(490, 80, 40, 40);   //q2
        graph02.draw(q3);
        Ellipse2D q3_final = new Ellipse2D.Double(495,85,30,30); //q2 final
        graph02.draw(q3_final);
        Ellipse2D q0_q0 = new Ellipse2D.Double(230,118,20,20);    /*q0_q0 ARCO*/
        graph.draw(q0_q0);
        /*--------------------------------------------------------------------*/
        
         /*----------------------- CONECTORES (Flechas) -----------------------*/        
        Ellipse2D start_fill = new Ellipse2D.Double(222,95,8,8);       /*START*/
        graph.draw(start_fill);
        graph.fill(start_fill);
        Ellipse2D q0_fill = new Ellipse2D.Double(352,95,8,8);       /*q0-q1: 0*/
        graph.draw(q0_fill);
        graph.fill(q0_fill);
        Ellipse2D q1_fill = new Ellipse2D.Double(482,95,8,8);       /*q1-q2: 1*/
        graph.draw(q1_fill);
        graph.fill(q1_fill);
        Ellipse2D q0_c = new Ellipse2D.Double(245,120,6,6);         /*q0-q0*/
        graph.draw(q0_c);                                           
        graph.fill(q0_c);
        /*--------------------------------------------------------------------*/
        
        /*--------------------------- ETIQUETAS ------------------------------*/
        g.drawString("START", 160, 115);
        g.drawString("0", 315, 115);
        g.drawString("1",445,115);
        
        g.drawString("q0", 242, 105);
        g.drawString("q1", 372, 105);
        g.drawString("q2", 502, 105);
        
        g.drawString("1,0", 220, 150);
        /*--------------------------------------------------------------------*/
        
        
        
    }
}
