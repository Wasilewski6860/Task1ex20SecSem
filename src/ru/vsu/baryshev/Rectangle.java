package ru.vsu.baryshev;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.css.Rect;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

 class Rectangle {

    static final class Point {
        protected int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point point) {
            this.x = point.x;
            this.y = point.y;
        }

    }
    enum typeOfHolding{
        POINT,
        SIDE
    }
    enum numberOFSelected{
        FIRST,
        SECOND,
        THIRD,
        FORTH
    }

    public Point p1;
    public Point p2;
    public Point p3;
    public Point p4;

    public Rectangle(Point p1,Point p2,Point p3,Point p4){

        if(( (p2.x-p1.x)*(p3.x- p2.x) + (p2.y-p1.y)*(p3.y- p2.y) == 0) &&( (p3.x-p2.x)*(p4.x- p3.x) + (p3.y-p2.y)*(p4.y- p3.y) == 0) &&( (p4.x-p3.x)*(p1.x- p4.x) + (p4.y-p3.y)*(p1.y- p4.y) == 0)  ) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        } else {
            this.p1 = null;
            this.p2 = null;
            this.p3 = null;
            this.p4 = null;
            System.out.println("Не прямоугольник");
        }
    }



    public static double searchOfS(Rectangle rec){

        double m = 0.5*(rec.p1.x*rec.p2.y + rec.p2.x*rec.p3.y + rec.p3.x*rec.p4.y + rec.p4.x*rec.p1.y - rec.p2.x*rec.p1.y - rec.p3.x*rec.p2.y- rec.p4.x*rec.p3.y- rec.p1.x*rec.p4.y);
        if (m>=0){
            return m;
        }else return -1*m;
    }

    public static double searchForP(Rectangle rec){
        return distanceBetweenPoints(rec.p1, rec.p2) + distanceBetweenPoints(rec.p2, rec.p3)+ distanceBetweenPoints(rec.p3, rec.p4) + distanceBetweenPoints(rec.p4, rec.p1);
    }

    public static double distanceBetweenPoints(Point p1, Point p2){
        return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
    }

    public static Point[] sortClockwise(Rectangle rec){

        Point p1 = rec.p1;
        Point p2 = rec.p2;
        Point p3 = rec.p3;
        Point p4 = rec.p4;
        List<Point> startList= new ArrayList<>();
        Point[] answer = new Point[4];
        startList.add(p1);
        startList.add(p2);
        startList.add(p3);
        startList.add(p4);
        double maxY=0;
        double minY = 400;
        double maxX = 0;
        double minX = 400;

        for (Point point : startList){
            if (maxY<=point.y) maxY=point.y;
            if (minY>=point.y) minY=point.y;
            if (maxX<=point.x) maxX=point.x;
            if (minX>=point.x) minX=point.x;
        }
        System.out.println("maxX = "+ maxX);
        System.out.println("minX = "+ minX);
        System.out.println("maxY = "+ maxY);
        System.out.println("minY = "+ minY);

        for (Point point : startList){
            if (point.x==minX && ((point.y-minY)<=(maxY-point.y))) answer[0] = point;
            if (point.y==minY) answer[1] = point;
            if (point.x==maxX) answer[2] = point;
            if (point.y==maxY) answer[3] = point;
        }
        return answer;

    }

