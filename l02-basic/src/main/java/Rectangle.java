public class Rectangle extends Shapes {
    double a, b, rectangleP, rectangleS;

    Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    //Прямоугольник
    public double calcPerimetr() {
        //Расчет периметра(P) прямоугольника:
        rectangleP = 2 * (a + b);
        System.out.println("Периметр прямоугольника по введенным данным равен: " + rectangleP);
        return rectangleP;
    }

    public double calcArea() {
        //Расчет площади (S) прямоугольника:
        rectangleS = a * b;
        System.out.println("Площадь прямоугольника по введенным данным равна: " + rectangleS);
        return rectangleS;
    }

}