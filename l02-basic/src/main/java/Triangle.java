public class Triangle extends Shapes {
    double a, b, c;
    private double triangleHalfP;

    Triangle (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //Треугольник
    public double calcPerimetr() {
        //Расчет периметра(P) треугольника:
        System.out.println("Периметр треугольника по введенным данным равен: " + (a + b + c));
        return a + b + c;
    }

    public double calcArea() {
        //Расчет площади (S) треугольника:
        triangleHalfP = (a + b + c) / 2;
        System.out.println("Площадь треугольника по введенным данным равна: " + Math.sqrt(triangleHalfP * (triangleHalfP - a) * (triangleHalfP - b) * (triangleHalfP - c)));
        return Math.sqrt(triangleHalfP * (triangleHalfP - a) * (triangleHalfP - b) * (triangleHalfP - c));
    }
}