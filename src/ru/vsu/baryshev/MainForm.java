package ru.vsu.baryshev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JTextArea textArea1;
    private JButton Params;
    private JButton circumscribingRectangle;
    private JButton drawButton;
    private JPanel panelForDrawing;

    public MainForm(){
        this.setTitle("Table");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] coordinates = textArea1.getText().split(";");
                Rectangle.Point p1 = new Rectangle.Point(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
                Rectangle.Point p2 = new Rectangle.Point(Integer.parseInt(coordinates[2]),Integer.parseInt(coordinates[3]));
                Rectangle.Point p3 = new Rectangle.Point(Integer.parseInt(coordinates[4]),Integer.parseInt(coordinates[5]));
                Rectangle.Point p4 = new Rectangle.Point(Integer.parseInt(coordinates[6]),Integer.parseInt(coordinates[7]));
                Rectangle rec = new Rectangle(p1,p2,p3,p4);

                Runnable r = new Runnable() {
                    public void run() {
                        ru.vsu.baryshev.LineComponent lineComponent = new ru.vsu.baryshev.LineComponent(400,400);

                        lineComponent.addLine(rec.p1.x,rec.p1.y,rec.p2.x,rec.p2.y);
                        lineComponent.addLine(rec.p2.x,rec.p2.y,rec.p3.x,rec.p3.y);
                        lineComponent.addLine(rec.p3.x,rec.p3.y,rec.p4.x,rec.p4.y);
                        lineComponent.addLine(rec.p4.x,rec.p4.y,rec.p1.x,rec.p1.y);


                    }
                };
                SwingUtilities.invokeLater(r);

            }
        });
    }

}
