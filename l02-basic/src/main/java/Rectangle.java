public class Rectangle extends Shapes {
    double a, b;

    Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    //Прямоугольник
    public double calcPerimetr() {
        //Расчет периметра(P) прямоугольника:
        System.out.println("Периметр прямоугольника по введенным данным равен: " + 2 * (a + b));
        return 2 * (a + b);
    }

    public double calcArea() {
        //Расчет площади (S) прямоугольника:
        System.out.println("Площадь прямоугольника по введенным данным равна: " + a * b);
        return a * b;
    }

}