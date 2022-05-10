package com.company;


public class Point2d {

    private double xCord;

    private double yCord;

    public Point2d ( double x, double y) {
        xCord = x;
        yCord = y;
    }

    public Point2d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }

    public double getX () {
        return xCord;
    }

    public double getY () {
        return yCord;
    }

    public void setX ( double val) {
        xCord = val;
    }

    public void setY ( double val) {
        yCord = val;
    }
}
