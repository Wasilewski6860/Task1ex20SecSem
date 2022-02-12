package ru.vsu.baryshev;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rectangle {

    static final class Point {
        public int x;
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



    public Point p1;
    public Point p2;
    public Point p3;
    public Point p4;

    public Rectangle(Point p1,Point p2,Point p3,Point p4){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.p4=p4;
    }


    public static void drawing(Rectangle rec){
        Runnable r = new Runnable() {
            public void run() {
                ru.vsu.baryshev.LineComponent lineComponent = new ru.vsu.baryshev.LineComponent(400,400);

                    lineComponent.addLine(rec.p1.x,rec.p1.y,rec.p2.x,rec.p2.y);
                    lineComponent.addLine(rec.p2.x,rec.p2.y,rec.p3.x,rec.p3.y);
                    lineComponent.addLine(rec.p3.x,rec.p3.y,rec.p4.x,rec.p4.y);
                    lineComponent.addLine(rec.p4.x,rec.p4.y,rec.p1.x,rec.p1.y);

                JOptionPane.showMessageDialog(null, lineComponent);
            }
        };
        SwingUtilities.invokeLater(r);
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
        int maxY=0;
        int minY = 400;
        int maxX = 0;
        int minX = 400;

        for (Point point : startList){
            if (maxY<=point.y) maxY=point.y;
            if (minY>=point.y) minY=point.y;
            if (maxX<=point.x) maxX=point.x;
            if (minX>=point.x) minX=point.x;
        }

        for (Point point : startList){
            if (point.x==minX) answer[0] = point;
            if (point.y==minY) answer[1] = point;
            if (point.x==maxX) answer[2] = point;
            if (point.y==maxY) answer[3] = point;
        }
        return answer;
    }

    public static Rectangle createACircumscribedRectangle(Rectangle startRectangle){
        Point[] arrayOfSortedPoints = sortClockwise(startRectangle);
        Point p1 = new Point(arrayOfSortedPoints[0].x,arrayOfSortedPoints[1].y);
        Point p2 = new Point(arrayOfSortedPoints[2].x,arrayOfSortedPoints[1].y);
        Point p3 = new Point(arrayOfSortedPoints[2].x,arrayOfSortedPoints[3].y);
        Point p4 = new Point(arrayOfSortedPoints[0].x,arrayOfSortedPoints[3].y);
        return new Rectangle(p1,p2,p3,p4);
    }




}
