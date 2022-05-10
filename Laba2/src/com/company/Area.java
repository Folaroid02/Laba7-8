package com.company;

import java.util.Scanner;

public class Area {

    public static void main(String[] args) {
        Scanner coords = new Scanner(System.in);

        double[] c1 = new double[3];
        double[] c2 = new double[3];
        double[] c3 = new double[3];

        for (int i=0;i<3;i++)
            c1[i]=coords.nextDouble();
        for (int i=0;i<3;i++)
            c2[i]=coords.nextDouble();
        for (int i=0;i<3;i++)
            c3[i]=coords.nextDouble();
        coords.close();

        Point3d pointA = new Point3d(c1[0], c1[1], c1[2]);
        Point3d pointB = new Point3d(c2[0], c2[1], c2[2]);
        Point3d pointC = new Point3d(c3[0], c3[1], c3[2]);

        if (((c1[0]==c2[0])&(c1[1]==c2[1])&(c1[2]==c2[2]))|((c1[0]==c3[0])&(c1[1]==c3[1])&(c1[2]==c3[2]))| ((c2[0]==c3[0])&(c2[1]==c3[1])&(c2[2]==c3[2]))){
            System.out.println("Точки совпадают, введите снова");
        }
        else {
            System.out.println("Area = "+ computeArea(pointA,pointB,pointC));
        }

    }
        public static double computeArea(Point3d pointA,Point3d pointB,Point3d pointC ) {
        //вычисляем стороны треугольника
        double a = pointA.distanceTo(pointA,pointB);
        double b = pointB.distanceTo(pointB,pointC);
        double c = pointA.distanceTo(pointA,pointC);
       //вычисляем полуперимерт
        double p =(a+b+c)/2;
        //по формуле Герона считаем площадь и округляем до сотых
        double v = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return Math.round(v * 100) / 100.0;
        }

}
