package ru.vsu.baryshev;

import java.util.ArrayList;
import java.util.List;

class Rectangle {

    static final class Point {
        protected int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    enum typeOfHolding {
        POINT,
        SIDE,
        CENTER
    }


    enum numberOFSelected {
        FIRST,
        SECOND,
        THIRD,
        FORTH
    }

    public Point p1;
    public Point p2;
    public Point p3;
    public Point p4;


    public Rectangle(Point p1, Point p2, Point p3, Point p4) {

        if (((p2.x - p1.x) * (p3.x - p2.x) + (p2.y - p1.y) * (p3.y - p2.y) == 0) && ((p3.x - p2.x) * (p4.x - p3.x) + (p3.y - p2.y) * (p4.y - p3.y) == 0) && ((p4.x - p3.x) * (p1.x - p4.x) + (p4.y - p3.y) * (p1.y - p4.y) == 0)) {
            // Выше проверка на прямоугольность(через тангенс угла)
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


    public static double searchOfS(Rectangle rec) { // Поиск площади переданного прямоугольника

        double m = 0.5 * (rec.p1.x * rec.p2.y + rec.p2.x * rec.p3.y + rec.p3.x * rec.p4.y + rec.p4.x * rec.p1.y - rec.p2.x * rec.p1.y - rec.p3.x * rec.p2.y - rec.p4.x * rec.p3.y - rec.p1.x * rec.p4.y);
        if (m >= 0) {
            return m;
        } else return -1 * m;
    }

    public static double searchForP(Rectangle rec) { // Поиск периметра
        return distanceBetweenPoints(rec.p1, rec.p2) + distanceBetweenPoints(rec.p2, rec.p3) + distanceBetweenPoints(rec.p3, rec.p4) + distanceBetweenPoints(rec.p4, rec.p1);
    }

    public static double distanceBetweenPoints(Point p1, Point p2) { // Поиск расстояния между точками(длины стороны прямоугольника).
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    public static Point[] sortClockwise(Rectangle rec) {  // Метод сортировки точек прямоугольника в определенном порядке
        //Необходимо для масштабирования и описывания фигуры т.к., по причине отсутствия универсальной мат.формулы и т.п., необходим четкий порядок точек.

        Point p1 = rec.p1;
        Point p2 = rec.p2;
        Point p3 = rec.p3;
        Point p4 = rec.p4;

        List<Point> startList = new ArrayList<>(); //Заносим точки фигуры в список с целью дальнейшего перебора содержимого списка(осуществлять перебор в Rectangle невозможно
        startList.add(p1);
        startList.add(p2);
        startList.add(p3);
        startList.add(p4);

        Point[] answer = new Point[4]; // Массив на 4-ре объекта, который и будет конечным ответом

        //Создаются переменные под поиск максимального и минимального значений, подразумевается, что фигура не выходит за рамки поля т.е. все точки в диапазоне [0;400]
        double maxY = 0;
        double minY = 400;
        double maxX = 0;
        double minX = 400;

        for (Point point : startList) {   // Поиск максимального/минимального значений абсциссы/ординаты, по ним будет осуществлять сортировка точек.
            if (maxY <= point.y) maxY = point.y;
            if (minY >= point.y) minY = point.y;
            if (maxX <= point.x) maxX = point.x;
            if (minX >= point.x) minX = point.x;
        }


        for (Point point : startList) {   // Сортировка точек. Был выбран следующий порядок: первой точкой является верхняя левая точка фигуры, далее по часовой стрелке(отсюда название метода).
            if (point.x == minX && ((point.y - minY) <= (maxY - point.y))) answer[0] = point;
            if (point.y == minY) answer[1] = point;
            if (point.x == maxX) answer[2] = point;
            if (point.y == maxY) answer[3] = point;
        }
        return answer;

    }

    public static Rectangle createACircumscribedRectangle(Rectangle startRectangle) { // Метод по созданию описывающего прямоугольника

        Point[] arrayOfSortedPoints = sortClockwise(startRectangle); // Упорядовачиваем точки начальной фигуры соот.образом


        if (startRectangle.p1.y != startRectangle.p2.y && startRectangle.p1.x != startRectangle.p2.x) { // Случай, когда прямоугольник расположен "неровно" т.е. его стороны не параллельны осям координат.
                                                                                                        // Тогда проявляются преимущества сортировки по часовой стрелке

            Point p1 = new Point(arrayOfSortedPoints[0].x, arrayOfSortedPoints[1].y);
            Point p2 = new Point(arrayOfSortedPoints[2].x, arrayOfSortedPoints[1].y);
            Point p3 = new Point(arrayOfSortedPoints[2].x, arrayOfSortedPoints[3].y);
            Point p4 = new Point(arrayOfSortedPoints[0].x, arrayOfSortedPoints[3].y);

            return new Rectangle(p1, p2, p3, p4);

        } else { // Частный случай расположения фигуры: стороны параллельны осям координат

            Point p1 = new Point((arrayOfSortedPoints[0].x - (arrayOfSortedPoints[3].y - arrayOfSortedPoints[0].y) / 2), (arrayOfSortedPoints[3].y - arrayOfSortedPoints[0].y) / 2 + arrayOfSortedPoints[0].y);
            Point p2 = new Point((arrayOfSortedPoints[1].x - arrayOfSortedPoints[0].x) / 2 + arrayOfSortedPoints[0].x, arrayOfSortedPoints[1].y - (arrayOfSortedPoints[1].x - arrayOfSortedPoints[0].x) / 2);
            Point p3 = new Point(arrayOfSortedPoints[1].x + (arrayOfSortedPoints[2].y - arrayOfSortedPoints[1].y) / 2, (arrayOfSortedPoints[2].y - arrayOfSortedPoints[1].y) / 2 + arrayOfSortedPoints[1].y);
            Point p4 = new Point((arrayOfSortedPoints[1].x - arrayOfSortedPoints[0].x) / 2 + arrayOfSortedPoints[0].x, arrayOfSortedPoints[2].y + (arrayOfSortedPoints[2].y - arrayOfSortedPoints[1].y) / 2);
            System.out.println("Второй");

            return new Rectangle(p1, p2, p3, p4);
        }

    }


    public static Rectangle moving(Rectangle startRectangle, typeOfHolding type, numberOFSelected number, int k) { // Масштабирование фигуры,передается стартовый прямоугольник,
                                                                                                // тип опорной точки(точка/сторона,центр), номер выбранной точки, коэффициен масштабирования

        Point[] points = sortClockwise(startRectangle); // Сортировка точек исходной фигуры


        switch (type) { // Посколько масштабирование в разный случаях разное,

            case SIDE: { // Случай, если масштабирование проводится относительно стороны фигуры

                switch (number) {

                    case FIRST: {
                        Point p1 = new Point((points[0].x + (k - 1) * (points[0].x - points[1].x) / 2), (points[0].y + (k - 1) * (points[0].y - points[1].y) / 2));
                        Point p2 = new Point((points[1].x + (points[1].x - points[0].x) / 2 * (k - 1)), (points[1].y + (k - 1) * (points[1].y - points[0].y) / 2));
                        Point p3 = new Point((points[2].x + (k - 1) * (points[2].x - points[1].x + (points[1].x - points[0].x) / 2)), (points[2].y + (k - 1) * (points[2].y - points[1].y + (points[1].y - points[0].y) / 2)));
                        Point p4 = new Point((points[3].x + (k - 1) * (points[3].x - points[0].x + (points[0].x - points[1].x) / 2)), (points[3].y + (k - 1) * (points[3].y - points[0].y + (points[0].y - points[1].y) / 2)));

                        return new Rectangle(p1, p2, p3, p4);

                    }
                    case SECOND: {


                        Point p1 = new Point(points[0].x + (k - 1) * (points[0].x - points[1].x + (points[0].x - points[3].x) / 2), points[0].y + (k - 1) * (points[0].y - points[1].y + (points[0].y - points[3].y) / 2));
                        Point p2 = new Point(points[1].x + (k - 1) * (points[1].x - points[2].x) / 2, points[1].y + (k - 1) * (points[1].y - points[2].y) / 2);
                        Point p3 = new Point(points[2].x + (k - 1) * (points[2].x - points[1].x) / 2, points[2].y + (k - 1) * (points[2].y - points[1].y) / 2);
                        Point p4 = new Point(points[3].x + (k - 1) * (points[3].x - points[2].x + (points[3].x - points[0].x) / 2), points[3].y + (k - 1) * (points[3].y - points[2].y + (points[3].y - points[0].y) / 2));

                        return new Rectangle(p1, p2, p3, p4);
                    }
                    case THIRD: {
                        Point p1 = new Point(points[0].x + (k - 1) * (points[0].x - points[3].x + (points[0].x - points[1].x) / 2), points[0].y + (k - 1) * (points[0].y - points[3].y + (points[0].y - points[1].y) / 2));
                        Point p2 = new Point(points[1].x + (k - 1) * (points[1].x - points[2].x + (points[2].x - points[3].x) / 2), points[1].y + (k - 1) * (points[1].y - points[2].y + (points[2].y - points[3].y) / 2));
                        Point p3 = new Point(points[2].x + (k - 1) * (points[2].x - points[3].x) / 2, points[2].y + (k - 1) * (points[2].y - points[3].y) / 2);
                        Point p4 = new Point(points[3].x + (k - 1) * (points[3].x - points[2].x) / 2, points[3].y + (k - 1) * (points[3].y - points[2].y) / 2);

                        return new Rectangle(p1, p2, p3, p4);

                    }
                    case FORTH: {
                        Point p1 = new Point(points[0].x + (k - 1) * (points[0].x - points[3].x) / 2, points[0].y + (k - 1) * (points[0].y - points[3].y) / 2);
                        Point p2 = new Point(points[1].x + (k - 1) * (points[1].x - points[0].x + (points[1].x - points[2].x) / 2), points[1].y + (k - 1) * (points[1].y - points[0].y + (points[1].y - points[2].y) / 2));
                        Point p3 = new Point(points[2].x + (k - 1) * (points[2].x - points[3].x + (points[2].x - points[1].x) / 2), points[2].y + (k - 1) * (points[2].y - points[3].y + (points[2].y - points[1].y) / 2));
                        Point p4 = new Point(points[3].x + (k - 1) * (points[3].x - points[0].x) / 2, points[3].y + (k - 1) * (points[3].y - points[0].y) / 2);

                        return new Rectangle(p1, p2, p3, p4);

                    }
                }

            }
            case POINT: { // Если масштабирование относительно точки
                switch (number) {
                    case FIRST: {

                        Point p1 = points[0];
                        Point p2 = new Point(points[1].x + (k - 1) * (points[1].x - points[0].x), points[1].y + (k - 1) * ((points[1].y - points[0].y)));
                        Point p3 = new Point(points[2].x + (k - 1) * (points[2].x - points[1].x + points[2].x - points[3].x), points[2].y + (k - 1) * (points[2].y - points[1].y + points[2].y - points[3].y));
                        Point p4 = new Point(points[3].x + (k - 1) * (points[3].x - points[0].x), points[3].y + (k - 1) * (points[3].y - points[0].y));

                        return new Rectangle(p1, p2, p3, p4);

                    }
                    case SECOND: {

                        Point p1 = new Point(points[0].x + (k - 1) * (points[0].x - points[1].x), points[0].y + (k - 1) * (points[0].y - points[1].y));
                        Point p2 = points[1];
                        Point p3 = new Point(points[2].x + (k - 1) * (points[2].x - points[1].x), points[2].y + (k - 1) * (points[2].y - points[1].y));
                        Point p4 = new Point(points[3].x + (k - 1) * (points[3].x - points[0].x + (points[3].x - points[2].x)), points[3].y + (k - 1) * (points[3].y - points[0].y + (points[3].y - points[2].y)));

                        return new Rectangle(p1, p2, p3, p4);

                    }
                    case THIRD: {

                        Point p1 = new Point(points[0].x + (k - 1) * (points[0].x - points[3].x + points[0].x - points[1].x), points[0].y + (k - 1) * (points[0].y - points[3].y + points[0].y - points[1].y));
                        Point p2 = new Point(points[1].x + (k - 1) * (points[1].x - points[2].x), points[1].y + (k - 1) * (points[1].y - points[2].y));
                        Point p3 = points[2];
                        Point p4 = new Point(points[3].x + (k - 1) * (points[3].x - points[2].x), points[3].y + (k - 1) * (points[3].y - points[2].y));

                        return new Rectangle(p1, p2, p3, p4);

                    }
                    case FORTH: {

                        Point p1 = new Point(points[0].x + (k - 1) * (points[0].x - points[3].x), points[0].y + (k - 1) * (points[0].y - points[3].y));
                        Point p2 = new Point(points[1].x + (k - 1) * (points[1].x - points[2].x + points[1].x - points[0].x), points[1].y + (k - 1) * (points[1].y - points[2].y + points[1].y - points[0].y));
                        Point p3 = new Point(points[2].x + (k - 1) * (points[2].x - points[3].x), points[2].y + (k - 1) * (points[2].y - points[3].y));
                        Point p4 = points[3];

                        return new Rectangle(p1, p2, p3, p4);

                    }
                }

            }
            case CENTER: { // Масштабирование относительно центра

                int horizontalDeltaX = (points[2].x - points[0].x) / 2;
                int horizontalDeltaY = (points[2].y - points[0].y) / 2;
                int verticalDeltaX = (points[3].x - points[1].x) / 2;
                int verticalDeltaY = (points[3].y - points[1].y) / 2;

                Point p1 = new Point(points[0].x - (k - 1) * horizontalDeltaX, points[0].y - (k - 1) * horizontalDeltaY);
                Point p2 = new Point(points[1].x - (k - 1) * verticalDeltaX, points[1].y - (k - 1) * verticalDeltaY);
                Point p3 = new Point(points[2].x + (k - 1) * horizontalDeltaX, points[2].y + (k - 1) * horizontalDeltaY);
                Point p4 = new Point(points[3].x + (k - 1) * verticalDeltaX, points[3].y + (k - 1) * verticalDeltaY);

                return new Rectangle(p1, p2, p3, p4);
            }
        }
        return null;
    }

}
