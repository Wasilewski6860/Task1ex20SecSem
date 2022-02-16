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

        JPanel bottomButtonsPanel = new JPanel();
        JPanel topButtonsPanel = new JPanel();
        JPanel rightSideButtonsPanel = new JPanel();
        JPanel leftSideButtonPanel = new JPanel();
        JButton drawButton = new JButton("Draw");
        JButton shareFirstSideNormal = new JButton("Share FirstSide Normal");
        JButton shareSecondSideNormal = new JButton("Share SecondSide Normal");
        JButton shareThirdSideNormal = new JButton("Share ThirdSide Normal");
        JButton shareForthSideNormal = new JButton("Share ForthSide Normal");
        JButton shareFirstPointNormal = new JButton("Share FirstPoint Normal");
        JButton shareSecondPointNormal = new JButton("Share SecondPoint Normal");
        JButton shareThirdPointNormal = new JButton("Share ThirdPoint Normal");
        JButton shareForthPointNormal = new JButton("Share ForthPoint Normal");

        JButton shareFirstSideHorizontal = new JButton("Share FirstSide Horizontal");
        JButton shareSecondSideHorizontal = new JButton("Share SecondSide Horizontal");
        JButton shareThirdSideHorizontal = new JButton("Share ThirdSide Horizontal");
        JButton shareForthSideHorizontal = new JButton("Share ForthSide Horizontal");
        JButton shareFirstPointHorizontal = new JButton("Share FirstPoint Horizontal");
        JButton shareSecondPointHorizontal = new JButton("Share SecondPoint Horizontal");
        JButton shareThirdPointHorizontal = new JButton("Share ThirdPoint Horizontal");
        JButton shareForthPointHorizontal = new JButton("Share ForthPoint Horizontal");

        JButton shareFirstSideVertical = new JButton("Share FirstSide Vertical");
        JButton shareSecondSideVertical = new JButton("Share SecondSide Vertical");
        JButton shareThirdSideVertical = new JButton("Share ThirdSide Vertical");
        JButton shareForthSideVertical = new JButton("Share ForthSide Vertical");
        JButton shareFirstPointVertical = new JButton("Share FirstPoint Vertical");
        JButton shareSecondPointVertical = new JButton("Share SecondPoint Vertical");
        JButton shareThirdPointVertical = new JButton("Share ThirdPoint Vertical");
        JButton shareForthPointVertical = new JButton("Share ForthPoint Vertical");

        JButton shareCenterNormal = new JButton("Share Center Normal");
        JButton shareCenterVertical = new JButton("Share Center Vertical");
        JButton shareCenterHorizontal = new JButton("Share Center Horizontal");
        JButton clearButton = new JButton("Clear");
        JButton circumscribed = new JButton("Circumscribed");
        JTextArea textField = new JTextArea("You Params");

        textField.setVisible(true);
        textField.setBackground(Color.WHITE);
        textField.setSize(100,10);

        topButtonsPanel.add(drawButton);
        topButtonsPanel.add(clearButton);
        topButtonsPanel.add(circumscribed);
        topButtonsPanel.add(textField);
        topButtonsPanel.add(shareCenterNormal);
        topButtonsPanel.add(shareCenterHorizontal);
        topButtonsPanel.add(shareCenterVertical);
        topButtonsPanel.add(shareFirstSideNormal);
        topButtonsPanel.add(shareSecondSideNormal);
        topButtonsPanel.add(shareThirdSideNormal);
        topButtonsPanel.add(shareForthSideNormal);
        topButtonsPanel.add(shareFirstPointNormal);
        topButtonsPanel.add(shareSecondPointNormal);
        topButtonsPanel.add(shareThirdPointNormal);
        topButtonsPanel.add(shareForthPointNormal);

        bottomButtonsPanel.add(shareFirstSideHorizontal);
        bottomButtonsPanel.add(shareSecondSideHorizontal);
        bottomButtonsPanel.add(shareThirdSideHorizontal);
        bottomButtonsPanel.add(shareForthSideHorizontal);
        bottomButtonsPanel.add(shareFirstPointHorizontal);
        bottomButtonsPanel.add(shareSecondPointHorizontal);
        bottomButtonsPanel.add(shareThirdPointHorizontal);
        bottomButtonsPanel.add(shareForthPointHorizontal);

        rightSideButtonsPanel.add(shareFirstSideVertical);
        rightSideButtonsPanel.add(shareSecondSideVertical);
        rightSideButtonsPanel.add(shareThirdSideVertical);
        rightSideButtonsPanel.add(shareForthSideVertical);
        rightSideButtonsPanel.add(shareFirstPointVertical);
        rightSideButtonsPanel.add(shareSecondPointVertical);
        rightSideButtonsPanel.add(shareThirdPointVertical);
        rightSideButtonsPanel.add(shareForthPointVertical);


        testFrame.getContentPane().add(topButtonsPanel, BorderLayout.NORTH);
        testFrame.getContentPane().add(bottomButtonsPanel, BorderLayout.SOUTH);
        testFrame.getContentPane().add(rightSideButtonsPanel, BorderLayout.WEST);

        Rectangle rectangle = new Rectangle(new Point(20,30), new Point(40,10), new Point(80,50), new Point( 60,70));
        //40,0 140,80 100,130 0,50
        //100,100 200,100 200,200 100,200
        //-100,-100 100,-100 100,100 -100,100
        //20,30 40,10 80,50 60,70

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comp.addLine(rectangle.getP1().getX(), rectangle.getP1().getY(), rectangle.getP2().getX(), rectangle.getP2().getY(), Color.BLACK);
                comp.addLine(rectangle.getP2().getX(), rectangle.getP2().getY(), rectangle.getP3().getX(), rectangle.getP3().getY(), Color.BLACK);
                comp.addLine(rectangle.getP3().getX(), rectangle.getP3().getY(), rectangle.getP4().getX(), rectangle.getP4().getY(), Color.BLACK);
                comp.addLine(rectangle.getP4().getX(), rectangle.getP4().getY(), rectangle.getP1().getX(), rectangle.getP1().getY(), Color.BLACK);

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

                comp.addLine(circedRectangle.getP1().getX(), circedRectangle.getP1().getY(), circedRectangle.getP2().getX(), circedRectangle.getP2().getY(), Color.BLACK);
                comp.addLine(circedRectangle.getP2().getX(), circedRectangle.getP2().getY(), circedRectangle.getP3().getX(), circedRectangle.getP3().getY(), Color.BLACK);
                comp.addLine(circedRectangle.getP3().getX(), circedRectangle.getP3().getY(), circedRectangle.getP4().getX(), circedRectangle.getP4().getY(), Color.BLACK);
                comp.addLine(circedRectangle.getP4().getX(), circedRectangle.getP4().getY(), circedRectangle.getP1().getX(), circedRectangle.getP1().getY(), Color.BLACK);
            }
        });

        shareFirstSideNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.NORMAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareSecondSideNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.NORMAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareThirdSideNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.NORMAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareForthSideNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.NORMAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareFirstPointNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.NORMAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareSecondPointNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.NORMAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareThirdPointNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.NORMAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareForthPointNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.NORMAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareFirstSideHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.HORIZONTAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareSecondSideHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.HORIZONTAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareThirdSideHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.HORIZONTAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
            }
        });
        shareForthSideHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.HORIZONTAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareFirstPointHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.HORIZONTAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareSecondPointHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.HORIZONTAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareThirdPointHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.HORIZONTAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareForthPointHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.HORIZONTAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareFirstSideVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.VERTICAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareSecondSideVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.VERTICAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareThirdSideVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.VERTICAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareForthSideVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.VERTICAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareFirstPointVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.VERTICAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareSecondPointVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.VERTICAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareThirdPointVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.VERTICAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });
        shareForthPointVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.VERTICAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
                System.out.println("Shared");

            }
        });

        shareCenterNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.CENTER, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.NORMAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
            }
        });

        shareCenterHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.CENTER, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.HORIZONTAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
            }
        });

        shareCenterVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = Rectangle.moving(rectangle, Rectangle.typeOfHolding.CENTER, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.VERTICAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
            }
        });


        testFrame.pack();
        testFrame.setVisible(true);





    }
}
