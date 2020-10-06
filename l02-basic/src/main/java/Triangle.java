public class Triangle extends Shapes {
    double a, b, c,  triangleP, triangleHalfP;
    double triangleS;

    Triangle (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Треугольник
    public double calcPerimetr() {
        //Расчет периметра(P) треугольника:
        triangleP = a + b + c;
        System.out.println("Периметр треугольника по введенным данным равен: " + triangleP);
        return triangleP;
    }

    public double calcArea() {
        //Расчет площади (S) треугольника:
        triangleHalfP = triangleP / 2;
        triangleS = Math.sqrt(triangleHalfP * (triangleHalfP - a) * (triangleHalfP - b) * (triangleHalfP - c));
        System.out.println("Площадь треугольника по введенным данным равна: " + triangleS);
        return triangleS;
    }
}