//    public static Rectangle newCircumscribedRectangle(Rectangle startRectangle){
//        Point[] arrayOfSortedPoints = sortClockwise(startRectangle);
//
//    }
    public static Rectangle createACircumscribedRectangle(Rectangle startRectangle){

        Point[] arrayOfSortedPoints = sortClockwise(startRectangle);

        System.out.println("Start of Params of firstRect "+startRectangle.p1.x+" "+startRectangle.p1.y);
        System.out.println(startRectangle.p2.x+" "+startRectangle.p2.y);
        System.out.println(startRectangle.p3.x+" "+startRectangle.p3.y);
        System.out.println(startRectangle.p4.x+" "+startRectangle.p4.y+" final ");

        if (startRectangle.p1.y != startRectangle.p2.y && startRectangle.p1.x != startRectangle.p2.x ) {

            System.out.println(" X0= "+arrayOfSortedPoints[0].x+" Y0 ="+arrayOfSortedPoints[0].y + " X1= "+arrayOfSortedPoints[1].x+ " Y1= "+arrayOfSortedPoints[1].y  +
                    " X2= "+arrayOfSortedPoints[2].x+"Y2 = "+arrayOfSortedPoints[2].y+" X3= "+ arrayOfSortedPoints[3].x+" Y3= "+arrayOfSortedPoints[3].y);

            Point p1 = new Point(arrayOfSortedPoints[0].x, arrayOfSortedPoints[1].y);
            Point p2 = new Point(arrayOfSortedPoints[2].x, arrayOfSortedPoints[1].y);
            Point p3 = new Point(arrayOfSortedPoints[2].x, arrayOfSortedPoints[3].y);
            Point p4 = new Point(arrayOfSortedPoints[0].x, arrayOfSortedPoints[3].y);
            System.out.println("Первый вариант");
            return new Rectangle(p1, p2, p3, p4);
        }else {
            Point p1 = new Point((arrayOfSortedPoints[0].x-(arrayOfSortedPoints[3].y-arrayOfSortedPoints[0].y)/2),(arrayOfSortedPoints[3].y-arrayOfSortedPoints[0].y)/2 + arrayOfSortedPoints[0].y);
            Point p2 = new Point((arrayOfSortedPoints[1].x-arrayOfSortedPoints[0].x)/2 + arrayOfSortedPoints[0].x,arrayOfSortedPoints[1].y-(arrayOfSortedPoints[1].x-arrayOfSortedPoints[0].x)/2);
            Point p3  = new Point(arrayOfSortedPoints[1].x+(arrayOfSortedPoints[2].y-arrayOfSortedPoints[1].y)/2,(arrayOfSortedPoints[2].y-arrayOfSortedPoints[1].y)/2 + arrayOfSortedPoints[1].y);
            Point p4 = new Point((arrayOfSortedPoints[1].x-arrayOfSortedPoints[0].x)/2 + arrayOfSortedPoints[0].x,arrayOfSortedPoints[2].y + (arrayOfSortedPoints[2].y-arrayOfSortedPoints[1].y)/2);
            System.out.println("Второй");

            System.out.println("Sorted points:  X0= "+arrayOfSortedPoints[0].x+" Y0 ="+arrayOfSortedPoints[0].y + " X1= "+arrayOfSortedPoints[1].x+ " Y1= "+arrayOfSortedPoints[1].y  +
                    " X2= "+arrayOfSortedPoints[2].x+"Y2 = "+arrayOfSortedPoints[2].y+" X3= "+ arrayOfSortedPoints[3].x+" Y3= "+arrayOfSortedPoints[3].y);
            System.out.println("Points Of new Rectangle X0= "+p1.x+" Y0 ="+p1.y + " X1= "+p2.x+ " Y1= "+p2.y  +
                    " X2= "+p3.x+"Y2 = "+p3.y+" X3= "+ p4.x+" Y3= "+p4.y);
            return new Rectangle(p1, p2, p3, p4);
        }

    }


    public static Rectangle moving(Rectangle startRectangle,typeOfHolding type,numberOFSelected number, int k){
        Point[] points = sortClockwise(startRectangle);
        Rectangle rec = null;

        switch (type){

            case SIDE:{

                switch (number){

                    case FIRST:{
                        Point p1 = new Point((points[0].x+(k-1)*(points[0].x-points[1].x)/2),(points[0].y+(k-1)*(points[0].y-points[1].y)/2));
                        Point p2=new Point((points[1].x + (points[1].x-points[0].x)/2*(k-1)),(points[1].y + (k-1)*(points[1].y-points[0].y)/2));
                        Point p3 = new Point((points[2].x+(k-1)*(points[2].x-points[1].x + (points[1].x-points[0].x)/2)),(points[2].y+(k-1)*(points[2].y-points[1].y +(points[1].y-points[0].y)/2 )));
                        Point p4 = new Point((points[3].x+(k-1)*(points[3].x-points[0].x + (points[0].x-points[1].x)/2)),(points[3].y+(k-1)*(points[3].y-points[0].y+(points[0].y-points[1].y)/2)));

                        System.out.println("Start of Params of firstRect "+p1.x+" "+p1.y);
                        System.out.println(p2.x+" "+p2.y);
                        System.out.println(p3.x+" "+p3.y);
                        System.out.println(p4.x+" "+p4.y+" final ");
                        startRectangle = new Rectangle(p1,p2,p3,p4);



                    }
                    case SECOND:{
//                        Point p1 = new Point();
//                        Point p2=new Point();
//                        Point p3 = new Point();
//                        Point p4 = new Point();
//
//                        System.out.println("Start of Params of firstRect "+p1.x+" "+p1.y);
//                        System.out.println(p2.x+" "+p2.y);
//                        System.out.println(p3.x+" "+p3.y);
//                        System.out.println(p4.x+" "+p4.y+" final ");
//                        startRectangle = new Rectangle(p1,p2,p3,p4);
                    }
                    case THIRD:{

                    }
                    case FORTH:{

                    }
                }

            } case POINT:{
                switch (number){
                    case FIRST:{

                    }case SECOND:{

                    }case THIRD:{

                    }case FORTH:{

                    }
                }

            }
        }
    return startRectangle;
    }

}
