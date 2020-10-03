public class Rectangle extends Shapes {

    //Прямоугольник
    int a, b, rectangleP, rectangleS;

    @Override
    public int calcPerimetr(int a, int b) {
        this.a = a;
        this.b = b;
        //Расчет периметра(P) прямоугольника:
        rectangleP = 2 * (a + b);
        System.out.println("Периметр прямоугольника по введенным данным равен: " + rectangleP);
        return rectangleP;
    }

    @Override
    public int calcArea(int a, int b) {
        this.a = a;
        this.b = b;
        //Расчет площади (S) прямоугольника:
        rectangleS = a * b;
        System.out.println("Площадь прямоугольника по введенным данным равна: " + rectangleS);
        return rectangleS;
    }
}