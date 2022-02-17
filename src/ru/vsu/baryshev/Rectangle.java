package ru.vsu.baryshev;

import java.util.ArrayList;
import java.util.List;

class Rectangle  {




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

    enum typeOfShape{
        HORIZONTAL,
        VERTICAL,
        NORMAL
    }

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Point getP1() {
        return p1;
    }
    public Point getP2() {
        return p2;
    }
    public Point getP3() {
        return p3;
    }
    public Point getP4() {
        return p4;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {

        if (((p2.getX() - p1.getX()) * (p3.getX() - p2.getX()) + (p2.getY() - p1.getY()) * (p3.getY() - p2.getY()) == 0) && ((p3.getX() - p2.getX()) * (p4.getX() - p3.getX()) + (p3.getY() - p2.getY()) * (p4.getY() - p3.getY()) == 0) && ((p4.getX() - p3.getX()) * (p1.getX() - p4.getX()) + (p4.getY() - p3.getY()) * (p1.getY() - p4.getY()) == 0)) {
            // Выше проверка на прямоугольность(через тангенс угла)
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        } else {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
            System.out.println("Не прямоугольник");
        }

    }



    public  double searchOfS() { // Поиск площади переданного прямоугольника

        double m = 0.5 * (this.p1.getX() * this.p2.getY() + this.p2.getX() * this.p3.getY() + this.p3.getX() * this.p4.getY() + this.p4.getX() * this.p1.getY() - this.p2.getX() * this.p1.getY() - this.p3.getX() * this.p2.getY() - this.p4.getX() * this.p3.getY() - this.p1.getX() * this.p4.getY());
        if (m >= 0) {
            return m;
        } else return -1 * m;
    }

    public  double searchForP() { // Поиск периметра
        return distanceBetweenPoints(this.p1, this.p2) + distanceBetweenPoints(this.p2, this.p3) + distanceBetweenPoints(this.p3, this.p4) + distanceBetweenPoints(this.p4, this.p1);
    }


    private static double distanceBetweenPoints(Point p1, Point p2) { // Поиск расстояния между точками(длины стороны прямоугольника).
        return Math.sqrt((p2.getX() - p1.getX()) * (p2.getX() - p1.getX()) + (p2.getY() - p1.getY()) * (p2.getY() - p1.getY()));
    }

    private static Point[] sortClockwise(Rectangle rec) {  // Метод сортировки точек прямоугольника в определенном порядке
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
            if (maxY <= point.getY()) maxY = point.getY();
            if (minY >= point.getY()) minY = point.getY();
            if (maxX <= point.getX()) maxX = point.getX();
            if (minX >= point.getX()) minX = point.getX();
        }


        for (Point point : startList) {   // Сортировка точек. Был выбран следующий порядок: первой точкой является верхняя левая точка фигуры, далее по часовой стрелке(отсюда название метода).
            if (point.getX() == minX && ((point.getY() - minY) <= (maxY - point.getY()))) answer[0] = point;
            if (point.getY() == minY) answer[1] = point;
            if (point.getX() == maxX) answer[2] = point;
            if (point.getY() == maxY) answer[3] = point;
        }
        return answer;

    }

