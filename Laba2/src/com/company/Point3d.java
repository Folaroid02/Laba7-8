package com.company;

//класс наследует свойства от класса Point2d
public class Point3d extends Point2d {

    private double zCord;
//установка координаты z
    //конструктор инициализации
    public Point3d(double xCord, double yCord, double z){
        //для успешного наследования методов используем super, без него все методы Point2d будут вызывать значения
        // переменных из своего класса
        super(xCord,yCord);
        this.zCord=z;
        //this показывает что используется переменная этого класса
    }
    public Point3d () {
        this (0, 0, 0);
    }

//возвращение координаты z
    public double getZ(){return zCord;};

    public void setZ(double val){zCord=val;}


    public double distanceTo(Point3d X, Point3d Y) {
       //находит расстояние между двумя точками и квадраты разностей между координатами по x y z
        float x=(float) (X.getX()-Y.getX());
        float y=(float) (X.getY()-Y.getY());
        float z=(float) (X.getZ()-Y.getZ());
        return (float) Math.sqrt(x*x + y*y + z*z);
    }
}
