package ru.vsu.baryshev;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class DrawLines {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Runnable r = new Runnable() {
            public void run() {
                LineComponent lineComponent = new LineComponent(400,400);
                for (int ii=0; ii<4; ii++) {
                    int x1=0;
                    System.out.println("x1");
                    x1 = in.nextInt();
                    int y1=0;
                    System.out.println("y1");
                    y1 = in.nextInt();
                    int x2=0;
                    System.out.println("x2");
                    x2 = in.nextInt();
                    int y2=0;
                    System.out.println("y2");
                    y2 = in.nextInt();
                    lineComponent.addLine(x1,y1,x2,y2);
                }
                JOptionPane.showMessageDialog(null, lineComponent);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class LineComponent extends JComponent {

    ArrayList<Line2D.Double> lines;
    Random random;

    LineComponent(int width, int height) {
        //  super();
            setPreferredSize(new Dimension(width,height));
        lines = new ArrayList<Line2D.Double>();
        random = new Random();
    }

    public void addLine(int x1,int y1,int x2,int y2) {
//        int width = (int)getPreferredSize().getWidth();
//        int height = (int)getPreferredSize().getHeight();
        Line2D.Double line = new Line2D.Double(
                x1
                ,
                y1
                ,
                x2
                ,
                y2
        )
                ;
        lines.add(line);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight()); //
        //    Dimension d = getPreferredSize();
        g.setColor(Color.black);
        for (Line2D.Double line : lines) {
            g.drawLine(
                    (int)line.getX1(),
                    (int)line.getY1(),
                    (int)line.getX2(),
                    (int)line.getY2()
            );
        }

    }
}