    public static Rectangle createACircumscribedRectangle(Rectangle startRectangle) { // Метод по созданию описывающего прямоугольника

        Point[] arrayOfSortedPoints = sortClockwise(startRectangle); // Упорядовачиваем точки начальной фигуры соот.образом


        if (startRectangle.p1.getY() != startRectangle.p2.getY() && startRectangle.p1.getX() != startRectangle.p2.getX()) { // Случай, когда прямоугольник расположен "неровно" т.е. его стороны не параллельны осям координат.
            // Тогда проявляются преимущества сортировки по часовой стрелке

            Point p1 = new Point(arrayOfSortedPoints[0].getX(), arrayOfSortedPoints[1].getY());
            Point p2 = new Point(arrayOfSortedPoints[2].getX(), arrayOfSortedPoints[1].getY());
            Point p3 = new Point(arrayOfSortedPoints[2].getX(), arrayOfSortedPoints[3].getY());
            Point p4 = new Point(arrayOfSortedPoints[0].getX(), arrayOfSortedPoints[3].getY());

            return new Rectangle(p1, p2, p3, p4);

        } else { // Частный случай расположения фигуры: стороны параллельны осям координат

            Point p1 = new Point((arrayOfSortedPoints[0].getX() - (arrayOfSortedPoints[3].getY() - arrayOfSortedPoints[0].getY()) / 2), (arrayOfSortedPoints[3].getY() - arrayOfSortedPoints[0].getY()) / 2 + arrayOfSortedPoints[0].getY());
            Point p2 = new Point((arrayOfSortedPoints[1].getX() - arrayOfSortedPoints[0].getX()) / 2 + arrayOfSortedPoints[0].getX(), arrayOfSortedPoints[1].getY() - (arrayOfSortedPoints[1].getX() - arrayOfSortedPoints[0].getX()) / 2);
            Point p3 = new Point(arrayOfSortedPoints[1].getX() + (arrayOfSortedPoints[2].getY() - arrayOfSortedPoints[1].getY()) / 2, (arrayOfSortedPoints[2].getY() - arrayOfSortedPoints[1].getY()) / 2 + arrayOfSortedPoints[1].getY());
            Point p4 = new Point((arrayOfSortedPoints[1].getX() - arrayOfSortedPoints[0].getX()) / 2 + arrayOfSortedPoints[0].getX(), arrayOfSortedPoints[2].getY() + (arrayOfSortedPoints[2].getY() - arrayOfSortedPoints[1].getY()) / 2);
            System.out.println("Второй");

            return new Rectangle(p1, p2, p3, p4);
        }

    }

    public Rectangle moving(int deltaX,int deltaY){
        this.setP1(new Point(this.getP1().getX()+deltaX,this.getP1().getY()+deltaY));
        this.setP2(new Point(this.getP2().getX()+deltaX,this.getP2().getY()+deltaY));
        this.setP3(new Point(this.getP3().getX()+deltaX,this.getP3().getY()+deltaY));
        this.setP4(new Point(this.getP4().getX()+deltaX,this.getP4().getY()+deltaY));

        return  this;
    }

