package ru.vsu.baryshev;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(new Rectangle.Point(0,20),new Rectangle.Point(40,0),new Rectangle.Point(80,70),new Rectangle.Point(40,90));
	Rectangle.drawing(rectangle);
        System.out.println("S= " + Rectangle.searchOfS(rectangle));
        System.out.println("P= " + Rectangle.searchForP(rectangle));

        Rectangle circedRectangle = Rectangle.createACircumscribedRectangle(rectangle);
        Rectangle.drawing(circedRectangle);


    }
}
