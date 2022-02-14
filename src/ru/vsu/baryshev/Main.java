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
        comp.setPreferredSize(new Dimension(500, 500));
        testFrame.getContentPane().add(comp, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        JButton drawButton = new JButton("Draw");
        JButton shareFirstSide = new JButton("Share FirstSide");
        JButton shareSecondSide = new JButton("Share SecondSide");
        JButton shareThirdSide = new JButton("Share ThirdSide");
        JButton shareForthSide = new JButton("Share ForthSide");
        JButton shareFirstPoint = new JButton("Share FirstPoint");
        JButton shareSecondPoint = new JButton("Share SecondPoint");
        JButton shareThirdPoint = new JButton("Share ThirdPoint");
        JButton shareForthPoint = new JButton("Share ForthPoint");
        JButton shareCenter = new JButton("Share Center");
        JButton clearButton = new JButton("Clear");
        JButton circumscribed = new JButton("Circumscribed");
        JTextArea textField = new JTextArea("You Params");

        textField.setVisible(true);
        textField.setBackground(Color.WHITE);
        textField.setSize(100,10);

        buttonsPanel.add(drawButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(circumscribed);
        buttonsPanel.add(textField);
        buttonsPanel.add(shareCenter);
        buttonsPanel.add(shareFirstSide);
        buttonsPanel.add(shareSecondSide);
        buttonsPanel.add(shareThirdSide);
        buttonsPanel.add(shareForthSide);
        buttonsPanel.add(shareFirstPoint);
        buttonsPanel.add(shareSecondPoint);
        buttonsPanel.add(shareThirdPoint);
        buttonsPanel.add(shareForthPoint);

        testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        Rectangle rectangle = new Rectangle(new Rectangle.Point(100,100), new Rectangle.Point(200,100), new Rectangle.Point(200,200), new Rectangle.Point( 100,200));
        //40,0 140,80 100,130 0,50
        //100,100 200,100 200,200 100,200
        //-100,-100 100,-100 100,100 -100,100
        //20,30 40,10 80,50 60,70

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comp.addLine(rectangle.p1.x, rectangle.p1.y, rectangle.p2.x, rectangle.p2.y, Color.BLACK);
                comp.addLine(rectangle.p2.x, rectangle.p2.y, rectangle.p3.x, rectangle.p3.y, Color.BLACK);
                comp.addLine(rectangle.p3.x, rectangle.p3.y, rectangle.p4.x, rectangle.p4.y, Color.BLACK);
                comp.addLine(rectangle.p4.x, rectangle.p4.y, rectangle.p1.x, rectangle.p1.y, Color.BLACK);

                textField.setText("S= " + Rectangle.searchOfS(rectangle)+ "P= " + Rectangle.searchForP(rectangle));

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

                Rectangle circedRectangle = Rectangle.createACircumscribedRectangle(rectangle);

                comp.addLine(circedRectangle.p1.x, circedRectangle.p1.y, circedRectangle.p2.x, circedRectangle.p2.y, Color.BLACK);
                comp.addLine(circedRectangle.p2.x, circedRectangle.p2.y, circedRectangle.p3.x, circedRectangle.p3.y, Color.BLACK);
                comp.addLine(circedRectangle.p3.x, circedRectangle.p3.y, circedRectangle.p4.x, circedRectangle.p4.y, Color.BLACK);
                comp.addLine(circedRectangle.p4.x, circedRectangle.p4.y, circedRectangle.p1.x, circedRectangle.p1.y, Color.BLACK);
            }
        });

        shareFirstSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST,2);

                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);

            }
        });
        shareSecondSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.SECOND,2);

                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);

            }
        });
        shareThirdSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.THIRD,2);

                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);

            }
        });
        shareForthSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FORTH,2);
                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareFirstPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FIRST,2);
                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareSecondPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.SECOND,2);
                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareThirdPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.THIRD,2);
                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareForthPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FORTH,2);
                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.CENTER, Rectangle.numberOFSelected.FORTH,2);
                comp.addLine(rec.p1.x, rec.p1.y, rec.p2.x, rec.p2.y, Color.BLACK);
                comp.addLine(rec.p2.x, rec.p2.y, rec.p3.x, rec.p3.y, Color.BLACK);
                comp.addLine(rec.p3.x, rec.p3.y, rec.p4.x, rec.p4.y, Color.BLACK);
                comp.addLine(rec.p4.x, rec.p4.y, rec.p1.x, rec.p1.y, Color.BLACK);
            }
        });


        testFrame.pack();
        testFrame.setVisible(true);





    }
}
