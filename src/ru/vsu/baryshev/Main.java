package ru.vsu.baryshev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public LinesComponent draw(Rectangle rec){
        this.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
        this.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
        this.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
        this.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
        return this;
    }



    public static void main(String[] args) {

        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final LinesComponent comp = new LinesComponent();
        comp.setPreferredSize(new Dimension(500, 500));
        testFrame.getContentPane().add(comp, BorderLayout.CENTER);

        JPanel leftSideButtonPanel = new JPanel();

        JMenuBar menuBar = new JMenuBar();
        testFrame.setJMenuBar(menuBar);

        JMenu normalShareButtons = new JMenu("Normal Share Buttons");
        menuBar.add(normalShareButtons);
        JMenuItem shareFirstSideNormal = new JMenuItem("Share Upper Side Normal");
        JMenuItem shareSecondSideNormal = new JMenuItem("Share Right Side Normal");
        JMenuItem shareThirdSideNormal = new JMenuItem("Share Down Side Normal");
        JMenuItem shareForthSideNormal = new JMenuItem("Share Right Side Normal");
        JMenuItem shareFirstPointNormal = new JMenuItem("Share Top Left Point Normal");
        JMenuItem shareSecondPointNormal = new JMenuItem("Share Top Right Point Normal");
        JMenuItem shareThirdPointNormal = new JMenuItem("Share Bottom Right Point Normal");
        JMenuItem shareForthPointNormal = new JMenuItem("Share Bottom Left Point Normal");
        JMenuItem shareCenterNormal = new JMenuItem("Share Center Normal");
        normalShareButtons.add(shareFirstSideNormal);
        normalShareButtons.add(shareSecondSideNormal);
        normalShareButtons.add(shareThirdSideNormal);
        normalShareButtons.add(shareForthSideNormal);
        normalShareButtons.add(shareFirstPointNormal);
        normalShareButtons.add(shareSecondPointNormal);
        normalShareButtons.add(shareThirdPointNormal);
        normalShareButtons.add(shareForthPointNormal);
        normalShareButtons.add(shareCenterNormal);

        JMenu verticalShareButton = new JMenu("Vertical Share Buttons");
        menuBar.add(verticalShareButton);
        JMenuItem shareFirstSideVertical = new JMenuItem("Share Upper Side Vertical");
        JMenuItem shareSecondSideVertical = new JMenuItem("Share Right Side Vertical");
        JMenuItem shareThirdSideVertical = new JMenuItem("Share Down Side Vertical");
        JMenuItem shareForthSideVertical = new JMenuItem("Share Right Side Vertical");
        JMenuItem shareFirstPointVertical = new JMenuItem("Share Top Left Point Vertical");
        JMenuItem shareSecondPointVertical = new JMenuItem("Share Top Right Point Vertical");
        JMenuItem shareThirdPointVertical = new JMenuItem("Share Bottom Right Point Vertical");
        JMenuItem shareForthPointVertical = new JMenuItem("Share Bottom Left Point Vertical");
        JMenuItem shareCenterVertical = new JMenuItem("Share Center Vertical");
        verticalShareButton.add(shareFirstSideVertical);
        verticalShareButton.add(shareSecondSideVertical);
        verticalShareButton.add(shareThirdSideVertical);
        verticalShareButton.add(shareForthSideVertical);
        verticalShareButton.add(shareFirstPointVertical);
        verticalShareButton.add(shareSecondPointVertical);
        verticalShareButton.add(shareThirdPointVertical);
        verticalShareButton.add(shareForthPointVertical);
        verticalShareButton.add(shareCenterVertical);


        JMenu horizontalShareButton = new JMenu("Horizontal Share Buttons");
        menuBar.add(horizontalShareButton);
        JMenuItem shareFirstSideHorizontal = new JMenuItem("Share Upper Side Horizontal");
        JMenuItem shareSecondSideHorizontal = new JMenuItem("Share Right Side Horizontal");
        JMenuItem shareThirdSideHorizontal = new JMenuItem("Share Down Side Horizontal");
        JMenuItem shareForthSideHorizontal = new JMenuItem("Share Right Side Horizontal");
        JMenuItem shareFirstPointHorizontal = new JMenuItem("Share Top Left Point Horizontal");
        JMenuItem shareSecondPointHorizontal = new JMenuItem("Share Top Right Point Horizontal");
        JMenuItem shareThirdPointHorizontal = new JMenuItem("Share Bottom Right Point Horizontal");
        JMenuItem shareForthPointHorizontal = new JMenuItem("Share Bottom Left Point Horizontal");
        JMenuItem shareCenterHorizontal = new JMenuItem("Share Center Horizontal");
        horizontalShareButton.add(shareFirstSideHorizontal);
        horizontalShareButton.add(shareSecondSideHorizontal);
        horizontalShareButton.add(shareThirdSideHorizontal);
        horizontalShareButton.add(shareForthSideHorizontal);
        horizontalShareButton.add(shareFirstPointHorizontal);
        horizontalShareButton.add(shareSecondPointHorizontal);
        horizontalShareButton.add(shareThirdPointHorizontal);
        horizontalShareButton.add(shareForthPointHorizontal);
        horizontalShareButton.add(shareCenterHorizontal);

        JMenu mainButtons = new JMenu("Main Buttons");
        menuBar.add(mainButtons);
        JMenuItem drawButton = new JMenuItem("Draw");
        JMenuItem clearButton = new JMenuItem("Clear");
        JMenuItem circumscribed = new JMenuItem("Circumscribed");
        JMenuItem moving = new JMenuItem("Moving");
        mainButtons.add(drawButton);
        mainButtons.add(clearButton);
        mainButtons.add(circumscribed);
        mainButtons.add(moving);

        JTextArea textField = new JTextArea("You Params");

        textField.setVisible(true);
        textField.setBackground(Color.WHITE);
        textField.setSize(100,10);


        leftSideButtonPanel.add(textField);

        testFrame.getContentPane().add(leftSideButtonPanel,BorderLayout.WEST);

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

                textField.setText("S= " + rectangle.searchOfS()+ "P= " + rectangle.searchForP());

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comp.clearLines();
            }
        });

        moving.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] params = textField.getText().split(";");
                int dx=Integer.parseInt(params[0]);
                int dy = Integer.parseInt(params[1]);
                rectangle.moving(dx,dy);
                comp.addLine(rectangle.getP1().getX(), rectangle.getP1().getY(), rectangle.getP2().getX(), rectangle.getP2().getY(), Color.BLACK);
                comp.addLine(rectangle.getP2().getX(), rectangle.getP2().getY(), rectangle.getP3().getX(), rectangle.getP3().getY(), Color.BLACK);
                comp.addLine(rectangle.getP3().getX(), rectangle.getP3().getY(), rectangle.getP4().getX(), rectangle.getP4().getY(), Color.BLACK);
                comp.addLine(rectangle.getP4().getX(), rectangle.getP4().getY(), rectangle.getP1().getX(), rectangle.getP1().getY(), Color.BLACK);

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

                Rectangle rec = rectangle.sharing( Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.NORMAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareSecondSideNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = rectangle.sharing( Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.NORMAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareThirdSideNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = rectangle.sharing( Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.NORMAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareForthSideNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.NORMAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.NORMAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.NORMAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.NORMAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.NORMAL,2);
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

                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.HORIZONTAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareSecondSideHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.HORIZONTAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareThirdSideHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.HORIZONTAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
            }
        });
        shareForthSideHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.HORIZONTAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.HORIZONTAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.HORIZONTAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.HORIZONTAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.HORIZONTAL,2);
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

                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.VERTICAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareSecondSideVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.VERTICAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareThirdSideVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.VERTICAL,2);

                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);

            }
        });
        shareForthSideVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.SIDE, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.VERTICAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FIRST, Rectangle.typeOfShape.VERTICAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.SECOND, Rectangle.typeOfShape.VERTICAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.THIRD, Rectangle.typeOfShape.VERTICAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.POINT, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.VERTICAL,2);
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
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.CENTER, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.NORMAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
            }
        });

        shareCenterHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.CENTER, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.HORIZONTAL,2);
                comp.addLine(rec.getP1().getX(), rec.getP1().getY(), rec.getP2().getX(), rec.getP2().getY(), Color.BLACK);
                comp.addLine(rec.getP2().getX(), rec.getP2().getY(), rec.getP3().getX(), rec.getP3().getY(), Color.BLACK);
                comp.addLine(rec.getP3().getX(), rec.getP3().getY(), rec.getP4().getX(), rec.getP4().getY(), Color.BLACK);
                comp.addLine(rec.getP4().getX(), rec.getP4().getY(), rec.getP1().getX(), rec.getP1().getY(), Color.BLACK);
            }
        });

        shareCenterVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rec = rectangle.sharing(  Rectangle.typeOfHolding.CENTER, Rectangle.numberOFSelected.FORTH, Rectangle.typeOfShape.VERTICAL,2);
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