    public  Rectangle sharing(typeOfHolding type, numberOFSelected number, typeOfShape typeOfShape, int k) { // Масштабирование фигуры,передается стартовый прямоугольник,
        // тип опорной точки(точка/сторона,центр), номер выбранной точки, коэффициен масштабирования

        Point[] points = sortClockwise(this); // Сортировка точек исходной фигуры


        switch (type) { // Посколько масштабирование в разный случаях разное,

            case SIDE: { // Случай, если масштабирование проводится относительно стороны фигуры

                switch (number) {

                    case FIRST: {
                        switch (typeOfShape){
                            case NORMAL:{
                                Point p1 = new Point((points[0].getX() + (k - 1) * (points[0].getX() - points[1].getX()) / 2), (points[0].getY() + (k - 1) * (points[0].getY() - points[1].getY()) / 2));
                                Point p2 = new Point((points[1].getX() + (points[1].getX() - points[0].getX()) / 2 * (k - 1)), (points[1].getY() + (k - 1) * (points[1].getY() - points[0].getY()) / 2));
                                Point p3 = new Point((points[2].getX() + (k - 1) * (points[2].getX() - points[1].getX() + (points[1].getX() - points[0].getX()) / 2)), (points[2].getY() + (k - 1) * (points[2].getY() - points[1].getY() + (points[1].getY() - points[0].getY()) / 2)));
                                Point p4 = new Point((points[3].getX() + (k - 1) * (points[3].getX() - points[0].getX() + (points[0].getX() - points[1].getX()) / 2)), (points[3].getY() + (k - 1) * (points[3].getY() - points[0].getY() + (points[0].getY() - points[1].getY()) / 2)));

                                return new Rectangle(p1, p2, p3, p4);
                            }
                            case VERTICAL:{
                                Point p1 = points[0];
                                Point p2 = points[1];
                                Point p3 = new Point(points[2].getX(),points[2].getY()+(k-1)*(points[2].getY()-points[1].getY()));
                                Point p4 = new Point(points[3].getX(),points[3].getY()+(k-1)*(points[3].getY()-points[0].getY()));
                                return new Rectangle(p1, p2, p3, p4);


                            }
                            case HORIZONTAL:{
                                Point p1 = points[0];
                                Point p2 = points[1];
                                Point p3 = new Point(points[2].getX()+(k-1)*(points[2].getX()-points[1].getX()),points[2].getY());
                                Point p4 = new Point(points[3].getX()+(k-1)*(points[3].getX()-points[0].getX()),points[3].getY());
                                return new Rectangle(p1, p2, p3, p4);

                            }
                        }


                    }
                    case SECOND: {

                        switch (typeOfShape){
                            case NORMAL:{
                                Point p1 = new Point(points[0].getX() + (k - 1) * (points[0].getX() - points[1].getX() + (points[0].getX() - points[3].getX()) / 2), points[0].getY() + (k - 1) * (points[0].getY() - points[1].getY() + (points[0].getY() - points[3].getY()) / 2));
                                Point p2 = new Point(points[1].getX() + (k - 1) * (points[1].getX() - points[2].getX()) / 2, points[1].getY() + (k - 1) * (points[1].getY() - points[2].getY()) / 2);
                                Point p3 = new Point(points[2].getX() + (k - 1) * (points[2].getX() - points[1].getX()) / 2, points[2].getY() + (k - 1) * (points[2].getY() - points[1].getY()) / 2);
                                Point p4 = new Point(points[3].getX() + (k - 1) * (points[3].getX() - points[2].getX() + (points[3].getX() - points[0].getX()) / 2), points[3].getY() + (k - 1) * (points[3].getY() - points[2].getY() + (points[3].getY() - points[0].getY()) / 2));

                                return new Rectangle(p1, p2, p3, p4);
                            }
                            case VERTICAL:{
                                Point p1 = new Point(points[0].getX(),points[0].getY()+(k-1)*(points[0].getY()-points[1].getY()));
                                Point p2 = points[1];
                                Point p3 = points[2];
                                Point p4 = new Point(points[3].getX(),points[3].getY()+(k-1)*(points[3].getY()-points[2].getY()));

                                return new Rectangle(p1, p2, p3, p4);
                            }
                            case HORIZONTAL:{
                                Point p1 = new Point(points[0].getX()+(k-1)*(points[0].getX()-points[1].getX()),points[0].getY());
                                Point p2 = points[1];
                                Point p3 = points[2];
                                Point p4 = new Point(points[3].getX()+(k-1)*(points[3].getX()-points[2].getX()),points[3].getY());

                                return new Rectangle(p1, p2, p3, p4);

                            }
                        }

                    }
                    case THIRD: {
                        switch (typeOfShape){
                            case NORMAL:{
                                Point p1 = new Point(points[0].getX() + (k - 1) * (points[0].getX() - points[3].getX() + (points[0].getX() - points[1].getX()) / 2), points[0].getY() + (k - 1) * (points[0].getY() - points[3].getY() + (points[0].getY() - points[1].getY()) / 2));
                                Point p2 = new Point(points[1].getX() + (k - 1) * (points[1].getX() - points[2].getX() + (points[2].getX() - points[3].getX()) / 2), points[1].getY() + (k - 1) * (points[1].getY() - points[2].getY() + (points[2].getY() - points[3].getY()) / 2));
                                Point p3 = new Point(points[2].getX() + (k - 1) * (points[2].getX() - points[3].getX()) / 2, points[2].getY() + (k - 1) * (points[2].getY() - points[3].getY()) / 2);
                                Point p4 = new Point(points[3].getX() + (k - 1) * (points[3].getX() - points[2].getX()) / 2, points[3].getY() + (k - 1) * (points[3].getY() - points[2].getY()) / 2);

                                return new Rectangle(p1, p2, p3, p4);
                            }
                            case VERTICAL:{
                                Point p1 = new Point(points[0].getX(),points[0].getY()+(k-1)*(points[0].getY()-points[3].getY()));
                                Point p2 = new Point(points[1].getX(),points[1].getY()+(k-1)*(points[1].getY()-points[2].getY()));
                                Point p3 = points[2];
                                Point p4 = points[3];

                                return new Rectangle(p1, p2, p3, p4);
                            }
                            case HORIZONTAL:{
                                Point p1 = new Point(points[0].getX()+(k-1)*(points[0].getX()-points[3].getX()),points[0].getY());
                                Point p2 = new Point(points[1].getX()+(k-1)*(points[1].getX()-points[2].getX()),points[1].getY());
                                Point p3 = points[2];
                                Point p4 = points[3];

                                return new Rectangle(p1, p2, p3, p4);
                            }
                        }

                    }
                    case FORTH: {
                        switch (typeOfShape){
                            case NORMAL:{
                                Point p1 = new Point(points[0].getX() + (k - 1) * (points[0].getX() - points[3].getX()) / 2, points[0].getY() + (k - 1) * (points[0].getY() - points[3].getY()) / 2);
                                Point p2 = new Point(points[1].getX() + (k - 1) * (points[1].getX() - points[0].getX() + (points[1].getX() - points[2].getX()) / 2), points[1].getY() + (k - 1) * (points[1].getY() - points[0].getY() + (points[1].getY() - points[2].getY()) / 2));
                                Point p3 = new Point(points[2].getX() + (k - 1) * (points[2].getX() - points[3].getX() + (points[2].getX() - points[1].getX()) / 2), points[2].getY() + (k - 1) * (points[2].getY() - points[3].getY() + (points[2].getY() - points[1].getY()) / 2));
                                Point p4 = new Point(points[3].getX() + (k - 1) * (points[3].getX() - points[0].getX()) / 2, points[3].getY() + (k - 1) * (points[3].getY() - points[0].getY()) / 2);

                                return new Rectangle(p1, p2, p3, p4);

                            }
                            case VERTICAL:{
                                Point p1 = points[0];
                                Point p2 = new Point(points[1].getX(),points[1].getY()+(k-1)*(points[1].getY()-points[0].getY()));
                                Point p3 = new Point(points[2].getX(),points[2].getY()+(k-1)*(points[2].getY()-points[3].getY()));
                                Point p4 = points[3];

                                return new Rectangle(p1, p2, p3, p4);
                            }
                            case HORIZONTAL:{
                                Point p1 = points[0];
                                Point p2 = new Point(points[1].getX()+(k-1)*(points[1].getX()-points[0].getX()),points[1].getY());
                                Point p3 = new Point(points[2].getX()+(k-1)*(points[2].getX()-points[3].getX()),points[2].getY());
                                Point p4 = points[3];

                                return new Rectangle(p1, p2, p3, p4);
                            }
                        }

                    }
                }

            }
            case POINT: { // Если масштабирование относительно точки
                switch (number) {
                    case FIRST: {
                        switch (typeOfShape){
                            case HORIZONTAL:{
                                Point p1 = points[0];
                                Point p2 = new Point(points[1].getX() + (k-1)*(points[1].getX()-points[0].getX()),points[1].getY());
                                Point p3 = new Point(points[2].getX() + (k-1)*(points[2].getX()-points[0].getX()),points[2].getY());
                                Point p4 = new Point(points[3].getX() + (k-1)*(points[3].getX()-points[0].getX()),points[3].getY());

                                return new Rectangle(p1, p2, p3, p4);

                            }case VERTICAL:{
                                Point p1 = points[0];
                                Point p2 = new Point(points[1].getX() ,points[1].getY()+ (k-1)*(points[1].getY()-points[0].getY()));
                                Point p3 = new Point(points[2].getX() ,points[2].getY()+ (k-1)*(points[2].getY()-points[0].getY()));
                                Point p4 = new Point(points[3].getX() ,points[3].getY()+ (k-1)*(points[3].getY()-points[0].getY()));

                                return new Rectangle(p1, p2, p3, p4);
                            } case NORMAL:{
                                Point p1 = points[0];
                                Point p2 = new Point(points[1].getX() + (k - 1) * (points[1].getX() - points[0].getX()), points[1].getY() + (k - 1) * ((points[1].getY() - points[0].getY())));
                                Point p3 = new Point(points[2].getX() + (k - 1) * (points[2].getX() - points[1].getX() + points[2].getX() - points[3].getX()), points[2].getY() + (k - 1) * (points[2].getY() - points[1].getY() + points[2].getY() - points[3].getY()));
                                Point p4 = new Point(points[3].getX() + (k - 1) * (points[3].getX() - points[0].getX()), points[3].getY() + (k - 1) * (points[3].getY() - points[0].getY()));

                                return new Rectangle(p1, p2, p3, p4);
                            }
                        }


                    }
                    case SECOND: {
                        switch (typeOfShape){
                            case HORIZONTAL:{
                                Point p1 = new Point(points[0].getX()+(k-1)*(points[0].getX()-points[1].getX()),points[0].getY());
                                Point p2 = points[1];
                                Point p3 = new Point(points[2].getX()+(k-1)*(points[2].getX()-points[1].getX()),points[2].getY());
                                Point p4 = new Point(points[3].getX()+(k-1)*(points[3].getX()-points[1].getX()),points[3].getY());

                                return new Rectangle(p1, p2, p3, p4);

                            }case VERTICAL:{
                                Point p1 = new Point(points[0].getX(),points[0].getY()+(k-1)*(points[0].getY()-points[1].getY()));
                                Point p2 = points[1];
                                Point p3 = new Point(points[2].getX(),points[2].getY()+(k-1)*(points[2].getY()-points[1].getY()));
                                Point p4 = new Point(points[3].getX(),points[3].getY()+(k-1)*(points[3].getY()-points[1].getY()));

                                return new Rectangle(p1, p2, p3, p4);

                            } case NORMAL:{
                                Point p1 = new Point(points[0].getX() + (k - 1) * (points[0].getX() - points[1].getX()), points[0].getY() + (k - 1) * (points[0].getY() - points[1].getY()));
                                Point p2 = points[1];
                                Point p3 = new Point(points[2].getX() + (k - 1) * (points[2].getX() - points[1].getX()), points[2].getY() + (k - 1) * (points[2].getY() - points[1].getY()));
                                Point p4 = new Point(points[3].getX() + (k - 1) * (points[3].getX() - points[0].getX() + (points[3].getX() - points[2].getX())), points[3].getY() + (k - 1) * (points[3].getY() - points[0].getY() + (points[3].getY() - points[2].getY())));

                                return new Rectangle(p1, p2, p3, p4);
                            }
                        }


                    }
                    case THIRD: {
                        switch (typeOfShape){

                            case HORIZONTAL:{
                                Point p1 = new Point(points[0].getX() + (k-1)*(points[0].getX()-points[2].getX()),points[0].getY());
                                Point p2 = new Point(points[1].getX() + (k-1)*(points[1].getX()-points[2].getX()),points[1].getY());
                                Point p3 = points[2];
                                Point p4 = new Point(points[3].getX() + (k-1)*(points[3].getX()-points[2].getX()),points[3].getY());

                                return new Rectangle(p1, p2, p3, p4);

                            }case VERTICAL:{
                                Point p1 = new Point(points[0].getX() ,points[0].getY()+ (k-1)*(points[0].getY()-points[2].getY()));
                                Point p2 = new Point(points[1].getX() ,points[1].getY()+ (k-1)*(points[1].getY()-points[2].getY()));
                                Point p3 = points[2];
                                Point p4 = new Point(points[3].getX() ,points[3].getY()+ (k-1)*(points[3].getY()-points[2].getY()));

                                return new Rectangle(p1, p2, p3, p4);
                            } case NORMAL:{
                                Point p1 = new Point(points[0].getX() + (k - 1) * (points[0].getX() - points[3].getX() + points[0].getX() - points[1].getX()), points[0].getY() + (k - 1) * (points[0].getY() - points[3].getY() + points[0].getY() - points[1].getY()));
                                Point p2 = new Point(points[1].getX() + (k - 1) * (points[1].getX() - points[2].getX()), points[1].getY() + (k - 1) * (points[1].getY() - points[2].getY()));
                                Point p3 = points[2];
                                Point p4 = new Point(points[3].getX() + (k - 1) * (points[3].getX() - points[2].getX()), points[3].getY() + (k - 1) * (points[3].getY() - points[2].getY()));

                                return new Rectangle(p1, p2, p3, p4);
                            }
                        }




                    }
                    case FORTH: {
                        switch (typeOfShape){

                            case HORIZONTAL:{
                                Point p1 = new Point(points[0].getX() + (k-1)*(points[0].getX()-points[3].getX()),points[0].getY());
                                Point p2 = new Point(points[1].getX() + (k-1)*(points[1].getX()-points[3].getX()),points[1].getY());
                                Point p3 = new Point(points[2].getX() + (k-1)*(points[2].getX()-points[3].getX()),points[2].getY());
                                Point p4 = points[3];

                                return new Rectangle(p1, p2, p3, p4);

                            }case VERTICAL:{
                                Point p1 = new Point(points[0].getX() ,points[0].getY()+ (k-1)*(points[0].getY()-points[3].getY()));
                                Point p2 = new Point(points[1].getX() ,points[1].getY()+ (k-1)*(points[1].getY()-points[3].getY()));
                                Point p3 = new Point(points[2].getX() ,points[2].getY()+ (k-1)*(points[2].getY()-points[3].getY()));
                                Point p4 = points[3];

                                return new Rectangle(p1, p2, p3, p4);
                            } case NORMAL:{
                                Point p1 = new Point(points[0].getX() + (k - 1) * (points[0].getX() - points[3].getX()), points[0].getY() + (k - 1) * (points[0].getY() - points[3].getY()));
                                Point p2 = new Point(points[1].getX() + (k - 1) * (points[1].getX() - points[2].getX() + points[1].getX() - points[0].getX()), points[1].getY() + (k - 1) * (points[1].getY() - points[2].getY() + points[1].getY() - points[0].getY()));
                                Point p3 = new Point(points[2].getX() + (k - 1) * (points[2].getX() - points[3].getX()), points[2].getY() + (k - 1) * (points[2].getY() - points[3].getY()));
                                Point p4 = points[3];

                                return new Rectangle(p1, p2, p3, p4);
                            }
                        }

                    }
                }

            }
            case CENTER: { // Масштабирование относительно центра
                switch (typeOfShape){
                    case NORMAL:{
                        int horizontalDeltaX = (points[2].getX() - points[0].getX()) / 2;
                        int horizontalDeltaY = (points[2].getY() - points[0].getY()) / 2;
                        int verticalDeltaX = (points[3].getX() - points[1].getX()) / 2;
                        int verticalDeltaY = (points[3].getY() - points[1].getY()) / 2;

                        Point p1 = new Point(points[0].getX() - (k - 1) * horizontalDeltaX, points[0].getY() - (k - 1) * horizontalDeltaY);
                        Point p2 = new Point(points[1].getX() - (k - 1) * verticalDeltaX, points[1].getY() - (k - 1) * verticalDeltaY);
                        Point p3 = new Point(points[2].getX() + (k - 1) * horizontalDeltaX, points[2].getY() + (k - 1) * horizontalDeltaY);
                        Point p4 = new Point(points[3].getX() + (k - 1) * verticalDeltaX, points[3].getY() + (k - 1) * verticalDeltaY);

                        return new Rectangle(p1, p2, p3, p4);

                    }
                    case VERTICAL:{
                        int horizontalDeltaX = (points[2].getX() - points[0].getX()) / 2;
                        int horizontalDeltaY = (points[2].getY() - points[0].getY()) / 2;
                        int verticalDeltaX = (points[3].getX() - points[1].getX()) / 2;
                        int verticalDeltaY = (points[3].getY() - points[1].getY()) / 2;

                        Point p1 = new Point(points[0].getX(), points[0].getY() - (k - 1) * horizontalDeltaY);
                        Point p2 = new Point(points[1].getX(), points[1].getY() - (k - 1) * verticalDeltaY);
                        Point p3 = new Point(points[2].getX(), points[2].getY() + (k - 1) * horizontalDeltaY);
                        Point p4 = new Point(points[3].getX(), points[3].getY() + (k - 1) * verticalDeltaY);

                        return new Rectangle(p1, p2, p3, p4);
                    }
                    case HORIZONTAL:{
                        int horizontalDeltaX = (points[2].getX() - points[0].getX()) / 2;
                        int horizontalDeltaY = (points[2].getY() - points[0].getY()) / 2;
                        int verticalDeltaX = (points[3].getX() - points[1].getX()) / 2;
                        int verticalDeltaY = (points[3].getY() - points[1].getY()) / 2;

                        Point p1 = new Point(points[0].getX() - (k - 1) * horizontalDeltaX, points[0].getY());
                        Point p2 = new Point(points[1].getX() - (k - 1) * verticalDeltaX, points[1].getY());
                        Point p3 = new Point(points[2].getX() + (k - 1) * horizontalDeltaX, points[2].getY());
                        Point p4 = new Point(points[3].getX() + (k - 1) * verticalDeltaX, points[3].getY());

                        return new Rectangle(p1, p2, p3, p4);
                    }
                }


            }
        }
        return null;
    }

}
