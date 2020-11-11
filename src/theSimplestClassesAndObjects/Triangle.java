package theSimplestClassesAndObjects;

/*
7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления площади,
периметра и точки пересечения медиан.
 */

import java.util.Scanner;

public class Triangle {

    double sideA, sideB, sideC;

    Triangle(Mediana a, Mediana b, Mediana c){
        if(a == null || b == null || c == null) {
            System.out.println("Вы не ввели одну из координат");
        } else {
            sideA = a.distanceTo(b);
            sideB = b.distanceTo(c);
            sideC = a.distanceTo(c);
        }
        if(sideA * sideB * sideC == 0 || sideA + sideB <= sideC || sideA + sideC <= sideB ){
            System.out.println("Такого треугольника не существует");
        }
    }

    double trianglePerimeter(){
        return sideA + sideB + sideC;
    }

    double triangleSquare(Triangle triangle){
        double p = trianglePerimeter() / 2;
        return Math.sqrt(p * (p - triangle.sideA) * (p - triangle.sideB) * (p - triangle.sideC));
    }

    void triangleMediana(Mediana mediana1, Mediana mediana2, Mediana mediana3){
        double med1 = (mediana1.getX() + mediana2.getX() + mediana3.getX()) / 3;
        double med2 = (mediana1.getY() + mediana2.getY() + mediana3.getY()) / 3;
        System.out.print("Точка пересечения медиан: ");
        System.out.format("%.2f",med1);
        System.out.print(" ; ");
        System.out.format("%.2f",med2);
    }
}
class Mediana{
    double x;
    double y;

    Mediana(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distanceTo(Mediana point) {
        double temp = Math.pow(point.getX() - x, 2);
        temp += Math.pow(point.getY() - y, 2);
        return Math.sqrt(temp);
    }
}
class Program{

    static double num;

    static double numInput(){
        System.out.println("Введите координаты");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble()){
            num = sc.nextDouble();
            if(num <= 0){
                System.out.println("Введите положительные координаты");
                numInput();
            }
        } else {
            System.out.println("Вы допустили ошибку при вводе");
            numInput();
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println("Введите 6 координат точек через enter, для построения треугольника");
        Mediana a = new Mediana(numInput(),numInput());
        Mediana b = new Mediana(numInput(),numInput());
        Mediana c = new Mediana(numInput(),numInput());
        Triangle triangle = new Triangle(a, b, c);
        System.out.print("Периметр треугольника = ");
        System.out.format("%.2f", triangle.trianglePerimeter());
        System.out.println();
        System.out.print("Площадь треугольника = ");
        System.out.format("%.2f",triangle.triangleSquare(triangle));
        System.out.println();
        triangle.triangleMediana(a, b, c);

    }
}
