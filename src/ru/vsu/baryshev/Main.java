package ru.vsu.baryshev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final LinesComponent comp = new LinesComponent();
        comp.setPreferredSize(new Dimension(400, 400));
        testFrame.getContentPane().add(comp, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JButton drawButton = new JButton("Draw");
        JButton ShareButton = new JButton("Share");
        JButton clearButton = new JButton("Clear");
        JButton circumscribed = new JButton("Circumscribed");
        JTextArea textField = new JTextArea("You Params");
        textField.setVisible(true);
        textField.setBackground(Color.WHITE);
        textField.setSize(100,10);
        buttonsPanel.add(drawButton);
        buttonsPanel.add(ShareButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(circumscribed);
        buttonsPanel.add(textField);
        testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        testFrame.getContentPane().add(buttonsPanel, BorderLayout.NORTH);

        final Rectangle[] rectangle = {new Rectangle(new Rectangle.Point(20, 30), new Rectangle.Point(40, 10), new Rectangle.Point(80, 50), new Rectangle.Point(60, 70))};
        //40,0 140,80 100,130 0,50
        //100,100 200,100 200,200 100,200
        //-100,-100 100,-100 100,100 -100,100
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String[] coordinates = textField.getText().split(";");
//                Rectangle.Point p1 = new Rectangle.Point(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
//                Rectangle.Point p2 = new Rectangle.Point(Integer.parseInt(coordinates[2]),Integer.parseInt(coordinates[3]));
//                Rectangle.Point p3 = new Rectangle.Point(Integer.parseInt(coordinates[4]),Integer.parseInt(coordinates[5]));
//                Rectangle.Point p4 = new Rectangle.Point(Integer.parseInt(coordinates[6]),Integer.parseInt(coordinates[7]));
//                Rectangle rec = new Rectangle(p1,p2,p3,p4);

                comp.addLine(rectangle[0].p1.x, rectangle[0].p1.y, rectangle[0].p2.x, rectangle[0].p2.y, Color.BLACK);
                comp.addLine(rectangle[0].p2.x, rectangle[0].p2.y, rectangle[0].p3.x, rectangle[0].p3.y, Color.BLACK);
                comp.addLine(rectangle[0].p3.x, rectangle[0].p3.y, rectangle[0].p4.x, rectangle[0].p4.y, Color.BLACK);
                comp.addLine(rectangle[0].p4.x, rectangle[0].p4.y, rectangle[0].p1.x, rectangle[0].p1.y, Color.BLACK);

                textField.setText("S= " + Rectangle.searchOfS(rectangle[0])+ "P= " + Rectangle.searchForP(rectangle[0]));


//                comp.addLine(p1.x, p1.y, p2.x, p2.y, Color.BLACK);
//                comp.addLine(p2.x, p2.y, p3.x, p3.y, Color.BLACK);
//                comp.addLine(p3.x, p3.y, p4.x, p4.y, Color.BLACK);
//                comp.addLine(p4.x, p4.y, p1.x, p1.y, Color.BLACK);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comp.clearLines();
            }
        });

        circumscribed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle circedRectangle = Rectangle.createACircumscribedRectangle(rectangle[0]);
                comp.addLine(circedRectangle.p1.x, circedRectangle.p1.y, circedRectangle.p2.x, circedRectangle.p2.y, Color.BLACK);
                comp.addLine(circedRectangle.p2.x, circedRectangle.p2.y, circedRectangle.p3.x, circedRectangle.p3.y, Color.BLACK);
                comp.addLine(circedRectangle.p3.x, circedRectangle.p3.y, circedRectangle.p4.x, circedRectangle.p4.y, Color.BLACK);
                comp.addLine(circedRectangle.p4.x, circedRectangle.p4.y, circedRectangle.p1.x, circedRectangle.p1.y, Color.BLACK);
            }
        });

        ShareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               rectangle[0] = Rectangle.moving(rectangle[0], Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST,2);
                comp.addLine(rectangle[0].p1.x, rectangle[0].p1.y, rectangle[0].p2.x, rectangle[0].p2.y, Color.BLACK);
                comp.addLine(rectangle[0].p2.x, rectangle[0].p2.y, rectangle[0].p3.x, rectangle[0].p3.y, Color.BLACK);
                comp.addLine(rectangle[0].p3.x, rectangle[0].p3.y, rectangle[0].p4.x, rectangle[0].p4.y, Color.BLACK);
                comp.addLine(rectangle[0].p4.x, rectangle[0].p4.y, rectangle[0].p1.x, rectangle[0].p1.y, Color.BLACK);
                System.out.println("Shared");

            }
        });

        testFrame.pack();
        testFrame.setVisible(true);


        System.out.println("S= " + Rectangle.searchOfS(rectangle[0]));
        System.out.println("P= " + Rectangle.searchForP(rectangle[0]));




    }
}
